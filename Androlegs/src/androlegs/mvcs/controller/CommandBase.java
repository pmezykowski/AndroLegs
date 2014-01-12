package androlegs.mvcs.controller;

import androlegs.mvcs.event.FlashyEvent;
import de.greenrobot.event.EventBus;

public abstract class CommandBase<EventType extends FlashyEvent> {

	protected EventType mEvent;
	
	private EventBus eventBus;
	
	public EventType getEvent() {
		return mEvent;
	}
	
	public void execute() {
		
	}

	@SuppressWarnings("unchecked")
	void setEvent(FlashyEvent mEvent) {
		this.mEvent = (EventType) mEvent;
	}

	public EventBus getEventBus() {
		return eventBus;
	}

	void setEventBus(EventBus eventBus) {
		this.eventBus = eventBus;
	}
	
	protected void dispatch(FlashyEvent event) {
		this.eventBus.post(event);
	}
}
