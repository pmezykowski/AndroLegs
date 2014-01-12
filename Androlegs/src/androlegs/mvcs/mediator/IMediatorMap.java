package androlegs.mvcs.mediator;

import android.app.Activity;
import androlegs.mvcs.mediator.mediators.ActivityMediator;
import androlegs.mvcs.mediator.mediators.FragmentMediator;
import androlegs.mvcs.mediator.mediators.SupportFragmentMediator;

public interface IMediatorMap {

	void mapActivity(Class<? extends Activity> activityClass,
			Class<? extends ActivityMediator<? extends Activity>> mediatorClass);

	void mapFragment(
			Class<? extends android.app.Fragment> fragmentClass,
			Class<? extends FragmentMediator<? extends android.app.Fragment>> mediatorClass);

	void mapSupportFragment(
			Class<? extends android.support.v4.app.Fragment> fragmentClass,
			Class<? extends SupportFragmentMediator<? extends android.support.v4.app.Fragment>> mediatorClass);

	void unmapActivity(Class<? extends Activity> activityClass,
			Class<? extends ActivityMediator<? extends Activity>> mediatorClass);

	void unmapFragment(
			Class<? extends android.app.Fragment> fragmentClass,
			Class<? extends FragmentMediator<? extends android.app.Fragment>> mediatorClass);

	void unmapSupportFragment(
			Class<? extends android.support.v4.app.Fragment> fragmentClass,
			Class<? extends SupportFragmentMediator<? extends android.support.v4.app.Fragment>> mediatorClass);

	void onActivityCreated(Activity activity);

	void onActivityDestroyed(Activity activity);

	void onFragmentCreated(android.app.Fragment fragment);

	void onFragmentDestroyed(android.app.Fragment fragment);

	void onFragmentCreated(android.support.v4.app.Fragment fragment);

	void onFragmentDestroyed(android.support.v4.app.Fragment fragment);
}
