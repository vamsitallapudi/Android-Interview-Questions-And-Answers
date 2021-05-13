-   **Is Java a Pass By Value or Pass by Reference?**<br/>
    A) Java is always a Pass by Value. Any value which is modified in the called function will not be reflected in the calling function. For Example, [Click Here.](https://stackoverflow.com/a/12429953/3424919)

- **ArrayLists vs Vectors?** <br>
    A) Arraylists are to be preferred by default.
    1. Vector doubles its capacity when additional elements are to be accommodated where as Arraylists increases their size by 50%.
    2. Vector is Thread-Safe where as Arraylist is by default not thread-safe.
    3. Since ArrayLists are not thread-safe (non-synchronized), they are usually fast.

- **What is Synchronization in Java?** <br>
    A) Synchronization in Java is the ability to control the access to code block by allowing only one thread to work on it at a time. One thread acquires the lock while working on this code block and any other thread trying to access the same code block will have to wait until the first thread releases the lock after the execution of code block is completed.

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
| 3. HashMap is fast as it is Non-Synchronized and it is usually preferred if thread-safety is not a priority | 2. HashTable is usually slow compared to HashMap since it is Synchronized |

<!-- TABLE_GENERATE_END -->

<br>

- **What is the time complexity to Insert into HashMap?** <br>


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


- **Does HashMap maintains Order in which items are inserted?** <br>
  A) 


- **What is the Time and Space Complexity to insert into a HashMap?** <br>
  A)