# Frequently Asked Java Questions in Android Interviews

-   **Is Java a Pass By Value or Pass by Reference?**<br/>
    A) Java is always a Pass by Value. Any value which is modified in the called function will not be reflected in the calling function. For Example, [Click Here.](https://stackoverflow.com/a/12429953/3424919)

-   **What are different types of Polymorphism?**<br/>
    A) There are 2 Types of Polymorphism in Java.
    1. **CompileTime Polymorphism**<br/> It is the polymorphism which in which JVM knows which method to call at compile time. Method Overloading is a good example of this type of polymorphism.

    ```java
    // compile-time polymorphism
    public class Coderefer {
    
        // First addition function
        public static int add(int a, int b)
        {
            return a + b;
        }
    
        // Second addition function
        public static double add(
            double a, double b)
        {
            return a + b;
        }
    
        // Driver code
        public static void main(String args[])
        {
            // Here, the first addition
            // function is called
            System.out.println(add(2, 3));
    
            // Here, the second addition
            // function is called
            System.out.println(add(2.0, 3.0));
        }
    }
    ```

    2. **RunTime Polymorphism**<br/> It is the polymorphism which in which JVM knows which method to call at run time. Method Overriding is a good example of this type of polymorphism.

    ```java
    // run-time polymorphism
    class Test {
    
        // Implementing a method
        public void method()
        {
            System.out.println("Method 1");
        }
    }
 
    // Defining a child class
    public class Coderefer extends Test {
    
        // Overriding the parent method
        public void method()
        {
            System.out.println("Method 2");
        }
    
        // Driver code
        public static void main(String args[])
        {
            Test test = new Coderefer();
    
            test.method();
        }
    }

    // Output: Method 2
    ```

-   **Why do we need Getters and Setters in Java? Why cant we access them directly by making them Public**<br/>

    A) They ensure Encapsulation in Java so that they will restrict the access directly. The classes which own the fields and they have control over the data passed. They can perform validation checks before setting the data or they can check if the requested getter parameter is null and initialize the data.

-   **String a = “abc”;  String b = new String(“abc”); Will a == b ??**<br/>
    A) It depends. Here with the first statement, i.e, String a = “abc”, JVM will search for a string with “abc” in String constant pool(SCP) and if its not there it will create a new Object.
    If we declare it again, i.e., String b = “abc”, then b will point to same string from SCP.
    However, String b = new String(“abc”) always creates a new String object.

-   **What is the difference between == and .equals() method in Java?**<br/>
    A) == method refers to referential comparision. It checks if two variables are referencing to same memory address or not where as .equals() compares the structure (data) of two objects.

    ```java
        String a = new String("Hello");
        String b = new String("Hello");
        System.out.println(a==b); // false
        System.out.println(a.equals(b)); // true
    ```
    In java.lang.Object class, .equals() simply check for == but for other implementations of objects like String, Integer, Double, they check for structure consistency.
    ```java
    // Internal code of .equals() in object class:
    public boolean equals(Object obj) {
        return (this == obj);
    }

    // Internal code of .equals() in String class
        public boolean equals(Object anObject) {
        if (this == anObject) {
            return true;
        }
        if (anObject instanceof String) {
            String aString = (String)anObject;
            if (!COMPACT_STRINGS || this.coder == aString.coder) {
                return StringLatin1.equals(value, aString.value);
            }
        return false;
    }
    ```


- **Why Java does not support Multiple Inheritance?**<br>
    A) If we inherit from two classes which have methods of same name, it is difficult for JVM to choose which one to inherit from. Hence creators of Java decided to skip multiple inheritance where as other languages like C++, Python supports Multiple Inheritance, where you have to specify explicitly specify which super class's method you need to use.

- **What is the difference between Interface and Abstract Class?**<br>
    A) We can inherit multiple interfaces in Java using Interfaces where as we can inherit only one Abstract class. Abstract classes can access fields of a particular object so you can access or modify the state of the object where as in interfaces you cannot modify the state of the object.

- **Can you create an object for Abstract Class directly?**<br>
    A) No, we cannot create an object of an abstract class, but we can create a reference variable of an abstract class pointing to the object of its implementation.

- **Can you create an object for an Interface directly?**<br>
    A) No, similar to abstract class, we cannot create an object of an Interface. But we can create a reference variable of an Interface pointing to the object of its implementation.


-   **Heap Space vs Stack Memory in Java?**<br/>
    A) 
        <!-- TABLE_GENERATE_START -->

    | Heap Space                                                                                                                                                 | Stack Memory                                                                                                                                                                                                                                |
    | ---------------------------------------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
    | 1. Heap space is used for dynamic memory allocation of Java objects and JRE classes at runtime. Whenever a new object is created, it exists in Heap Space. | 1. Stack Memory is used in Java for static memory allocation. Whenever a new method is called for execution, a new block on top of stack is created which contains the primitive variables and references to objects related to that method |
    | 2. If memory is full, JVM throws java.lang.OutOfMemoryError                                                                                                | 2. Whenever the stack memory is full, JVM throws java.lang.StackOverflowError                                                                                                                                                               |
    | 3. Access to this memory is slow comparitively.                                                                                                            | 3. Access to this memory is faster compared to Heap Space.                                                                                                                                                                                  |
    | 4. Not thread-safe                                                                                                                                         | 4. It is thread-safe.                                                                                                                                                                                                                       |
    <!-- TABLE_GENERATE_END -->

- **ArrayLists vs Vectors?** <br>
    A) Arraylists are to be preferred by default.
    1. Vector doubles its capacity when additional elements are to be accommodated where as Arraylists increases their size by 50%.
    2. Vector is Thread-Safe where as Arraylist is by default not thread-safe.
    3. Since ArrayLists are not thread-safe (non-synchronized), they are usually fast.

- **What is Synchronization in Java?** <br>
    A) Synchronization in Java is the ability to control the access to code block by allowing only one thread to work on it at a time. One thread acquires the lock on the object while working on this code block and any other thread trying to access the object's any synchronized block / method will have to wait until the first thread releases the lock (after the execution of code block is completed).

- **What are Fail-Fast and Fail-Safe Iterators?**<br>
    A) Fail-Fast iterators raise ***ConcurrentModificationException*** when an error occurs. Eg: Collections.synchronizedMap() for HashMap & Collections.synchronizedList() for ArrayList.
    
    Fail-Safe are error tolerant and continues to work even after an error occurs. Eg: CopyOnWriteArrayList for ArrayList & ConcurrentHashMap for HashMaps

- **If ArrayList is not thread-safe, how do you make it synchronized?** <br>
    A) We can make an arraylist as thread-safe in two ways: <br><br>
        **1. Collections.synchronisedList()**<br> from collection framework which returns a synchronized version of the list. When we add / remove from list we don't need explicit synchronization but when we are traversing the values from this list, we need to use explicit synchronization.<br>

    ```java
        List<String> list = new ArrayList<>();
        list.add("Java");
        list.add("Python");
        list.add("C++");
        // synchronizing array list in java
        List<String> syncList = Collections.synchronizedList(list);

        // using synchronize block in order to avoid non-deterministic behavior
        synchronized (this) {
            Iterator<String> listIter = syncList.iterator();
            while(listIter.hasNext()) {
                System.out.println(listIter.next());
            }
        }
    ```
    <br>**2. CopyOnWriteArrayList**<br>
        This is a thread-safe variant of ArrayList. It is the part of java.util.concurrent package of java. When multiple threads are operating on this arraylist and if any thread want to perform write operation, a cloned copy of that arraylist will be created where the write operation is performed and at later point, JVM syncs these two arraylist copies.

    ***Disadvantages of CopyOnWriteArrayList:*** Since for every thread which performs write operation, a new copy of arraylist is created, if these operations increases, more memory is used.

```java
    CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
    list.add("Java");
    list.add("Python");
    list.add("C++");

    //No explicit synchronization is needed during iteration
    Iterator<String> it = list.iterator();
    while(it.hasNext()) {
        System.out.println(it.next());
    }
```
<br>

- **HashMap vs HashTable** <br>
    A) 
    <!-- TABLE_GENERATE_START -->

    | HashMap                                                                                                     | HashTable                                                                 |
    | ----------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------- |
    | 1. HashMap is non-synchronized                                                                              | 1. HashTable is synchronized, hence Thread-safe                           |
    | 2. HashMap allows one Null Key and multiple Null Values                                                     | 2. HashTable does not allow any null keys or null values                  |
    | 3. HashMap is fast as it is Non-Synchronized and it is usually preferred if thread-safety is not a priority | 3. HashTable is usually slow compared to HashMap since it is Synchronized |
    | 4. HashMap is the most used class                                                                           | 4. HashTable is a legacy class                                            |
    <!-- TABLE_GENERATE_END -->

<br>

- **What is the time complexity for various operations of HashMap / HashTable?** <br>
    A) Insert -> Average - O(1), Worst Case - O(N)<br>
    Search -> Average - O(1), Worst Case - O(N)
    Delete -> Average - O(1), Worst Case - O(N)
    For More details, see [Wiki](https://en.wikipedia.org/wiki/Hash_table).


- **How do you make a HashMap Synchronized?** <br>
  A) In Java, HashMap is not synchronized by default. When multiple threads perform write operations, it can result in an inconsistent state of HashMap. We can make a HashMap synchronized in two ways.

  **1. ConcurrentHashMap**<br>
  ConcurrentHashMap is available in java.util.concurrent package. This is the default choice when building synchronized HashMap. Iterator From ConcurrentHashMap are Fail-Safe in Nature.

  ```java
        ConcurrentHashMap<Integer, String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put(1, "India");
        concurrentHashMap.put(2, "USA");
        concurrentHashMap.put(3, "Australia");

    //  reading requires no synchronization
        System.out.println(concurrentHashMap.get(1));

    //  use synchronization so that other threads can see the changes applied by one thread
        Iterator<Map.Entry<Integer, String>> iter = concurrentHashMap.entrySet().iterator();
        synchronized (concurrentHashMap) {
            while(iter.hasNext()) {
                System.out.println(iter.next().getValue());
            }
        }
  ```
  **2.Collections.synchronizedMap()**
  Synchronized HashMap allows only one thread to perform read / write operations at a time as all of its methods are declared synchronized. Iterators from both classes shold be used inside synchronized block but the iterator from Synchronized HashMap is Fail-Fast.

  ```Java
        Map<Integer, String> studentsMap = new HashMap<>();
        studentsMap.put(1, "Gowri");
        studentsMap.put(2, "Vamsi");
        studentsMap.put(3, "Krishna");

        Map<Integer, String> syncMap =          Collections.synchronizedMap(studentsMap);

    // synchronized block is required to iterate through Synchronized hashmap for consistency of data between threads
    synchronized (syncMap) {
        Iterator<Map.Entry<Integer, String>> studentsEntry =
        syncMap.entrySet().iterator();

        while(studentsEntry.hasNext()) {
            System.out.println(
                studentsEntry.next().getValue()
                );
        }
    }
  ```


- **Does HashMap maintains Order in which items are inserted?** <br>
  A) No. We have to use LinkedHashMap to maintain the order.

- **What is a LinkedHashMap?** <br>
  A) LinkedHashMap maintains the order in which items are inserted. LinkedHashMap is same as HashMap - non-synchronized and contains one Null Key and multiple Null Values, the additional feature is it maintains insertion order.

- **What is a TreeMap?** <br>
    A) A TreeMap is sorted by Keys. Here is an example:

    ```java
        Map<Integer, String> registry = new TreeMap<>();
        registry.put(10, "Vamsi");
        registry.put(1, "Krishna");
        registry.put(5, "Tallapudi");
        Iterator<Map.Entry<Integer, String>> iterator = registry.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<Integer, String> registryEntry = iterator.next();
            System.out.println("Name: " + registryEntry.getValue() + ", Roll No: " + registryEntry.getKey());
        }

        /*  OUTPUT:
            Name: Krishna, Roll No: 1
            Name: Tallapudi, Roll No: 5
            Name: Vamsi, Roll No: 10
        */
    ```

    Here as we can see entries are sorted by their keys - Roll Numbers. If we want to sort by Strings, we need to use custom comparator.

- **What are various types of References in Java?** <br>
    A) In Java, there are 4 types of references differentiated based on the way by which they are garbage collected:
    1. Strong Reference,
    2. Weak Reference,
    3. Soft Reference,
    4. Phantom Reference

- **What is Strong Reference?** <br>
    A) This is the default type of Reference for an Object. Any Object which has strong reference is not eligible for Garbage Collection. The object is eligible for garbage collection only if its strongly referenced variable points to null.
    ```java
    Person p = new Person();
    p = null; // now p is pointing to null, hence the new Person() object which is created is now eligible for GC
    ```
    <br>

- **What is a Weak Reference?** <br>
    A) Weak Reference Objects are not default. We have to explicitly specify while using them.<br>
    By using Weak Reference Objects, JVM can identify these objects and mark them as eligible for garbage collection.<br>
    Here is a typical example for Weak Reference:
    ```java
        Person p = new Person();
        WeakReference<Person> personWeakReference = new WeakReference<>(p);
        p = personWeakReference.get(); // making this p which is strongly referenced, now point to weak reference
        if (p != null) { // null check because garbage collector might have collected it.
            p.getName();
        }
    ```
    <br>

    In real-time, they can be used for ImageViews referencing in Android where if user goes to another screen, the imageview's reference is eligible for garbage collection.

    ```java
        class BitmapWorkerTask extends AsyncTask<Integer, Void, Bitmap> {
            private final WeakReference<ImageView> imageViewReference;
            private int data = 0;

            public BitmapWorkerTask(ImageView imageView) {
                // Use a WeakReference to ensure the ImageView can be garbage collected
                imageViewReference = new WeakReference<ImageView>(imageView);
            }

            // Decode image in background.
            @Override
            protected Bitmap doInBackground(Integer... params) {
                data = params[0];
                return decodeSampledBitmapFromResource(getResources(), data, 100, 100));
            }

            // Once complete, see if ImageView is still around and set bitmap.
            @Override
            protected void onPostExecute(Bitmap bitmap) {
                if (imageViewReference != null && bitmap != null) {
                    final ImageView imageView = imageViewReference.get();
                    if (imageView != null) {
                        imageView.setImageBitmap(bitmap);
                    }
                }
            }
        }
    ```
    <br> 

    For more info, [Click Here.](https://stackoverflow.com/a/29590774)

- **What is a Soft Reference?** <br>
    A) In a soft reference, even if an object is free to be garbage collected, then also it is not collected by GC until JVM is in need of memory badly. This object gets cleared from the memory when JVM runs out of memory.

- **What is a Phantom Reference?** <br>
    A) The objects which are being referenced by phantom references are eligible for garbage collection. Phantom reference is used for pre-mortem clean-up actions before the GC removes the object. It can be used as a better replacement to finalize method (finalize can slow down JVM).

- **What is finalize method?** <br>
    A) This method will be called by the Garbage Collector(GC) just before destroying the objects to perform clean-up activities. Some of the clean-up activities are - closing the resources associated with that objects like Database connections, resource deallocation, closing Network connections, etc.

- **What is a WeakHashMap?**<br>
    A) This class is designed to utilize the power of Weak References. WeakHashMap is almost similar to HashMap except one case - if object is specified as key and if it doesn't contain any references, then it is eligible for garbage collection even though it is associated with WeakHashMap - in other words, GC dominates over WeakHashMap.

    ```java
    public class WeakHashMapEg {
        public static void main(String[] args) throws Exception {
            WeakHashMap<Person, Integer> hm = new WeakHashMap<>();
            Person p = new Person();
            Person q = new Person();

            hm.put(p, 1);
            hm.put(q, 1);
            p = null; // making the first person object eligible for gc
            System.out.println("before: " + hm);
            System.gc(); //calling garbage collector
            Thread.sleep(1000);
            System.out.println("after: " + hm);

        }

        static class Person {
            @Override
            protected void finalize() throws Throwable {
                System.out.println("Calling finalize method");
                super.finalize();
            }
        }
    }
    /* OUTPUT:
        before: {WeakHashMapEg$Person@1fb3ebeb=1, WeakHashMapEg$Person@548c4f57=1}
        Calling finalize method
        after: {WeakHashMapEg$Person@548c4f57=1}
    */
    ```
    <br>

- **What is Garbage Collector?**<br>
    A) Whenever new objects are created, they will occupy some memory. When lot of objects are created, then there might be chance that we might get OutOfMemory errors. In Java, Garbage Collector automatically destroys unused objects. An object will be eligible for GC once it becomes unreachable and no variable is referring it.


- **How to make an object eligible for Garbage Collection?**<br>
    A) Generally we can make an object eligible for Garbage Collection in 4 ways:
    1. Assigning the reference variable to null
    2. Re-Assigning the reference variable
    3. Objects created inside a method, after the method execution
    4. By creation of Anonymous objects (i.e., new Obj() without any reference)

- **Can we manually call JVM's Garbage Collector?**<br>
    A) Yes we can. After we make our object as eligible for GC, there is no specific time when the GC will be cleaning this object. Hence if we want to request JVM to run GC, we can do it in two ways:
    1. System.gc()
    2. Runtime.getRuntime().gc()

    Both are effectively equal. **Note:** There is no guarantee that any one of the above two methods will definitely run GC. We are just requesting JVM.



