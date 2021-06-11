# Kotlin Interview Questions And Answers

-   **lateinit vs lazy?**<br/>
    A) lateinit can be used for var properties where Kotlin promises the compiler that the variable will be initialized later failure of which will lead to exception.
    lazy can only be used for val properties. It will be initialized during the first call where the value will be stored in a cache so that another call to the same variable will serve the value stored in cache.

-   **What are the types of equality in Kotlin?**<br>
    A) There are two types of equality in Kotlin - <br>
    **1) Referential Equality (===):** It tells whether the two references are pointing to same address or not. In Kotlin it is represented with '===', unlike in Java where it is represented with '=='.

    **2) Structural Equality (==):** Structural equality tells whether the data inside objects is equal or not.  Java is  Structural equality in Kotlin is represented by '==' where as in Java it is done by .equals() method.

    In Kotlin also we can use .equals method but it is recommended to use == because Kotlin internally converts a==b, for example, to the following code:
```java
    a?.equals(b) ?: (b === null)
```


-   **What is the use of vararg keyword in Kotlin?**<br/>
    A) varargs are used to pass unlimited variables to the constructor.

    ```java
        fun sum(vararg values : Int) =  values.sum()
        assertEquals(5, sum(2,3)) // true
    ```

-   **What are Destructuring Declarations in Kotlin?**<br/>
    A) Destructuring declarations allows us to destructure an object to various variables.

    Let us take a data class for example. We know that whenever we pass args to data class, Kotlin creates a component for each arg, named - component1(), component2() etc.

    Destructured declarations simply points to those components in the same order respectively.

    Here's an example: 
        
    ```Java
    data class Person(val name: String, val age: Int)

    // destructuring declarations
    val (username, userAge) = Person("vamsi", "21")
    println(username) // vamsi
    ```
    Here these username and userAge will directly point to the component functions of data class internally as follows:
    ```java
    val username = Person.component1()
    val userAge = Person.component2()
    ```


-   **What are Data Classes?**<br/>
    A) Data classes are specifically designed to hold the data. 
    In data classes, the Designers of Kotlin has overrided methods - equals(), hashcode() and toString() internally to feciliate the data holding capabilities.

    The main uses of data classes - 
    1. They can be easily copied structurally using copy() function,
    2. They can be used for destructuring declarations
    3. They also can inherit classes and interfaces

    Limitations of Data Classes:
    1. They cannot be open
    2. They cannot inherit another data class
    3. varargs cannot be used as arguments in data class as the data class internally needs to generate toString() and hashcode() method's logic.

-   **If we create two data class objects with same data then are they equal?**<br/>
    A) Those two data are objects are equal structurally but not referentially. 

    Here is an example:
    ```java
        data class Person(name:String)
        //creating objects for data class
        val a = Person("Vamsi")
        val b = Person("Vamsi")
        println(a==b) // true; a normal class would return false in this case
        println(a===b) // false
    ```