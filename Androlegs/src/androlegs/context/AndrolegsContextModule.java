package androlegs.context;

import javax.inject.Singleton;

import android.content.Context;
import androlegs.app.AndrolegsApp;
import dagger.Module;
import dagger.Provides;
import de.greenrobot.event.EventBus;

@Module (
	library = true
)
public class AndrolegsContextModule {

	private final AndrolegsApp application;

	public AndrolegsContextModule(AndrolegsApp application) {
		this.application = application;
	}
	
	@Provides 
	@Singleton 
	Context provideApplicationContext() {
		return application;
	}
	
	@Provides
	@Singleton
	EventBus provideEventBus() {
		return application.getGlobalEventBus();
	}
}
