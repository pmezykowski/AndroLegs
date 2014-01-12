package androlegs.app;

import java.util.ArrayList;
import java.util.List;

import dagger.ObjectGraph;
import de.greenrobot.event.EventBus;
import android.app.Activity;
import android.app.Application;
import androlegs.context.AndrolegsContextModule;
import androlegs.mvcs.controller.CommandMap;
import androlegs.mvcs.controller.ICommandMap;
import androlegs.mvcs.mediator.IMediatorMap;
import androlegs.mvcs.mediator.MediatorMap;

public abstract class AndrolegsApp extends Application {

	protected ObjectGraph objectGraph;
	protected ICommandMap commandMap;
	protected IMediatorMap mediatorMap;
	private EventBus globalEventBus;
	
	@Override
	public void onCreate() {
		super.onCreate();
	
		objectGraph = ObjectGraph.create(getAllModules().toArray());
		globalEventBus = new EventBus();
		commandMap = new CommandMap(globalEventBus, this);
		mediatorMap = new MediatorMap(globalEventBus, this);
		this.startup();
	}
	
	protected void startup() {
		
	}

	private ArrayList<Object> getAllModules () {
		ArrayList<Object> allModules = new ArrayList<Object>();
		allModules.add(new AndrolegsContextModule(this));
		allModules.addAll(getModules());
		return allModules;
	}
	
	 protected abstract List<Object> getModules();
	 
	 public void inject(Object object) {
		 objectGraph.inject(object);
	 }
	 

	public void onActivityDestroy(Activity activity) {
		mediatorMap.onActivityDestroyed(activity);
	}

	public void onActivityCreate(Activity activity) {
		mediatorMap.onActivityCreated(activity);
	}
	
	public void onFragmentDestroy(android.app.Fragment fragment) {
		mediatorMap.onFragmentDestroyed(fragment);
	}
	
	public void onFragmentCreate(android.app.Fragment fragment) {
		mediatorMap.onFragmentCreated(fragment);
	}
	
	public void onFragmentDestroy(android.support.v4.app.Fragment fragment) {
		mediatorMap.onFragmentDestroyed(fragment);
	}
	
	public void onFragmentCreate(android.support.v4.app.Fragment fragment) {
		mediatorMap.onFragmentCreated(fragment);
	}

	public EventBus getGlobalEventBus() {
		return globalEventBus;
	}
}
