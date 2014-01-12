package application;

import java.util.Arrays;
import java.util.List;



import view.demoActivity.DemoActivity;
import view.demoActivity.DemoMediator;
import view.demoActivity.inputFragment.InputFragment;
import view.demoActivity.inputFragment.InputFragmentMediator;

import androlegs.app.AndrolegsApp;

import commands.AddCommand;
import commands.RemoveCommand;

import context.ContextModule;
import event.AddEvent;
import event.DeleteEvent;


public class DroidDemoApp extends AndrolegsApp  {


	@Override
	protected void startup() {
		super.startup();
		
		commandMap.mapEvent(AddEvent.ADD_TEXT_ELEMENT, AddCommand.class, AddEvent.class);
		commandMap.mapEvent(DeleteEvent.DELETE_ALL_ELEMENTS, RemoveCommand.class, DeleteEvent.class);
		commandMap.mapEvent(DeleteEvent.DELETE_SINGLE_ELEMENT, RemoveCommand.class, DeleteEvent.class);
		
		mediatorMap.mapActivity(DemoActivity.class, DemoMediator.class);
		mediatorMap.mapFragment(InputFragment.class, InputFragmentMediator.class);
	}

	@Override
	protected List<Object> getModules() {
		return Arrays.<Object>asList(
	    		new ContextModule()
	    		);
	}
	
	

}
