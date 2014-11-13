/**
 * This file may be open source, 
 * but that does not mean you own it. 
 * Contact me at https://github.com/Phasesaber .
 */
package xyz._5th.dimensions.api.event;

import java.beans.EventHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import xyz._5th.dimensions.api.Dimensions;
import xyz._5th.dimensions.api.plugin.Plugin;

/**
 * Project: Dimensions
 * 
 * File: EventFactory.java
 * 
 * @author Phase(Jadon Fowler) on Nov 13, 2014
 */
public class EventFactory {

	private ExecutorService threadPool;
	private ConcurrentHashMap<Class<? extends Event>, ArrayList<PluginMethodPair>> eventMap = new ConcurrentHashMap<Class<? extends Event>, ArrayList<PluginMethodPair>>();

	public EventFactory() {
		if (threadPool != null)
			throw new RuntimeException("Thread Pool is already initialized");
		threadPool = Executors.newFixedThreadPool(Dimensions.getServer()
				.getConfig().getPluginEventThreads());
	}

	@SuppressWarnings("unchecked")
	public void registerCatcher(Plugin p, EventHandler h) {
		Method[] methods = h.getClass().getMethods();
		for (int i = 0; i < methods.length; i++) {
			if (methods[i].getName().equals("equals")
					|| methods[i].getName().equals("wait"))
				continue;
			Class<?>[] parameters = methods[i].getParameterTypes();
			if (parameters.length != 1)
				continue;
			if (parameters[0].getSuperclass() == Event.class)
				continue;
			ArrayList<PluginMethodPair> methodList = eventMap
					.get(parameters[0]);
			if (methodList == null) {
				methodList = new ArrayList<PluginMethodPair>();
				synchronized (eventMap) {
					eventMap.put((Class<? extends Event>) parameters[0],
							methodList);
				}
			}
			synchronized (methodList) {
				methodList.add(new PluginMethodPair(p, methods[i]));
			}
		}
	}

	public void callEvent(final Event e, final Runnable fin) {
		ArrayList<PluginMethodPair> hooks = eventMap.get(e.getClass());
		if (hooks == null) {
			if (fin != null) {
				threadPool.submit(fin);
			}
			return;
		}
		PluginMethodPair[] methods;
		synchronized (hooks) {
			methods = hooks.toArray(new PluginMethodPair[hooks.size()]);
		}
		final PluginMethodPair[] methodList = methods;
		threadPool.submit(new Runnable() {
			public void run() {
				for (int i = 0; i < methodList.length; i++) {
					try {
						methodList[i].getMethod().invoke(
								methodList[i].getPlugin(), e);
					} catch (Exception e) {
						e.printStackTrace();
						try {
							methodList[i].getPlugin().handleException(e);
						} catch (Exception e2) {
							e2.printStackTrace();
						}
					}
				}
				if (fin != null)
					fin.run();
			}
		});
	}

	public void destroyThreadPool() {
		threadPool.shutdown();
		try {
			threadPool.awaitTermination(1000 * 30, TimeUnit.MILLISECONDS);
			System.out.println("Plugin thread pool has been shut down.");
		} catch (Exception e) {
			System.out
					.println("WARNING! Can't shut down plugin threads! Is a plugin blocking an event?");
		}
	}

}
