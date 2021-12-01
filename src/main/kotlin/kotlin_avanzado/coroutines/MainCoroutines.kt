package kotlin_avanzado.coroutines

import kotlinx.coroutines.*
import javax.swing.plaf.TableHeaderUI

fun main(args: Array<String>) {
//    blokingExample()
//    suspendExample()
//    suspendExample2()
//    dispatchers()
    launch()
    Thread.sleep(7000)
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