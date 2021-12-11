package kotlin_avanzado.coroutines

import kotlinx.coroutines.*
import javax.swing.plaf.TableHeaderUI
import kotlin.system.measureTimeMillis

fun main(args: Array<String>) {
//    blokingExample()
//    suspendExample()
//    suspendExample2()
//    dispatchers()
//    launch()
//    exampleJob()
//    Thread.sleep(7000)
//    asyncAwait()
//    asyncAwaitDeferred()
    /**nos devuelve el tiempo que tarda en ejecutarse el código que pongamos dentro*/
    println(measureTimeMillis { asyncAwait() }.toString())
    println(measureTimeMillis { asyncAwaitDeferred() }.toString())
}

/**
 * Función de larga duración para bloquear el hilo principal
 * */
fun longTaskWithMessage(message: String) {
    Thread.sleep(6000)
    println(message + Thread.currentThread().name)
}

fun blokingExample() {
    println("Tarea1: " + Thread.currentThread().name)
//    longTaskWithMessage("Tarea2: ")
//    delayCoroutine("Tarea2: ")
    println("Tarea3: " + Thread.currentThread().name)
}

/**
 * Corrutina con suspend
 * */
suspend fun delayCoroutine(message: String) {
    delay(6000)
    println(message + Thread.currentThread().name)
}

/**
 * Suspend de tipo RunBlocking
 * */
fun suspendExample() {
    println("Tarea1: " + Thread.currentThread().name)
    runBlocking {
        delayCoroutine("Tarea2: ")
    }
    println("Tarea3: " + Thread.currentThread().name)
}
fun suspendExample2() = runBlocking {
    println("Tarea1: " + Thread.currentThread().name)
    runBlocking {
        delayCoroutine("Tarea2: ")
    }
    println("Tarea3: " + Thread.currentThread().name)
}

/**
 * Función con dispatcher decirle en que hilo se va ejecutar
 * */
@ObsoleteCoroutinesApi
fun dispatchers() {
    runBlocking {
        println("Hilo en el que se ejecuta 1: ${Thread.currentThread().name}")
    }
    //No nos intereza en que hilo se va a ejecutar la corrutina puede ser cualquiera
    runBlocking(Dispatchers.Unconfined) {
        println("Hilo en el que se ejecuta 2: ${Thread.currentThread().name}")
    }
    //Se suele utilizar para las funciones que haran uso intensivo del CPU
    runBlocking(Dispatchers.Default) {
        println("Hilo en el que se ejecuta 3: ${Thread.currentThread().name}")
    }
    //Entrada y salida de datos
    runBlocking(Dispatchers.IO) {
        println("Hilo en el que se ejecuta 4: ${Thread.currentThread().name}")
    }
    //Creamos un nuevo hilo
    runBlocking(newSingleThreadContext("MiHilo")) {
        println("Hilo en el que se ejecuta 5: ${Thread.currentThread().name}")
    }
    //Main hilo principal este solo lo podemos usar en Android Studio aquí nos tirará una exception
   /* runBlocking(Dispatchers.Main) {
        println("Hilo en el que se ejecuta 6: ${Thread.currentThread().name}")
    }*/
}

/**
 * Crear corrutina a través de launch
 * */
fun launch() {
    println("Tarea1: " + Thread.currentThread().name)
    GlobalScope.launch {
        delayCoroutine("Tarea2: ")
    }
    println("Tarea3: " + Thread.currentThread().name)
}

/**
 * Ejemplo de un job este nos los devuelve el launch
 * */
fun exampleJob() {
    println("Tarea1: ${Thread.currentThread().name}")
    val job = GlobalScope.launch {
        delayCoroutine("Tarea2: ")
    }
    println("Tarea2: ${Thread.currentThread().name}")
    job.cancel()
}

/**Simulando que es una funcion de larga duracion*/
suspend fun calculateHard() = run {
    delay(3000)
    15
}
/** Coroutine await*/
fun asyncAwait() = runBlocking {
//    println(System.currentTimeMillis().toString())
    val numero1 = async { calculateHard() }.await()
//    println(System.currentTimeMillis().toString())
    val numero2 = async { calculateHard() }.await()
//    println(System.currentTimeMillis().toString())
    val resultado = numero1 + numero2
    println(resultado.toString())
}

/**AsuncAwait Deferred*/
fun asyncAwaitDeferred() = runBlocking {
//    println(System.currentTimeMillis().toString())
    val numero1 = async { calculateHard() }
//    println(System.currentTimeMillis().toString())
    val numero2 = async { calculateHard() }
//    println(System.currentTimeMillis().toString())
    val resultado = numero1.await() + numero2.await()
    println(resultado.toString())
}

/**WithContext*/
fun withContextIO() = runBlocking {
    val numero1 = withContext(Dispatchers.IO) { calculateHard() }
    val numero2 = withContext(Dispatchers.IO) { calculateHard() }
    val resultado = numero1 + numero2
    println(resultado.toString())
}