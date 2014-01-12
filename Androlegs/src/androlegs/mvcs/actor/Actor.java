package androlegs.mvcs.actor;

import android.content.Context;

import de.greenrobot.event.EventBus;

public abstract class Actor {

	protected EventBus eventBus;
	
	protected Context appContext;

	public Actor(EventBus eventBus, Context appContext) {
		super();
		this.eventBus = eventBus;
		this.appContext = appContext;
	}

	
}
