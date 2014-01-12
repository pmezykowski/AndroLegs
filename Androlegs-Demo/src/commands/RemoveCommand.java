package commands;

import javax.inject.Inject;

import androlegs.mvcs.controller.CommandBase;

import model.RoboDemoModel;

import event.DeleteEvent;

public class RemoveCommand extends CommandBase<DeleteEvent> {

	@Inject
	public RoboDemoModel model;

	@Override
	public void execute() {
		if (mEvent.getType() == DeleteEvent.DELETE_ALL_ELEMENTS) {
			model.reset();
		} else {
			model.removeAt(mEvent.getmElementId());
		}
		super.execute();
	}
	
}
