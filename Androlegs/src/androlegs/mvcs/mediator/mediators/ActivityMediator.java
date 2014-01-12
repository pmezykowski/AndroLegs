package androlegs.mvcs.mediator.mediators;

import android.app.Activity;

public abstract class ActivityMediator <ViewType extends Activity> extends MediatorBase {

	private ViewType uiObject;

	@Override
	public Object getViewComponent() {
		// TODO Auto-generated method stub
		return uiObject;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void setViewComponent(Object viewComponent) {
		if (viewComponent instanceof Activity)
			this.uiObject = (ViewType) viewComponent;
		
	}

	public ViewType getView() {
		return uiObject;
	}

}
