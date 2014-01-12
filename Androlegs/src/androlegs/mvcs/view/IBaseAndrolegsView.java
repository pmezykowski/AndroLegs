package androlegs.mvcs.view;

import androlegs.mvcs.event.FlashyEvent;
import androlegs.mvcs.mediator.mediators.IMediator;

public interface IBaseAndrolegsView {

	public void attachMediator(IMediator mediator);

	public void deattachMediator();
	
	public void sendEventToMediator(FlashyEvent event);
	
}
