-   **Is Java a Pass By Value or Pass by Reference?**<br/>
    A) Java is always a Pass by Value. Any value which is modified in the called function will not be reflected in the calling function. For Example, [Click Here.](https://stackoverflow.com/a/12429953/3424919)

- **ArrayLists vs Vectors?** <br>
    A) <br>
    1. Vector doubles its capacity when additional elements are to be accommodated where as Arraylists increases their size by 50%.
    2. Vector is Thread-Safe where as Arraylist is by default not thread-safe.
    3. Since ArrayLists are not thread-safe (non-synchronized), they are usually fast.

- **If ArrayList is not thread-safe, how do you make it synchronized?** <br>
    A) We can make an arraylist as thread-safe in two ways: <br>
        1. By using Collections.synchronisedList() from collection framework which returns a synchronized version of the list. When we add / remove from list we don't need explicit synchronization but when we are traversing the values from this list, we need to use explicit synchronization.<br>

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
