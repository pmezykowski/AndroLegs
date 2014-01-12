package androlegs.mvcs.mediator.mediators;


public abstract class SupportFragmentMediator<ViewType extends android.support.v4.app.Fragment> extends MediatorBase implements IMediator {

	private ViewType uiObject;
	
	@Override
	public Object getViewComponent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setViewComponent(Object viewComponent) {
		// TODO Auto-generated method stub

	}


	public ViewType getView() {
		return uiObject;
	}

}
