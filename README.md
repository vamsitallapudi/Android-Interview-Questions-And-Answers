# Android Interview Questions And Answers

**1)What is an Application class?**
<br/>
A) An Application class is a base class in your Application starts before all other classes like Activities or services are called. You can maintain your application's global state here. While it is NOT mandatory that you need to extend Application class, you can do so by providing your own implementation by creating a subclass and specifying the fully-qualified name of this subclass as the "android:name" attribute in your AndroidManifest.xml's <application> tag.

**2) How to save password safely in Android?**
<br/>
A) Using Android Keystore
<br/>
https://medium.com/@josiassena/using-the-android-keystore-system-to-store-sensitive-information-3a56175a454b

**3) String a = “abc”;  String b = new String(“abc”); Will a == b ??**
<br/>
A) It depends. Here with the first statement, i.e, String a = “abc”, JVM will search for a string with “abc” in String constant pool(SCP) and if its not there it will create a new Object.
If we wrote second statement similarly, i.e., String b = “abc”, then b will point to same string from SCP.
However, String b = new String(“abc”) always creates a new String object.
