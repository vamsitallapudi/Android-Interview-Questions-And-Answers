# Kotlin Interview Questions And Answers

-   **lateinit vs lazy?**<br/>
    A) lateinit can be used for var properties where Kotlin promises the compiler that the variable will be initialized later failure of which will lead to exception.
    lazy can only be used for val properties. It will be initialized during the first call where the value will be stored in a cache so that another call to the same variable will serve the value stored in cache.

-   **What are the types of equality in Kotlin?**<br>
    A) There are two types of equality in Kotlin - <br>
    **1) Referential Equality (===):** It tells whether the two references are pointing to same address or not. In Kotlin it is represented with '===', unlike in Java where it is represented with '=='.

    **2) Structural Equality (==):** Structural equality tells whether the data inside objects is equal or not.  Java is  Structural equality in Kotlin is represented by '==' where as in Java it is done by .equals() method.

    In Kotlin also we can use .equals method but it is recommended to use == because Kotlin internally converts a==b, for example, to the following code:
```Kotlin
    a?.equals(b) ?: (b === null)
```


-   **What is the use of vararg keyword in Kotlin?**<br/>
    A) varargs are used to pass unlimited variables to the constructor.

    ```Kotlin
        fun sum(vararg values : Int) =  values.sum()
        assertEquals(5, sum(2,3)) // true
    ```

-   **What are Destructuring Declarations in Kotlin?**<br/>
    A) Destructuring declarations allows us to destructure an object to various variables.

    Let us take a data class for example. We know that whenever we pass args to data class, Kotlin creates a component for each arg, named - component1(), component2() etc.

    Destructured declarations simply points to those components in the same order respectively.

    Here's an example: 
        
    ```Kotlin
    data class Person(val name: String, val age: Int)

    // destructuring declarations
    val (username, userAge) = Person("vamsi", "21")
    println(username) // vamsi
    ```
    Here these username and userAge will directly point to the component functions of data class internally as follows:
    ```Kotlin
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
    ```Kotlin
    data class Person(name:String)
    //creating objects for data class
    val a = Person("Vamsi")
    val b = Person("Vamsi")
    println(a==b) // true; a normal class would return false in this case
    println(a===b) // false
    ```
-   **What are various scoping functions in Kotlin and when to use each of them?**<br/>
    A) There are 5 different scoping functions in Kotlin - let, apply, also, with, run

    <b>1. Let:</b> let is an extension function that takes lambda block as parameter, has 'it' as object reference inside the block and returns the lambda block's result as return type.

    Here's the syntax of let:
    ```Kotlin
    inline fun <T, R> T.let(block: (T) -> R): R {
        return block(this)
    }
    ```


    Here's an example:
    ```Kotlin
    val fullName : String = Person()?.let {
        it.name = "Vamsi"
        it.name + " Tallapudi" // return value
    }
    println(fullName) //Vamsi Tallapudi
    ```
    <b>2. with:</b> with takes the context object and the code block (lambda) as the arguments, has 'this' as object reference inside the block and performs the lambda functions operation on the context passed. Returns the lambda result as return value.

    Here's the syntax:
    ```Kotlin
    inline fun <T, R> with(receiver: T, block: T.() -> R): R {
        return receiver.block()
    }
    ```

    Here's an example:
    ```Kotlin
    val myList = mutableListOf(1, 2, 3, 4, 5)
    val additionOfSquares = with(myList) {
        val squaresList= map { it * it }
        squaresList.sum() //returns the sum value
    }
    println(additionOfSquares) // 55
    ```

    <b>3. apply:</b> <i>apply</i> is an extension function that takes  the code block (lambda) as an argument, has 'this' as object reference inside the block and performs the lambda function on the context. Returns context object as the return value.

    ```Kotlin
    val vamsi = Person().apply {
        name = "Vamsi"
        age = 21
    }
    println(vamsi.age) // 21
    ```


    <b>4. also:</b> <i>also</i> is an extension function that takes  the code block (lambda) as an argument, has 'it' as object reference inside the block and performs the lambda function on the context. Returns context object as the return value.

    ```Kotlin
    val vamsi = Person().apply
    {
        name = "Vamsi"
    }.also {
        it.age = 21
    }
    println(vamsi.age) // 21
    ```

    <b>4. run:</b> <i>run</i> is an extension function that takes  the code block (lambda) as an argument, has 'this' as object reference inside the block and performs the lambda function on the context. Returns the lambda result as return value.

    ```Kotlin
    val vamsi = Person().apply
    {
        name = "Vamsi"
    }.also {
        it.age = 21
    }
    println(vamsi.age) // 21
    ```
    
    For more details, [Click Here.](https://medium.com/@fatihcoskun/kotlin-scoping-functions-apply-vs-with-let-also-run-816e4efb75f5)
