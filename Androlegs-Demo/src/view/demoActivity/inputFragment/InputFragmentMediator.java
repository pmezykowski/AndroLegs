package view.demoActivity.inputFragment;

import event.AddEvent;
import event.DeleteEvent;
import androlegs.mvcs.event.FlashyEvent;
import androlegs.mvcs.mediator.mediators.FragmentMediator;

public class InputFragmentMediator extends FragmentMediator<InputFragment> {

	@Override
	public void onViewEvent(String eventType, FlashyEvent event) {
		if (eventType == AddEvent.ADD_TEXT_ELEMENT)
			onAddEvent((AddEvent) event);
	}

	@Override
	public void onGlobalEvent(String eventType, FlashyEvent event) {
		if (eventType == DeleteEvent.DELETE_ALL_ELEMENTS)
			onDeleteAll();
	}


	private void onDeleteAll() {
		getView().clearTextField();
	}

	private void onAddEvent(AddEvent event) {
		getEventBus().post(event);
		getView().clearTextField();
	}
	
}
