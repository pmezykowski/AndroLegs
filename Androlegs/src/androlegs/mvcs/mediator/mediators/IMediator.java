package androlegs.mvcs.mediator.mediators;

import androlegs.mvcs.event.FlashyEvent;

public interface IMediator {

	/**
	 * Should be invoked by the <code>IMediatorMap</code> during <code>IMediator</code> registration
	 */
	public void preRegister();
	
	/**
	 * Should be invoked by the <code>IMediator</code> itself when it is ready to be interacted with
	 *
	 * <p>Override and place your initialization code here</p>
	 */
	public void onRegister();
	
	/**
	 * Invoked when the <code>IMediator</code> has been removed by the <code>IMediatorMap</code>
	 */
	public void preRemove();
	
	/**
	 * Should be invoked by the <code>IMediator</code> itself when it is ready to for cleanup
	 *
	 * <p>Override and place your cleanup code here</p>
	 */
	public void onRemove();
	
	/**
	 * The <code>IMediator</code>'s view component
	 *
	 * @return The view component
	 */
	public Object getViewComponent();
	
	/**
	 * The <code>IMediator</code>'s view component
	 *
	 * @param The view component
	 */
	public void setViewComponent(Object viewComponent);
	
	public void sendEvent(FlashyEvent event);
}
