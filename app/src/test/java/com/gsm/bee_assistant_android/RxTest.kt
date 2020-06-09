package com.gsm.bee_assistant_android

import io.reactivex.Observable
import org.junit.Test
import java.util.concurrent.TimeUnit

class RxTest {

    @Test
    fun splashTest() {
        println("start")

        Observable.interval(1000 * 3, TimeUnit.MILLISECONDS)
            .subscribe { println("end") }

        Thread.sleep(3000)
    }
}