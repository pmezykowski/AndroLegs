package androlegs.mvcs.view.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import androlegs.app.AndrolegsApp;
import androlegs.mvcs.event.FlashyEvent;
import androlegs.mvcs.mediator.mediators.IMediator;
import androlegs.mvcs.view.IBaseAndrolegsView;

public class BaseAndrolegsSupportFragment extends Fragment implements IBaseAndrolegsView{

	private IMediator mediator;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		((AndrolegsApp) this.getActivity().getApplication()).onFragmentCreate(this);
	}

	@Override
	public void onDestroy() {
		((AndrolegsApp) this.getActivity().getApplication()).onFragmentDestroy(this);
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
