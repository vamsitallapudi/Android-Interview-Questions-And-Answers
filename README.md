# Android Interview Questions And Answers

**1)What is an Application class?**
<br/>
A) An Application class is a base class in your Application starts before all other classes like Activities or services are called. You can maintain your application's global state here. While it is NOT mandatory that you need to extend Application class, you can do so by providing your own implementation by creating a subclass and specifying the fully-qualified name of this subclass as the "android:name" attribute in your AndroidManifest.xml's <application> tag.

**2) What is a Looper?**<br/>
A) A Looper is a class used to loop through the Message Queue attached to the Thread. By default, a thread halts when the execution completes. But, for Example, if we take Android's Main thread, it should not halt upon execution.
Rather it should loop through the runnables(Messages) that its assigned in order to work properly. For more info:
https://stackoverflow.com/a/34522758/3424919

**3) What is a Handler?**<br/>
A) A Handler allows you to send and process Message and Runnable objects associated with a thread's MessageQueue. Each Handler instance is associated with a single thread and that thread's message queue. When you create a new Handler, it is bound to the thread / message queue of the thread that is creating it -- from that point on, it will deliver messages and runnables to that message queue and execute them as they come out of the message queue.


**4) How to save password safely in Android?**
<br/>
A) Using Android Keystore
<br/>
https://medium.com/@josiassena/using-the-android-keystore-system-to-store-sensitive-information-3a56175a454b

**5) String a = “abc”;  String b = new String(“abc”); Will a == b ??**
<br/>
A) It depends. Here with the first statement, i.e, String a = “abc”, JVM will search for a string with “abc” in String constant pool(SCP) and if its not there it will create a new Object.
If we wrote second statement similarly, i.e., String b = “abc”, then b will point to same string from SCP.
However, String b = new String(“abc”) always creates a new String object.
