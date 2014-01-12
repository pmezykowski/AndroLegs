package androlegs.mvcs.controller;

import androlegs.mvcs.event.FlashyEvent;


public interface ICommandMap {

	void mapEvent(String eventType, Class<? extends CommandBase<? extends FlashyEvent>> commandClass, Class<? extends FlashyEvent> eventClass);

}
