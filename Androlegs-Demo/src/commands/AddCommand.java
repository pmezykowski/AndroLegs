package commands;

import javax.inject.Inject;

import androlegs.mvcs.controller.CommandBase;

import model.RoboDemoModel;

import event.AddEvent;

public class AddCommand extends CommandBase<AddEvent> {
	
	@Inject
	public RoboDemoModel mModel;
	
	@Override
	public void execute() {
		
		mModel.insert(this.getEvent().getText());
		super.execute();
	}
}
