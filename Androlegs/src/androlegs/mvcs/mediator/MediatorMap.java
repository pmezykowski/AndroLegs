package androlegs.mvcs.mediator;

import java.util.HashMap;


import de.greenrobot.event.EventBus;
import android.app.Activity;
import androlegs.app.AndrolegsApp;
import androlegs.mvcs.mediator.mediators.ActivityMediator;
import androlegs.mvcs.mediator.mediators.FragmentMediator;
import androlegs.mvcs.mediator.mediators.SupportFragmentMediator;
import androlegs.mvcs.view.IBaseAndrolegsView;

public class MediatorMap implements IMediatorMap {

	protected EventBus eventBus;
	protected AndrolegsApp appBase;
	
	private HashMap<Class<? extends Activity>, Class<? extends ActivityMediator<? extends Activity>>> mediatorClassByActivityClass;
	private HashMap<Activity, ActivityMediator<? extends Activity>> mediatorByActivity;

	private HashMap<Class<? extends android.app.Fragment>, Class<? extends FragmentMediator<? extends android.app.Fragment>>> mediatorClassByFragmentClass;
	private HashMap<android.app.Fragment, FragmentMediator<? extends android.app.Fragment>> mediatorByFragment;
	
	private HashMap<Class<? extends android.support.v4.app.Fragment>, Class<? extends SupportFragmentMediator<? extends android.support.v4.app.Fragment>>> mediatorClassBySupportFragmentClass;
	private HashMap<android.support.v4.app.Fragment, SupportFragmentMediator<? extends android.support.v4.app.Fragment>> mediatorBySupportFragment;
	
	public MediatorMap (EventBus bus, AndrolegsApp app) {
		this.eventBus = bus;
		this.appBase = app;

		mediatorClassByActivityClass = new HashMap<Class<? extends Activity>, Class<? extends ActivityMediator<? extends Activity>>>();
		mediatorByActivity = new HashMap<Activity, ActivityMediator<? extends Activity>>();
		
		mediatorClassByFragmentClass = new HashMap<Class<? extends android.app.Fragment>, Class<? extends FragmentMediator<? extends android.app.Fragment>>>();
		mediatorByFragment = new HashMap<android.app.Fragment, FragmentMediator<? extends android.app.Fragment>>();
		
		mediatorClassBySupportFragmentClass = new HashMap<Class<? extends android.support.v4.app.Fragment>, Class<? extends SupportFragmentMediator<? extends android.support.v4.app.Fragment>>>();
		mediatorBySupportFragment = new HashMap<android.support.v4.app.Fragment, SupportFragmentMediator<? extends android.support.v4.app.Fragment>>();
	}
	
//Activity
	
	@Override
	public void mapActivity(
			Class<? extends Activity> activityClass, 
			Class<? extends ActivityMediator<? extends Activity>> mediatorClass) {
		
		mediatorClassByActivityClass.put(activityClass, mediatorClass);
	}
	
	@Override
	public void unmapActivity(Class<? extends Activity> activityClass,
			Class<? extends ActivityMediator<? extends Activity>> mediatorClass) {
		mediatorClassByActivityClass.remove(activityClass);
	}

	@Override
	public void onActivityCreated(Activity activity) {
		Class<? extends ActivityMediator<? extends Activity>> mediatorClass = mediatorClassByActivityClass.get(activity.getClass());
		
		if (mediatorClass != null) {
			 try {
				ActivityMediator<? extends Activity> mediator = mediatorClass.newInstance();
				registerActivityMediator(activity, mediator);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private void registerActivityMediator(Activity activity,
			ActivityMediator<? extends Activity> mediator) {
		if (activity instanceof IBaseAndrolegsView) {
			((IBaseAndrolegsView) activity).attachMediator(mediator);
		}
		appBase.inject(mediator);
		mediatorByActivity.put(activity, mediator);
		mediator.setEventBus(eventBus);
		mediator.setViewComponent(activity);
		mediator.preRegister();
		
	}
	
	@Override
	public void onActivityDestroyed(Activity activity) {
		removeActivityMediator(activity);
		
	}
	
	private void removeActivityMediator(Activity activity) {
		if (activity instanceof IBaseAndrolegsView)
			((IBaseAndrolegsView) activity).deattachMediator();
		mediatorByActivity.remove(activity);
	}

	
//Fragment

	@Override
	public void mapFragment(Class<? extends android.app.Fragment> fragmentClass,
			Class<? extends FragmentMediator<? extends android.app.Fragment>> mediatorClass) {
		
		mediatorClassByFragmentClass.put(fragmentClass, mediatorClass);
	}
	
	

	@Override
	public void unmapFragment(Class<? extends android.app.Fragment> fragmentClass,
			Class<? extends FragmentMediator<? extends android.app.Fragment>> mediatorClass) {

		mediatorClassByFragmentClass.remove(fragmentClass);
	}
	
	@Override
	public void onFragmentCreated(android.app.Fragment fragment) {
		
		Class<? extends FragmentMediator<? extends android.app.Fragment>> mediatorClass = mediatorClassByFragmentClass.get(fragment.getClass());

		if (mediatorClass != null) {
			 try {
				FragmentMediator<? extends android.app.Fragment> mediator = mediatorClass.newInstance();
				registerFragmentMediator(fragment, mediator);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	private void registerFragmentMediator(android.app.Fragment fragment,
			FragmentMediator<? extends android.app.Fragment> mediator) {
		if (fragment instanceof IBaseAndrolegsView) {
			((IBaseAndrolegsView) fragment).attachMediator(mediator);
		}
		appBase.inject(mediator);
		mediatorByFragment.put(fragment, mediator);
		mediator.setEventBus(eventBus);
		mediator.setViewComponent(fragment);
		mediator.preRegister();
		
	}

	
	@Override
	public void onFragmentDestroyed(android.app.Fragment fragment) {
		removeFragmentMediator(fragment);
	}

	
	private void removeFragmentMediator(android.app.Fragment fragment) {
		if (fragment instanceof IBaseAndrolegsView)
			((IBaseAndrolegsView) fragment).deattachMediator();
		mediatorByFragment.remove(fragment);
	}
//Support Fragment
	
	@Override
	public void mapSupportFragment(
			Class<? extends android.support.v4.app.Fragment> fragmentClass,
			Class<? extends SupportFragmentMediator<? extends android.support.v4.app.Fragment>> mediatorClass) {
		
		mediatorClassBySupportFragmentClass.put(fragmentClass, mediatorClass);
		
	}
	
	@Override
	public void unmapSupportFragment(
			Class<? extends android.support.v4.app.Fragment> fragmentClass,
			Class<? extends SupportFragmentMediator<? extends android.support.v4.app.Fragment>> mediatorClass) {
		
		mediatorClassBySupportFragmentClass.remove(fragmentClass);
	}


	@Override
	public void onFragmentCreated(android.support.v4.app.Fragment fragment) {
		Class<? extends SupportFragmentMediator<? extends android.support.v4.app.Fragment>> mediatorClass = mediatorClassBySupportFragmentClass.get(fragment.getClass());

		if (mediatorClass != null) {
			 try {
				SupportFragmentMediator<? extends android.support.v4.app.Fragment> mediator = mediatorClass.newInstance();
				registerFragmentMediator(fragment, mediator);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	
	private void registerFragmentMediator(android.support.v4.app.Fragment fragment,
			SupportFragmentMediator<? extends android.support.v4.app.Fragment> mediator) {
		if (fragment instanceof IBaseAndrolegsView) {
			((IBaseAndrolegsView) fragment).attachMediator(mediator);
		}
		appBase.inject(mediator);
		mediatorBySupportFragment.put(fragment, mediator);
		mediator.setEventBus(eventBus);
		mediator.setViewComponent(fragment);
		mediator.preRegister();
		
	}
	
	@Override
	public void onFragmentDestroyed(android.support.v4.app.Fragment fragment) {
		removeFragmentMediator(fragment);
	}
	
	private void removeFragmentMediator(android.support.v4.app.Fragment fragment) {
		if (fragment instanceof IBaseAndrolegsView)
			((IBaseAndrolegsView) fragment).deattachMediator();
		mediatorByFragment.remove(fragment);
	}
}
