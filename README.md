# Android Interview Questions And Answers

**1) How to save password safely in Android?**
<br/>
A) Using Android Keystore
<br/>
https://medium.com/@josiassena/using-the-android-keystore-system-to-store-sensitive-information-3a56175a454b

**2) String a = “abc”;  String b = new String(“abc”); Will a == b ??**
<br/>
A) It depends. Here with the first statement, i.e, String a = “abc”, JVM will search for a string with “abc” in String constant pool(SCP) and if its not there it will create a new Object.
If we wrote second statement similarly, i.e., String b = “abc”, then b will point to same string from SCP.
However, String b = new String(“abc”) always creates a new String object.
