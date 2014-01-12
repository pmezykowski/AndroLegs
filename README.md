AndroLegs
=========

MVC(S) Micro-architecture for Android SDK inspired by Robotlegs v 1.x AS3 Micro-architecture  (https://github.com/robotlegs/robotlegs-framework/tree/version1)

First of all : It's very early version!

This project uses Dagger (http://square.github.io/dagger/) for dependency injection and EventBus (https://github.com/greenrobot/EventBus) for messaging.
So, to make it works, you'll need some of jars:
* dagger-1.x.x (I tested it with 1.1.0)
* dagger-compiler-1.x.x (same version)
* eventbus-2.x.x (I've got 2.2.0)
* javawriter
* javax.inject

To make Androlegs working properly, you should add them to java compiler -> annotation processing -> factory path (I use Eclipse).
This configuration should be done in Androlegs project as well as in your project which uses the Androlegs.

Also remember to disable proguard for specific code (standard configuration for Dagger and Eventbus): 

```
-keepclassmembers class ** {
    public void onEvent*(**);
}

-keep class dagger.** { *; }

```

There will be more examples in the future, some javadoc etc.
If you're familiar with robotlegs in AS3 and have basic knowledge about using Dagger and Eventbus, you should have no problem with understanding sample project and Androlegs micro-architecture.

Again: it's very early version. So, don't be attached to, for example, package names - it can be modified in next releases.


Stay tuned!