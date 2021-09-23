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
    Note: Only one vararg can be passed to a function. Multiple varargs leads to compilation error.

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
        println(a==b) // true; a normal class (without .equals() overridden) would return false in this case
        println(a===b) // false
    ```
-   **What are various scoping functions in Kotlin and when to use each of them?**<br/>
    A) There are 5 different scoping functions in Kotlin - let, apply, also, with, run. Basically they are used to execute a block of code within the context of an object.

    ***Scope Functions Table:***

    ![Scope Functions Table](/assets/kotlin/scope-funcs-table.png)

    <b>1. Let:</b> <i>let</i> is an extension function that takes lambda block as parameter, has 'it' as object reference inside the block and returns the lambda block's result as return type.

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
    <b>2. with:</b> <i>with</i> takes the context object and the code block (lambda) as the arguments, has 'this' as object reference inside the block and performs the lambda functions operation on the context passed. Returns the lambda result as return value.

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

    Here's the syntax:
    ```Kotlin
    public inline fun <T> T.apply(block: T.() -> Unit): T {
        ...
        block()
        return this
    }
    ```
    Here's an example:

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

-   **What are inline functions? When to use them?**<br/>
    A) Functions that take lambda parameter as arguments generates objects inside calling function's code. If these functions are called at multiple places, multiple objects are created which affects the performance of our Android App. To avoid these memory allocations created by lambda expressions (anonymous objects are created), we make the functions inline by adding a keyword - 'inline' to our function.

    ```Kotlin
    inline fun SharedPreferences.edit(commit: Boolean = false, action: SharedPreferences.Editor.() -> Unit) {
        val editor = edit()
        action(editor)
        if(commit)
            editor.commit()
        else
            editor.apply()

    }
    ```
    Inline functions are generally used when we need to pass small functions as parameters. It is generally not advisable to pass large functions to inline functions.

-   **What are noinline keyword? Where we need to use them in realtime scenario?**

    A) We cannot pass a lambda function, which comes as argument inside inline function, to another function that accepts lambda. We will get an error stating 'Illegal usage of inline-parameter'. In this case we need to pass that lambda function with noinline keyword which makes the compiler instead of writing the code to the called location, creates the function for that specific function.

    Here's an example:
    ```Kotlin
    inline fun SharedPreferences.edit(
    commit: Boolean = false,
    noinline anotherFunction: Int.() -> Unit = {},
    action: SharedPreferences.Editor.() -> Unit)
    {
        // passing noinline function to another function
        myFun(anotherFunction)

        val editor = edit()
        action(editor)
        if(commit)
            editor.commit()
        else
            editor.apply()

    }

    fun myFun(importantAction: Int.() -> Unit) {
        importantAction(-1)
    }
    ```

    We'll use this only in case if multiple lambdas are passed to function arguments. If there is only one lambda which need to be referenced in another function, we better not use inline function at all.



-   **What is the use of crossinline in Kotlin?**
    
    A) When we don't want to return inside lambda function (non-local returns) that is passed as inline argument, we use crossinline keyword on that lambda argument.
    
    Here's an example:
    ```Kotlin
    fun createPerson() {
        val person = Person()
        person.name = "Vamsi"
        performFunction {
            println("Created a person with name: ${person.name}")
    //        return  // Not allowed here as its crossinline
        }
    }

    inline fun performFunction (crossinline x : () -> Unit) {
        x()
    }
    ```

-   **What is the use of infix in Kotlin?**

    A) infix functions are used for declaring a short form notation of a function.

    Here's an example:

    ```Kotlin
    infix fun Int.printSmallest(x: Int) {
        print(if(this < x) this else x)
    }

    1 printSmallest 5 // calling the function directly
    ```

-   **What are Sealed classes in Kotlin?**
    
    A) Sealed classes are similar to enum classes which also has restrictive set of types allowed, except that Sealed classes can contains additional data to be propagated(which we cannot achieve with enum classes).

    ```Kotlin
    sealed class Result<out T: Any> {
        data class Success<out T: Any>(val data: T): Result<T>()
        data class Error(val exception: Exception): Result<Nothing>()
    }
    ```
    Sealed classes can contain any other clases like data class, pojo class, or even other sealed classes.
-   **What is a Coroutine?**
    A) Coroutine is a Lightweight thread which helps in performing Asynchronous programming. Basically it is a concurrency design pattern which helps to run the long-running tasks which otherwise block the main thread.
    Advantages:
    1. Lightweight: We can run many coroutines on a single thread,
    2. Built in Cancellation support: Cancellation is propagated through the running Coroutine Hierarchy.
    3. Fewer Memory leaks due to Structured Concurrency.

-   **What is Structured Concurrency?**
    A)

-   **Does Coroutine runs in a Single thread?**

    A) A coroutine is not bound to any particular thread. It may suspend its execution in one thread and resume in another one.

-   **What is Coroutine Scope?**

    A) Keeps track of any Coroutine created using launch or async functions (these extension functions are available in CoroutineScope).

-   **How to create Coroutine Scope?**

    A) 

