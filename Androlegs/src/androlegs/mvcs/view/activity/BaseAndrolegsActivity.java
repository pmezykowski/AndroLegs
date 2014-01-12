package androlegs.mvcs.view.activity;

import de.greenrobot.event.EventBus;
import android.app.Activity;
import android.os.Bundle;
import androlegs.app.AndrolegsApp;
import androlegs.mvcs.event.FlashyEvent;
import androlegs.mvcs.mediator.mediators.IMediator;
import androlegs.mvcs.view.IBaseAndrolegsView;

public class BaseAndrolegsActivity extends Activity implements IBaseAndrolegsView{
	
protected EventBus eventBus;
	
	private IMediator mediator;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		((AndrolegsApp) this.getApplication()).onActivityCreate(this);
	}
	
	@Override
	protected void onDestroy() {
		((AndrolegsApp) this.getApplication()).onActivityDestroy(this);
		super.onDestroy();
	}

	@Override
	public void attachMediator(IMediator mediator) {
		this.mediator = mediator;
	}

	@Override
	public void deattachMediator() {
		this.mediator = null;
	}

	@Override
	public void sendEventToMediator(FlashyEvent event) {
		// TODO Log no mediator
		if (mediator != null)
			mediator.sendEvent(event);
	}
}
