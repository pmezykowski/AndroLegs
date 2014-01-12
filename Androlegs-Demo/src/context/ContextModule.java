package context;



import androlegs.context.AndrolegsContextModule;
import view.demoActivity.DemoMediator;
import view.demoActivity.inputFragment.InputFragmentMediator;

import commands.AddCommand;
import commands.RemoveCommand;

import dagger.Module;

@Module (injects = {
			AddCommand.class,
			RemoveCommand.class,
			DemoMediator.class,
			InputFragmentMediator.class
		},
		includes=AndrolegsContextModule.class,
		library = true
)
public class ContextModule {
	
}
