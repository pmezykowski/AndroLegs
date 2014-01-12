package androlegs.mvcs.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import androlegs.app.AndrolegsApp;
import androlegs.mvcs.event.FlashyEvent;


import de.greenrobot.event.EventBus;

public class CommandMap implements ICommandMap {

	protected HashMap<String, 
		HashMap<Class<? extends FlashyEvent>, List<RouteEventToCommandClass>>> eventTypeMap; 
	
	protected EventBus eventBus;
	
	protected AndrolegsApp appBase;
	
	public CommandMap (EventBus bus, AndrolegsApp app) {
		this.eventBus = bus;
		this.appBase = app;
		bus.register(this);
		eventTypeMap = new HashMap<String, HashMap<Class<? extends FlashyEvent>,List<RouteEventToCommandClass>>>();
	}
	
	public void mapEvent(String eventType, Class<? extends CommandBase<? extends FlashyEvent>> commandClass, Class<? extends FlashyEvent> eventClass) {
		mapEvent(eventType, commandClass, eventClass, false);
	}
	
	public void mapEvent(String eventType, Class<? extends CommandBase<? extends FlashyEvent>> commandClass, Class<? extends FlashyEvent> eventClass, boolean oneShot) {
		
		HashMap<Class<? extends FlashyEvent>,List<RouteEventToCommandClass>> eventClassMap = eventTypeMap.get(eventType);
		
		if (eventClassMap == null)
		{
			eventClassMap = new HashMap<Class<? extends FlashyEvent>, List<RouteEventToCommandClass>>();
			eventTypeMap.put(eventType, eventClassMap);
		}
		
		//TODO: warn duplicate mapping
		List<RouteEventToCommandClass> routesList = eventClassMap.get(eventClass);
		if (routesList == null) {
			routesList = new ArrayList<RouteEventToCommandClass>();
			eventClassMap.put(eventClass, routesList);
		}
		
		routesList.add(new RouteEventToCommandClass(eventType, commandClass, eventClass, oneShot));
	}
		
	public void unMapEvent (String eventType, Class<? extends CommandBase<? extends FlashyEvent>> commandClass, Class<? extends FlashyEvent> eventClass) {
		//TODO: checking of mapping existing
		HashMap<Class<? extends FlashyEvent>,List<RouteEventToCommandClass>> eventClassMap = eventTypeMap.get(eventType);
		
		if (eventClassMap == null)
			return;
		
		List<RouteEventToCommandClass> routesList = eventClassMap.get(eventClass);
		if (routesList == null) 
			return;
		
		//TODO: faster removing
		RouteEventToCommandClass route;
		
		for (int i = routesList.size() -1; i>=0 ; i--)
		{
			route = routesList.get(i);
			if (route.commandClass == commandClass) {
				routesList.remove(i);
			}
		}
		
		if (routesList.isEmpty()) {
			eventClassMap.remove(eventClass);
		}
		
		if (eventClassMap.isEmpty()) {
			eventTypeMap.remove(eventClassMap);
		}
	}
	
	public boolean execute(Class<? extends CommandBase<? extends FlashyEvent>> commandClass, FlashyEvent event) {
				
		try {
			CommandBase<? extends FlashyEvent> command = commandClass.newInstance();
			appBase.inject(command);
			command.setEventBus(eventBus);
			command.setEvent(event);
			command.execute();
			
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		return true;
		
	}
	
	public void onEvent(FlashyEvent event) {
		Class<? extends FlashyEvent> eventClass = event.getClass();
		String eventType = event.getType();
		
		HashMap<Class<? extends FlashyEvent>, List<RouteEventToCommandClass>> eventClassMap = eventTypeMap.get(eventType);
		if (eventClassMap == null) {
			return;
		}

		List<RouteEventToCommandClass> routeList = eventClassMap.get(eventClass);
		if (routeList == null)
			return;
		
		for (RouteEventToCommandClass route : routeList) {
			execute(route.commandClass, event);
			
			if (route.oneShot)
				unMapEvent(eventType, route.commandClass, eventClass);
		}
		
	}
	
}

class RouteEventToCommandClass {
	
	public boolean oneShot;
	
	public String eventType;
	public Class<? extends CommandBase<? extends FlashyEvent>> commandClass;
	public Class<? extends FlashyEvent> eventClass;
	
	public RouteEventToCommandClass(String eventType,
			Class<? extends CommandBase<? extends FlashyEvent>> commandClass,
			Class<? extends FlashyEvent> eventClass, boolean oneShot) {
		super();
		this.oneShot = oneShot;
		this.eventType = eventType;
		this.commandClass = commandClass;
		this.eventClass = eventClass;
	}
	
	
}

