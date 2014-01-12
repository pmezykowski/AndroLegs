package view.demoActivity;

import javax.inject.Inject;

import model.RoboDemoModel;
import notifications.DemoNotifications;
import androlegs.mvcs.event.FlashyEvent;
import androlegs.mvcs.mediator.mediators.ActivityMediator;
import event.DeleteEvent;

public class DemoMediator extends ActivityMediator<DemoActivity> {

	@Inject
	public RoboDemoModel model;

	@Override
	public void onViewEvent(String eventType, FlashyEvent event) {
		
		if (eventType == DeleteEvent.DELETE_ALL_ELEMENTS)
			onDeleteEvent((DeleteEvent) event);
		
	}

	@Override
	public void onGlobalEvent(String eventType, FlashyEvent event) {
		if (eventType == DemoNotifications.REFRESH_EVENT)
			onRefresh(event);
		
	}

	private void onRefresh(FlashyEvent event) {
		this.getView().refresh(model.getList());
	}

	private void onDeleteEvent(DeleteEvent event) {
		getEventBus().post(event);
	}




}
