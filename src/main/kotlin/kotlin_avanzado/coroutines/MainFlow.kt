package kotlin_avanzado.coroutines

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlin.system.measureTimeMillis

fun main(args: Array<String>) {
//    show()
   /* runBlocking {
        runAsynchronous().forEach {i->  println(i)}
    }

    runBlocking {
        launch {
            for (j in 1..3) {
                println("No estoy bloqueado $j")
                delay(1000)
            }
        }

        /**Recuperar los valores que se están transmitiendo*/
        firstFlow().collect { value-> println(value) }
    }

    runBlocking {
        println("Llamando Flow...")
        val flow = firstFlow()
        println("Collect...")
        flow.collect {value-> println(value)}
        println("Collect again...")
        flow.collect {value-> println(value)}
    }

    runBlocking {
        withTimeoutOrNull(2500) {
            firstFlow().collect {value-> println(value)}
        }
        println("Finalizado")
    }

    runBlocking {
//        secondFlow().collect {value-> println(value)}
        thirdFlow().collect {value-> println(value)}
    }*/

   /* runBlocking {
        (1..3).asFlow()
            .map {request-> performRequest(request)}
            .collect {response-> println(response) }
    }*/

   /* runBlocking {
        (1..3).asFlow()
            .filter { request-> request > 1 }
            .map { request-> performRequest(request) }
            .collect {response-> println(response)}
    }*/

    /*runBlocking {
        (1..3).asFlow()
            .transform {request->
                emit("Making request $request")
                emit(performRequest(request))
            }
            .collect {response-> println(response) }
    }*/

   /* runBlocking {
        (1..3).asFlow()
            .take(2)
            .collect {response-> println(response)}
    }*/

   /* runBlocking {
        val lista: List<Int> = (1..3).asFlow().toList()
        println(lista)
    }*/

   /* runBlocking {
       val numero =  (1..3).asFlow().first()
        println(numero)
    }*/

   /* runBlocking {
        val resultado = (1..5).asFlow().reduce{ a, b-> a + b }
        println(resultado)
    }*/

   /* runBlocking {
        (1..5).asFlow()
            .filter {i->
                println("Filtrado $i")
                i % 2 == 0
            }
            .map {i->
                println("Map $i")
                "String $i"
            }
            .collect {i-> println("Collect $i")  }
    }*/

    /*runBlocking {
        //Nos devuelve el tiempo en milisegundos de todoo lo que se lleva a cabo dentro
        val time = measureTimeMillis {
            firstFlow()
                .buffer()
                .collect {value ->
                delay(300)
                println(value)
            }
        }

        println("$time ms")
    }*/

    /*runBlocking {
        //Nos devuelve el tiempo en milisegundos de todoo lo que se lleva a cabo dentro
        val time = measureTimeMillis {
            firstFlow()
                .conflate()
                .collect {value ->
                    delay(300)
                    println(value)
                }
        }

        println("$time ms")
    }*/

   /* runBlocking {
        //Nos devuelve el tiempo en milisegundos de todoo lo que se lleva a cabo dentro
        val time = measureTimeMillis {
            firstFlow()
                .collectLatest {value ->
                    println("Collecting $value")
                    delay(300)
                    println("Finalizado $value")
                }
        }

        println("$time ms")
    }*/

   /* val num = (1..3).asFlow()
    val strs = flowOf("Uno", "Dos", "Tres")
    runBlocking {
        num.zip(strs) {a, b->
            "Zip: $a -> $b"
        }.collect { println(it) }
    }*/

    /*runBlocking {
        //Aqui se nos está creando un flujo de flujos, para poder procesarlo lo hacemos que sea un solo flujo
        val ejemplo = (1..3).asFlow().map { requestFlow(it) }
    }*/

    /*runBlocking {
        val startTime = System.currentTimeMillis()
        (1..3).asFlow().onEach { delay(100) }
            .flatMapConcat { requestFlow(it) }
            .collect {value-> println("$value at ${System.currentTimeMillis() - startTime} ms from start") }
    }*/

    runBlocking {
        val startTime = System.currentTimeMillis()
        (1..3).asFlow().onEach { delay(100) }
            .flatMapMerge { requestFlow(it) }
            .collect {value-> println("$value at ${System.currentTimeMillis() - startTime} ms from start") }
    }
}

fun requestFlow(i: Int) = flow {
    emit("$i: First")
    delay(500)
    emit("$i: Second")
}

fun show() {
//    listar().forEach { i-> println(i) }
    secuencia().forEach { i-> println(i) }
}

fun listar() = listOf(3,95,90,45)

fun secuencia(): Sequence<Int> = sequence {
    for (i in 1..3) {
        Thread.sleep(1000)
        yield(i)
    }
}

/**De forma asincrona*/
suspend fun runAsynchronous() = runBlocking {
    delay(1000)
    return@runBlocking listOf(1, 2, 3)
}

/**Primer flow*/
fun firstFlow(): Flow<Int> = flow {
    for (i in 1..3) {
        delay(100)
        emit(i)
    }
}

fun secondFlow(): Flow<Int> = flowOf(1,2,3) //flowOf nos permite devolver cualquier cosa

fun thirdFlow(): Flow<Int> = (1..3).asFlow()

suspend fun performRequest(request: Int): String {
    delay(1000)
    return "Response $request"
}
