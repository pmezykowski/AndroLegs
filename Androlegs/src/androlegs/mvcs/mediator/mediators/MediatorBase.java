package androlegs.mvcs.mediator.mediators;

import androlegs.mvcs.event.FlashyEvent;
import de.greenrobot.event.EventBus;

public abstract class MediatorBase implements IMediator{

	protected boolean removed;
	
	private EventBus eventBus;
	
	public EventBus getEventBus() {
		return eventBus;
	}

	public void setEventBus(EventBus eventBus) {
		this.eventBus = eventBus;
		eventBus.register(this);
	}

	@Override
	public void preRegister() {
		removed = false;

		onRegister();
	}

	@Override
	public void onRegister() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void preRemove() {
		removed = true;
		onRemove();
	}

	@Override
	public void onRemove() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendEvent(FlashyEvent event) {
		onViewEvent(event.getType(), event);
	}
	
	public void onEvent(FlashyEvent event) {
		onGlobalEvent(event.getType(), event);
	}
	
	public void dispatch(FlashyEvent event) {
		eventBus.post(event);
	}
	
	public abstract void onViewEvent(String eventType, FlashyEvent event);
	
	public abstract void onGlobalEvent(String eventType, FlashyEvent event);


}
