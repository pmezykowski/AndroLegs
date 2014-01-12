package model;

import java.util.ArrayList;
import java.util.Collections;

import javax.inject.Inject;
import javax.inject.Singleton;

import android.content.Context;
import androlegs.mvcs.actor.Actor;
import androlegs.mvcs.event.FlashyEvent;

import notifications.DemoNotifications;

import de.greenrobot.event.EventBus;

@Singleton	
public class RoboDemoModel extends Actor {

	private ArrayList<String> dataList;
	
	@Inject
	public RoboDemoModel(EventBus eventBus, Context appContext) {
		super(eventBus, appContext);
		dataList = new ArrayList<String>();
	}
	
	
	public void insert(String value) {
		dataList.add(value);
		sort();
		eventBus.post(new FlashyEvent(DemoNotifications.REFRESH_EVENT));
	}
	
	public void removeAt(int index) {
		dataList.remove(index);
		//sort() is unneccessary
		eventBus.post(new FlashyEvent(DemoNotifications.REFRESH_EVENT));
	}
	
	private void sort() {
		Collections.sort(dataList);	
	}
	
	public void reset() {
		resetList();
		eventBus.post(new FlashyEvent(DemoNotifications.REFRESH_EVENT));
	}
	
	public void resetList() {
		dataList = new ArrayList<String>();
	}
	
	public ArrayList<String> getList() {
		return new ArrayList<String>(dataList);
	}
}
