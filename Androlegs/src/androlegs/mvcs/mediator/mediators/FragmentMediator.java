package androlegs.mvcs.mediator.mediators;


public abstract class FragmentMediator <ViewType extends android.app.Fragment> extends MediatorBase {

	private ViewType uiObject;

	@Override
	public Object getViewComponent() {
		// TODO Auto-generated method stub
		return uiObject;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void setViewComponent(Object viewComponent) {
		if (viewComponent instanceof android.app.Fragment)
			this.uiObject = (ViewType) viewComponent;
		
	}

	public ViewType getView() {
		return uiObject;
	}

}
