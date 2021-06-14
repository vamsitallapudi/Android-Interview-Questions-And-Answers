# Android Interview Questions And Answers

  ![Android Interview Questions Coderefer Thumbnail](/assets/android-interview-questions-cr-thumbnail.jpg)

### Curated List of Real-time Android Interview Questions. Found Any Errors / Want to help fellow developers? - Create a pull request in  [Github](https://github.com/vamsitallapudi/Android-Interview-Questions-And-Answers).

Quick Jump to Topics:
 * [Core Android](#core-android)
 * [Java Interview Questions](/java/README.md)
 * [Kotlin Interview Questions](/kotlin/README.md)
 * [Dagger](#dagger-2-related-questions)
 * [RxJava](#rxjava-related-questions)

### Core Android

-   **What are SOLID Principles? How they are applicable in Android?**<br/>
    A) SOLID unites all the best practices of software development over the years to deliver good quality apps. Understanding SOLID Principles will help us write clean and elegant code. It helps us write the code with SOC (Separation of Concerns).
    SOLID Principles is an acronym for:
    1. S stands for Single Responsibility Principle(SRP) - A class should have only one reason to change
    2. O stands for Open Closed Principle - Software entities such as classes, functions, modules should be open for extension but closed for modification.
    3. L stands for Liskov Substitution Principle - Derived class must be usable through the base class interface, without the need for user to know the difference.
    4. I stands for Interface Segregation - No client should be forced to depend on methods that it doesn't use.
    5. D stands for Dependency Inversion - 
       1. High Level Modules should not directly depend on Low level modules. Instead both should depend on abstractions.
       2. Abstractions should not depend on details. Details should depend on abstractions.

    [Learn More about SOLID principles with Android Examples Here.](https://www.coderefer.com/blog/solid-principles-in-android-with-kotlin-examples/)

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
    A) An Application class is a base class in your Application that starts before all other classes like Activities or services are called. You can maintain your application's global state here. While it is NOT mandatory that you need to extend Application class, you can do so by providing your own implementation by creating a subclass and specifying the fully-qualified name of this subclass as the "android:name" attribute in your AndroidManifest.xml's <application> tag.

-   **What is a Context? What are different types of Contexts?**<br/>
    A) As the name says, its the context of the current application or object. Context is like a handle to the environment your application is currently running in.
    We mainly use two types of context. Application context - whose scope is throughout the application and Activity Context - whose scope depends on the Activity Lifecycle.

-   **What is an Activity?**<br/>
    A) An activity provides the window in which the app draws its UI. This window typically fills the screen, but may be smaller than the screen and float on top of other windows. Generally, one activity implements one screen in an app. For instance, one of an app’s activities may implement a Preferences screen, while another activity implements a Select Photo screen.

-   **Activity Lifecycle**<br/>
    A)<br/>
    ![Activity Lifecycle Image](/assets/activity_lifecycle.png)

-   **Fragment Lifecycle**<br/>
    A)<br/>
    ![Fragment Lifecycle Image](/assets/fragment_lifecycle.png)

-   **Service Lifecycle**<br/>
    A)<br/>
    ![Fragment Lifecycle Image](/assets/service_lifecycle.png)

-   **What is the correlation between activity and fragment life cycle?**<br/>
-   A) <br/>
    Here is how Activity's and Fragment's lifecyle are called together:
    ![Activity Fragment Lifecycle](/assets/activity-fragment-lifecycles.png)

-   **Is there any scenario where onDestoy() will be called without calling onPause() and onStop()?**<br/>
    A) If we call finish() method inside onCreate() of our Activity, then onDestroy() will be called directly.

-   **How do we save and restore an activity's state during screen screen rotation?**<br/>
    A) We can use onSavedInstanceState(bundle:Bundle) to save the activity's state inside a bundle. Then we can use onRestoreInstanceState(bundle) to restore the state of activity.

-   **What is a Loader in Android?**<br/>
    A) Note: (Loader is Deprecated. We Have to use combination of ViewModels and LiveData instead of using Loaders) A Loader is used to fetch the data from a Content provider and cache the results across the configuration changes to avoid duplicate queries. Few implementations of Loaders like CursorLoader can implement an observer to monitor any data changes and can then trigger a reload.

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
    A) A Looper is a class used to loop through the Message Queue attached to the Thread. Any thread consists of only one looper.
    
    You can access message queue of current thread by using **Looper.myQueue()**.
    
    By default, a thread halts when the execution completes. But, for Example, if we take Android's Main thread, it should not halt upon execution.

    Normally thread cannot be reused once its job is completed. But thread with Looper is kept alive until you call quit method so you don’t need to create a new instance each time you want to run a job in background.

    Rather it should loop through the runnables(Messages) that its assigned in order to work properly. For more info, refer to this [link](https://stackoverflow.com/a/34522758/3424919).

-   **What is a Message Queue?**<br/>
    A) MessageQueue is a queue that has list of messages which should be processed. Android maintains a MessageQueue on the main thread.
    [More Info](https://medium.com/@ankit.sinhal/messagequeue-and-looper-in-android-3a18c7fc9181)

-   **What is a Message ?**<br/>
    A) Message contains a description and arbitrary data object that can be sent to a Handler. Basically its used to process / send some data across threads.

-   **What is a Service?**<br/>
    A) A service is a component which doesn't have UI and can perform long running operations like downloading stuff, playing music etc.. which can run even exiting the application. By default service runs on main thread. This might cause ANR errors. To avoid this, we can Start service by creating a new background thread or use an IntentService that can do work in background. [Read More.](https://developer.android.com/guide/components/services)

-   **How to Stop a Service?**<br/>
    A) To stop a service from an activity we can call stopService(Intent intent) method. To Stop a service from itself, we can call stopSelf() method.

-   **What are different types of services?**<br/>
    A) These are the three different types of services:

    **Foreground Service:**
    A foreground service performs some operation that is noticeable to the user. For example, an audio app would use a foreground service to play an audio track. Foreground services must display a Notification. Foreground services continue running even when the user isn't interacting with the app. <br/>
    **Background Service:**
    A background service performs an operation that isn't directly noticed by the user. For example, if an app used a service to compact its storage, that would usually be a background service. However there are restrictions to use background services from Android API 26 and above. We can use WorkManager to defer these background tasks.<br/>
    **Bound Service:**
    A service is bound when an application component binds to it by calling bindService(). A bound service offers a client-server interface that allows components to interact with the service, send requests, receive results, and even do so across processes with interprocess communication (IPC). A bound service runs only as long as another application component is bound to it. Multiple components can bind to the service at once, but when all of them unbind, the service is destroyed by the system.
    [Read More](https://developer.android.com/guide/components/services#Types-of-services)

-   **Bound Service vs UnBounded service?**<br/>
    A) A Bound service is started by using method bindService(). As mentioned above system destroys bound service when no application component is accessing it.
    Unbounded service (started service) is started by using a method called startService(). Once started, it will run indefinitely even if the application component that started it is destroyed.

-   **When does a Bound Service stops?**<br/>
    A) A Bound Service will stop automatically by the system when all the Application Components bound to it are unbinded.

-   **What is the difference between START_NOT_STICKY, START_STICKY AND START_REDELIVER_INTENT?**<br/>
    A) **START_NOT_STICKY:**<br/>
    If the system kills the service after onStartCommand() returns, do not recreate the service unless there are pending intents to deliver. This is the safest option to avoid running your service when not necessary and when your application can simply restart any unfinished jobs.<br/>
    **START_STICKY:**<br/>
    If the system kills the service after onStartCommand() returns, recreate the service and call onStartCommand(), but do not redeliver the last intent. Instead, the system calls onStartCommand() with a null intent unless there are pending intents to start the service. In that case, those intents are delivered. This is suitable for media players (or similar services) that are not executing commands but are running indefinitely and waiting for a job.<br/>
    **START_REDELIVER_INTENT:**<br/>
    If the system kills the service after onStartCommand() returns, recreate the service and call onStartCommand() with the last intent that was delivered to the service. Any pending intents are delivered in turn. This is *suitable for services that are actively performing a job that should be immediately resumed, such as downloading a file.*

-   **What is Pending Intent?**<br/>
    A)A PendingIntent is a token that you give to a foreign application (e.g. NotificationManager, AlarmManager, Home Screen AppWidgetManager, or other 3rd party applications), which allows the foreign application to use your application's permissions to execute a predefined piece of code. It specifies a task that requires to be performed in future.

-   **What is an Intent Service?**<br/>
    A) IntentService is a subclass of Service that can perform tasks using worker thread unlike service that blocks main thread.

-   **What is the method that differentiates it to make Service run in background?**<br/>
    A) onHandleIntent() is the method that helps the IntentService to run a particular code block declared inside it, in worker/background thread.

-   **How to Stop an IntentService?**<br/>
    A) An IntentService automatically stops itself after its job is done. We do not need to explicitly call any methods to stop an IntentService unlike Service which requires stopSelf() or StopService(intent:Intent).

-   **When Intent Service is Useful?**<br/>
    A) The IntentService can be used in long tasks usually with no communication to Main Thread. If communication is required, can use Main Thread handler or broadcast intents. Another case of use is when callbacks are needed (Intent triggered tasks).

-   **Advantage of Retrofit over Volley?**<br/>
    A) Retrofit is type-safe. Type safety means that the compiler will validate reques and response object's variable types while compiling, and throw an error if you try to assign the wrong type to a variable.

-   **Advantage of Volley over Retrofit?**<br/>
    A) Android Volley has a very elaborate and flexible cache mechanism. When a request is made through Volley, first the cache is checked for Response. If it is found, then it is fetched and parsed, else, it will hit Network to fetch the data. Retrofit does not support cache by default.

-   **What are different launch modes available in Android?**<br/>
    A) There are four launch modes for an Activity in Android as follows:

    1) <b>standard</b> : Creates a new instance of an activity in the task from which it is started every single time. It is the default mode if not declared. 
    <br/>Eg: If we have an activity stack of A->B->C, If we launch Activity C again using standard Mode, the activity stack will now be A->B->C->C. We can see that two instances of C are present in the activity stack.

    1) <b>singleTop</b> : Same as standard except that if the activity is at the top of the stack, then the same instance will be used. Now the existing Activity at the top will receive the intent through a call to its onNewIntent() method.
     <br/>Eg: If we have an activity stack of A->B->C, If we launch Activity C again using singleTop Mode, the activity stack remains to be A->B->C. However if we launch B, then B will be added as new Instance to the stack (A->B->C->B).

    2) <b>singleTask</b> : A new task will be created and activity will be created at the root of this new task whenever we use launch mode as singleTask. However, if there is already a separate task with same instance, the system will call that activity's onNewIntent() method to route the intent. There can only be one instance of activity existing at a time.
    <br/>Eg: If our activity stack is A->B->C and if we launch D using singleTask, it will be A->B->C->[D]. Here braces represents the stack in separate task. If we call E using standard mode, then it will be A->B->C->[D->E].<br/>
    If we have A->B->C and if we call B again using singleTask launch Mode, the stack will now be A->[B] with B in a separate task. Activity C will be destroyed.

    1) <b>singleInstance</b> : Same as Single Task except it creates a new activity in a task and no other activities can then launched into that task. That task will forever contains only that activity. If we use standard or singleTop to launch another activities, they are launched into another tasks.
    <br/>Eg: if the Activity stack is A->B and now we launched C using singleInstance Launch Mode, the new stack will be A->B->[C]. Now if we call a new activity D from C, it will be launched into separate task. Now the new stack will be A->B->[C]->[D].  Now if we launch E from activity B, Then new stack will be A->B->E [C]->[D]. If we call C again, onNewIntent() of C will be called and new stack will be A->B->E->[C] [D].

    You can read more about them [here](https://developer.android.com/guide/components/activities/tasks-and-back-stack#ManifestForTasks).

-   **How do you declare the launch mode in your application?**<br/>
    A) via manifest, in activity's tag. For Eg., -> android:launchMode="singleTask"


-   **How to handle crashing of AsyncTask during screen rotation?**<br/>
    A) 
    One way is by cancelling the AsyncTask by using cancel() method on its instance. It will call onCancelled() method of AsyncTask where we can do some clean-up activities like hiding progress bar etc.
    The best way to handle AsyncTask crash is to create a RetainFragment, i.e., a fragment without UI as shown in the gist below: https://gist.github.com/vamsitallapudi/26030c15829d7be8118e42b1fcd0fa42
    We can also avoid this crash by using RxJava instead of AsyncTask as we will be subscribing and unsubscribing at onResume() and onPause() methods respectively. We can alternatively use activity's lifecycle aware component - LiveData.

-  **What is a RetainFragment?**<br/>
    Generally, Fragments are destroyed and recreated along with their parent Activity’s whenever a configuration change occurs. Calling setRetainInstance(true) allows us to bypass this destroy-and-recreate cycle, notifying the system to retain the current instance of the fragment when the activity is recreated.

-  **Difference between serializable and parcelable? Why android introduced Parcelable?**<br/>
    A) Serializable uses reflection while for parcelable, developers from android team wrote custom code that performs manual marshalling(converting data into byte stream) and unmarshalling(converting the byte stream back to their original data). Usually Parcelable is considered faster than Serializable.

-  **What is Reflection?**<br/>
    A) Reflection is an API that is used to examine or modify the behaviour of methods, classes and interfaces at runtime. The required classes for reflection are present in java.lang.reflect package.

-  **How to reduce your app size?**<br/>
    A)
    1. setting minifyEnabled to true
    2. setting shrinkResources to true
    3. using bundle instead of apk in developer console
    4. converting the images to vector drawables.

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

-    **When to use AsyncTask and when to use services?**<br/>
    A) Services are useful when you want to run code even when your application's Activity isn't open. AsyncTask is a helper class used to run some code in a separate thread and publish results in main thread. Usually AsyncTask is used for small operations and services are used for long running operations.

-    **When to use a service and when to use a thread?**<br/>
    A) We will use a Thread when we want to perform background operations when application is running in foreground. We will use a service even when the application is not running.

-   **What is a Handler?**<br/>
    A) A Handler allows you to send and process Message and Runnable objects associated with a thread's MessageQueue. Each Handler instance is associated with a single thread and that thread's message queue. When you create a new Handler, it is bound to the thread / message queue of the thread that is creating it -- from that point on, it will deliver messages and runnables to that message queue and execute them as they come out of the message queue. We will generally use handler class when we want to repeat task every few seconds.

-   **How to save password safely in Android?**<br/>
    A) Using Android Keystore<br/>
    <https://medium.com/@josiassena/using-the-android-keystore-system-to-store-sensitive-information-3a56175a454b>

-  **What is Alarm Manager?**<br/>
    A) AlarmManager is a class which helps scheduling your Application code to run at some point of time or at particular time intervals in future. When an alarm goes off, the Intent that had been registered for it is broadcast by the system, automatically starting the target application if it is not already running. Registered alarms are retained while the device is asleep (and can optionally wake the device up if they go off during that time), but will be cleared if it is turned off and rebooted.

-   **How can I get continuous location updates in android like in Google Maps?**<br/>
    A) We can use Fused location provider in Android set our interval in that.
    https://stackoverflow.com/a/41500910/3424919


### Android Security Related
-   **How do you know if the device is rooted?**<br/>
    A) We can check if superUser apk is installed in the device or if it contains su file or xbin folder. Alternatively you can use RootBeer library available in GitHub.
    <br/>
    For code part, click [Here](https://stackoverflow.com/a/35628977/3424919).
-   **What is Symmetric Encryption?**<br/>
    A) Symmetric encryption deals with creating a passphrase and encrypting the file with it. Then the server needs to send the key to the client so that the client can decrypt. Here the problem is sending that key to decrypt the file. If Hackers can access that key, they can misuse the data.
-   **What is Asymmetric Encryption?**<br/>
    A) Using algorithms like RSA, the server generates 2 keys - public key and private key. The server then gives public key to clients. Client then encrypts the sensitive data with that public key and send it back to server. Now as the server alone has the private key, only it can decrypt the data. This is the most efficient way of sending data across the client and server.
    <br/>
    Example of this Asymmetric encryption are HTTPS using SSL certificate, Bitcoin, etc.
    For more info, refer to this [video](https://youtu.be/AQDCe585Lnc)


### Android Battery Related
-   **How do you reduce battery consumption?**<br/>
    A) 
    1. Never poll the server for updates.
    2. Sync only when required. Ideally, sync when phone is on Wi-Fi and plugged in.
    3. Defer your work using WorkManager.
    4. Compress your data
    5. Defer non immediate requests until the phone is plugged in or wifi is turned on. The Wi-Fi radio uses significantly less battery than the mobile radio.


-   **How do you improve battery while fetching location for an app?**<br/>
    A) 
    1. By changing Accuracy -> we can use setPriority() to PRIORITY_LOW_POWER
    2. By changing Frequency of fetching location -> we can use setInterval() to specify the time interval
    3. By increasing latency -> After our call, we can wait for longer time - we can use setMaxWaitTime() to set large timeout.
   


### Dagger 2 Related Questions:

-   **What is Dependency Injection Pattern?**<br/>
    A) Dependency Injection pattern is where if our object requires other object, it will be passed to our object instead of us having to create that object. This other object is called as dependency.

-   **What is Service Locator Pattern?**<br/>
    A) Service Locator Pattern uses central Registry known as Service Locator which upon request provides objects for our class. This pattern has severe criticism that its an Anti-Pattern.

-   **What is Anti-Pattern?**<br/>
    A) An anti-pattern are certain patterns in software development that are considered bad programming practices.<br/>
    For more, click [Here](https://stackoverflow.com/a/980616/3424919).

-   **What is the use-case of @BindsInstance Annotation?**<br/>
    A) @BindsInstance is used to bind the available data at the time of building the Component. For example, while I needed to build dagger graph and username is already available to me, then I can bind that username to that dagger dependency graph as follows:
    
    ```java
        @Component.Builder
        interface Builder {
            @BindsInstance Builder userName(@UserName String userName);
            AppComponent build();
        }
    ```


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
[Getting Started with RxJava2](https://www.coderefer.com/blog/rxandroid-tutorial-getting-started/)

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
