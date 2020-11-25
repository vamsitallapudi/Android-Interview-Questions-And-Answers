# Android Interview Questions And Answers

### Curated List of Real-time Android Interview Questions. Help fellow developers by contributing to these interview Questions - Create a pull request in  [Github](https://github.com/vamsitallapudi/Android-Interview-Questions-And-Answers).

Quick Jump to Topics:
 * [Core Android](#core-android)
 * [Dagger](#dagger-2-related-questions)
 * [RxJava](#rxjava-related-questions)

### Core Android

-   **Android Architecture**<br/>
    A) <br/>
    ![Android Architecture Image](/assets/android-architecture.png)

-   **What are Android Components?**<br/>
    A) 1) Activities,
    2) Intent and broadcast receivers,
    3) Services,
    4) Content Providers,
    5) Widgets and Notifications

-   **What is an Application class?**<br/>
    A) An Application class is a base class in your Application starts before all other classes like Activities or services are called. You can maintain your application's global state here. While it is NOT mandatory that you need to extend Application class, you can do so by providing your own implementation by creating a subclass and specifying the fully-qualified name of this subclass as the "android:name" attribute in your AndroidManifest.xml's <application> tag.

-   **What is a Context? What are different types of Contexts?**<br/>
    A) As the name says, its the context of the current application or object. Context is like a handle to the environment your application is currently running in.
    We mainly use two types of context. Application context - whose scope is throughout the application and Activity Context - whose scope depends on the Activity Lifecycle.

-   **What is an Activity?**<br/>
    A) An activity provides the window in which the app draws its UI. This window typically fills the screen, but may be smaller than the screen and float on top of other windows. Generally, one activity implements one screen in an app. For instance, one of an app’s activities may implement a Preferences screen, while another activity implements a Select Photo screen.

-   **What is an Intent Filter?**<br/>
    A) Intent filters are a very powerful feature of the Android platform. They provide the ability to launch an activity based not only on an explicit request, but also an implicit one. For example, an explicit request might tell the system to “Start the Send Email activity in the Gmail app". By contrast, an implicit request tells the system to “Start a Send Email screen in any activity that can do the job." When the system UI asks a user which app to use in performing a task, that’s an intent filter at work. Here's an example of how to declare Intent Filter in AndroidManifest:
    ```xml
    <activity android:name=".ExampleActivity" android:icon="@drawable/app_icon">
      <intent-filter>
          <action android:name="android.intent.action.SEND" />
          <category android:name="android.intent.category.DEFAULT" />
          <data android:mimeType="text/plain" />
      </intent-filter>
    </activity>
    ```


-   **What is an Intent?**<br/>
    A) It is a kind of message or information that is passed to the components. It is used to launch an activity, display a web page, send SMS, send email, etc. There are two types of intents in android:
    a)Implicit Intent
    b)Explicit Intent

-   **What is AAPT?**<br/>
    A) AAPT2 (Android Asset Packaging Tool) is a build tool that Android Studio and Android Gradle Plugin use to compile and package your app’s resources. AAPT2 parses, indexes, and compiles the resources into a binary format that is optimized for the Android platform.

-   **What are the different types of Intents?**<br/>
    A) There are two types of intents:

    Explicit intents specify which application will satisfy the intent, by supplying either the target app's package name or a fully-qualified component class name. You'll typically use an explicit intent to start a component in your own app, because you know the class name of the activity or service you want to start. For example, you might start a new activity within your app in response to a user action, or start a service to download a file in the background.
    Implicit intents do not name a specific component, but instead declare a general action to perform, which allows a component from another app to handle it. For example, if you want to show the user a location on a map, you can use an implicit intent to request that another capable app show a specified location on a map.

-   **What is HandlerThread?**<br/>
    A) HandlerThread is a Handy class to start a thread that has a Looper.

-   **What is a Looper?**<br/>
    A) A Looper is a class used to loop through the Message Queue attached to the Thread. By default, a thread halts when the execution completes. But, for Example, if we take Android's Main thread, it should not halt upon execution.
    Rather it should loop through the runnables(Messages) that its assigned in order to work properly. For more info, refer to this [link](https://stackoverflow.com/a/34522758/3424919).

-   **What is a Service?**<br/>
    A) A service is a component which doesn't have UI and can perform long running operations like downloading stuff, playing music etc.. which can run even exiting the application. By default service runs on main thread. This might cause ANR errors. To avoid this, we can Start service by creating a new background thread or use an IntentService that can do work in background. [Read More.](https://developer.android.com/guide/components/services)

-   **How to Stop a Service?**<br/>
    A) To stop a service from an activity we can call stopService(Intent intent) method. To Stop a service from itself, we can call stopSelf() method.

-   **What are different types of services?**<br/>
    A) These are the three different types of services:

    **Foreground Service:**
    A foreground service performs some operation that is noticeable to the user. For example, an audio app would use a foreground service to play an audio track. Foreground services must display a Notification. Foreground services continue running even when the user isn't interacting with the app. <br/>
    **Background Service:**
    A background service performs an operation that isn't directly noticed by the user. For example, if an app used a service to compact its storage, that would usually be a background service.<br/>
    **Bound Service:**
    A service is bound when an application component binds to it by calling bindService(). A bound service offers a client-server interface that allows components to interact with the service, send requests, receive results, and even do so across processes with interprocess communication (IPC). A bound service runs only as long as another application component is bound to it. Multiple components can bind to the service at once, but when all of them unbind, the service is destroyed by the system.
    [Read More](https://developer.android.com/guide/components/services#Types-of-services)

-   **Bound Service vs UnBounded service?**<br/>
    A) A Bound service is started by using method bindService(). As mentioned above system destroys bound service when no application component is accessing it.
    Unbounded service (started service) is started by using a method called startService(). Once started, it will run indefinitely even if the application component that started it is destroyed.

-   **When does a Bound Service stops?**<br/>
    A) A Bound Service will stop automatically by the system when all the Application Components bound to it are unbinded.

-   **What is an Intent Service?**<br/>
    A) IntentService is a Service that can perform tasks using worker thread unlike service that blocks main thread.

-   **What is the difference between START_NOT_STICKY, START_STICKY AND START_REDELIVER_INTENT?**<br/>
    A) **START_NOT_STICKY:**<br/>
    If the system kills the service after onStartCommand() returns, do not recreate the service unless there are pending intents to deliver. This is the safest option to avoid running your service when not necessary and when your application can simply restart any unfinished jobs.<br/>
    **START_STICKY:**<br/>
    If the system kills the service after onStartCommand() returns, recreate the service and call onStartCommand(), but do not redeliver the last intent. Instead, the system calls onStartCommand() with a null intent unless there are pending intents to start the service. In that case, those intents are delivered. This is suitable for media players (or similar services) that are not executing commands but are running indefinitely and waiting for a job.<br/>
    **START_REDELIVER_INTENT:**<br/>
    If the system kills the service after onStartCommand() returns, recreate the service and call onStartCommand() with the last intent that was delivered to the service. Any pending intents are delivered in turn. This is *suitable for services that are actively performing a job that should be immediately resumed, such as downloading a file.*

-   **What is Pending Intent?**<br/>
    A)A PendingIntent is a token that you give to a foreign application (e.g. NotificationManager, AlarmManager, Home Screen AppWidgetManager, or other 3rd party applications), which allows the foreign application to use your application's permissions to execute a predefined piece of code. It specifies a task that requires to be performed in future.

-   **What is the method that differentiates it to make Service run in background?**<br/>
    A) onHandleIntent() is the method that helps the IntentService to run a particular code block declared inside it, in worker/background thread.

-   **How to Stop an IntentService?**<br/>
    A) An IntentService automatically stops itself after its job is done. We do not need to explicitly call any methods to stop an IntentService unlike Service which requires stopSelf() or StopService(intent:Intent).

-   **When Intent Service is Useful?**<br/>
    A) The IntentService can be used in long tasks usually with no communication to Main Thread. If communication is required, can use Main Thread handler or broadcast intents. Another case of use is when callbacks are needed (Intent triggered tasks).

-   **Advantage of Retrofit over Volley?**<br/>
    A) Retrofit is type-safe. Type safety means that the compiler will validate types while compiling, and throw an error if you try to assign the wrong type to a variable.

-   **Advantage of Volley over Retrofit?**<br/>
    A) Android Volley has a very elaborate and flexible cache mechanism. When a request is made through Volley, first the cache is checked for Response. If it is found, then it is fetched and parsed, else, it will hit Network to fetch the data. Retrofit does not support cache by default.

-   **What are different launch modes available in Android?**<br/>
    A) There are four launch modes for an Activity in Android as follows:

    1) standard : create a new instance of an activity every single time. It is the default mode if not declared.

    2) single top : same as standard except that if the activity is at the top of the stack, then the same instance will be used.

    3) single task : a new task will be created whenever this activity is created. Also only one instance will be available among all the tasks.

    4) single instance : the activity will be created in a new task, and that task will contain only that activity. Also only 1 instance of that activity will be available for all the tasks.

-   **How to handle crashing of AsyncTask during screen rotation?**<br/>
    A) The best way to handle AsyncTask crash is to create a RetainFragment, i.e., a fragment without UI as shown in the gist below: https://gist.github.com/vamsitallapudi/26030c15829d7be8118e42b1fcd0fa42
    We can also avoid this crash by using RxJava instead of AsyncTask as we will be subscribing and unsubscribing at onResume() and onPause() methods respectively.
-   **What is the advantage of using Retrofit over AsyncTask?**<br/>
    A) Retrofit reduces boiler plate code by internally using GSON library which helps parsing the json file automatically.
    Retrofit is a type safe library. This means - it checks if wrong data type is assigned to variables at compilation time itself.
    More use-cases at: https://stackoverflow.com/a/16903205/3424919

-   **How to handle multiple network calls using Retrofit?**<br/>
      A) In Retrofit, we can call the operations asynchronously by using enqueue() method where as to call operations synchronously, we can use execute() method. In addition, we can use zip() operator from RxJava to perform multiple network calls using Retrofit library.

-   **What is the role of Presenter in MVP?**<br/>
    A) The Presenter is responsible to act as the middle man between View and Model. It retrieves data from the Model and returns it formatted to the View. But unlike the typical MVC, it also decides what happens when you interact with the View.

-   **What is the advantage of MVVM over MVP?**<br/>
    A) In MVP, Presenter is responsible for view data updates as well as data operations where as in MVVM, ViewModel does not hold any reference to View. It is the View's responsibility to pick the changes from ViewModel. This helps in writing more maintainable test cases since ViewModel does not depend upon View.

-   **Activity Lifecycle**<br/>
    A)<br/>
    ![Activity Lifecycle Image](/assets/activity_lifecycle.png)

-   **Fragment Lifecycle**<br/>
    A)<br/>
    ![Fragment Lifecycle Image](/assets/fragment_lifecycle.png)

-   **Service Lifecycle**<br/>
    A)<br/>
    ![Fragment Lifecycle Image](/assets/service_lifecycle.png)

-    **When to use AsyncTask and when to use services?**<br/>
    A) Services are useful when you want to run code even when your application's Activity isn't open. AsyncTask is a helper class used to run some code in a separate thread and publish results in main thread. Usually AsyncTask is used for small operations and services are used for long running operations.

-    **When to use a service and when to use a thread?**<br/>
    A) 

-   **What is a Handler?**<br/>
    A) A Handler allows you to send and process Message and Runnable objects associated with a thread's MessageQueue. Each Handler instance is associated with a single thread and that thread's message queue. When you create a new Handler, it is bound to the thread / message queue of the thread that is creating it -- from that point on, it will deliver messages and runnables to that message queue and execute them as they come out of the message queue.

-   **How to save password safely in Android?**<br/>
    A) Using Android Keystore<br/>
    <https://medium.com/@josiassena/using-the-android-keystore-system-to-store-sensitive-information-3a56175a454b>

-   **String a = “abc”;  String b = new String(“abc”); Will a == b ??**<br/>
    A) It depends. Here with the first statement, i.e, String a = “abc”, JVM will search for a string with “abc” in String constant pool(SCP) and if its not there it will create a new Object.
    If we wrote second statement similarly, i.e., String b = “abc”, then b will point to same string from SCP.
    However, String b = new String(“abc”) always creates a new String object.

-  **What is Alarm Manager?**<br/>
    A) AlarmManager is a class which helps scheduling your Application code to run at some point of time or at particular time intervals in future. When an alarm goes off, the Intent that had been registered for it is broadcast by the system, automatically starting the target application if it is not already running. Registered alarms are retained while the device is asleep (and can optionally wake the device up if they go off during that time), but will be cleared if it is turned off and rebooted.

-   **How can I get continuous location updates in android like in Google Maps?**<br/>
    A) We can use Fused location provider in Android set our interval in that.
    https://stackoverflow.com/a/41500910/3424919

### Dagger 2 Related Questions:

-   **What is the use-case of @BindsInstance Annotation?**<br/>
    A) @BindsInstance is used to bind the available data at the time building the Component. Suppose I have user name available before building a component then I can use as shown in the following example:
    https://google.github.io/dagger/users-guide.html#binding-instances


-   **What is the use-case of @Module Annotation?**<br/>
    A) @Module is the Annotation used on the class for the Dagger to look inside it, to provide dependencies. We may be declaring methods inside the module class that are enclosed with @Provides annotation.

-   **What is the use-case of @Provides Annotation?**<br/>
    A) @Provides annotation is used on a method in Module class and can return / provide a Dependency object.

-   **What is the use-case of @Component Annotation?**<br/>
    A) @Component is used on Interface or abstract class. Dagger uses this interface to generate an implementation class with fully formed, dependency injected implementation, using the modules declared along with it. This generated class will be preceded by Dagger. For example if i create an interface named ProgramComponent with @Component annotation, Dagger will generate a Class named 'DaggerProgramComponent' implementing the  ProgramComponent interface.

-   **What is the use-case of @Scope Annotation?**<br/>
    A) @Scope is an annotation used on Interface to create a new Custom Scope. A Scope declaration helps to keep single instance of a class as long as its scope exists. For example, in Android, we can use @ApplicationScope for the object to live as long as the Application is live or @ActivityScope for the object to be available till the activity is killed.

-   **What is the use of Qualifier in Dagger?**<br/>
    A) We are often in a situation where we will be needing multiple objects with different instance values. For example, we need declare Student("Vamsi") and Student("Krishna"). In such case we can use a Qualifier to tell Dagger that we need multiple instances of same class. The default implementation of Qualifier is using @Named annotation, for eg., @Named("student_vamsi") and @Named("student_krishna")
    If we want to create a Custom Qualifier we would be using @Qualifier to declare a custom Qualifier interface.

-   **What is the use-case of @Inject Annotation in Dagger?**<br/>
    A) @Inject annotation is used to request dagger to provide the respective Object. We use @Inject on Constructor, Fields (mostly where constructor is not accessible like Activities, Fragments, etc.) and Methods.

### RxJava Related Questions:

More additional info to get started with RxJava is available at:
[Getting Started with RxJava2](https://www.coderefer.com/rxandroid-tutorial-getting-started/)

-   **What is an Observable in RXJava2?**<br/>
    A) An Observable  simply emits the data to those which subscribed to it. All the emission is done asynchronously to the subscribers. A simple Observable can be created as follows:

    ```java
    // RxAndroid Tutorial - Adding Observable
    Observable<String> stringObservable = Observable.just("Hello Reactive Programming!");
    ```
-   **What is an Observer in RXJava2?**<br/>
    A) Observer consumes the data emitted by the Observable. To do this, Observer needs to subscribe to the Observable. Example shows how to create an Observable in RxJava2.
    ```java
    // RxAndroid Tutorial - Adding observer
    Observer<String> stringObserver = new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
            }

            @Override
            public void onNext(String s) {
                Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(Throwable e) {
            }

            @Override
            public void onComplete() {
            }
        };
    ```

-   **How to Subscribe / Unsubscribe in RXJava?**<br/>
    A) We can make an Observer to subscribe to Observable as follows:
    ```java
    // RxAndroid tutorial - observer subscribing to observable
    stringObservable.subscribe(stringObserver);
    ```

-   **What are the different types of Observables in RxJava?**<br/>
    A)1) single
    2) Maybe
    3) Completable
    4) Observable
    5) Flowable

-   **What is a Single in RxJava?**<br/>
    A) A Single in RxJava is an Observable which emits only one item if completed or returns error.

-   **What is Maybe in RxJava?** <br/>
    A) A Maybe in RxJava is used when the Observable needs to emit a value or a no value or an error.

-   **What is Completable in RxJava?** <br/>
    A) A Completable in RxJava is an Observable which just completes the task and does not emit anything if completed. It returns an error if anything fails.
    It is similar to reactive concept of runnable.

-   **What is Back Pressure in RxJava?**<br/>
    A) Back Pressure is the state where your observable (publisher) is creating more events than your subscriber can handle.

-   **What is Flowable in RxJava?** <br/>
    A) A Flowable in RxJava is used when the Observable emits more data than the Observer can consume. In Other words, Flowable can handle back pressure where as an Observable cannot.

-   **What is a Cold Observable?**<br/>
    A) A Cold Observable is an Observable that does not emit items until a Subscriber subscribes. If we have more than one Subscriber, then the Cold Observable will emit each sequence of items to all Subscribers one by one.

-   **What is a Hot Observable?**<br/>
    A) A Hot observable is an Observer that will emit items

-   **Hot Observables vs Cold Observables**<br/>



-   **Explain about reactive programming?**<br/>
