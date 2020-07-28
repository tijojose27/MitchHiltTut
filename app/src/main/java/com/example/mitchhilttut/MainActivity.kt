package com.example.mitchhilttut

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import javax.inject.Singleton

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    //field Injection
    @Inject
    lateinit var someClass: SomeClass

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        println(someClass.doAThing())

        println(someClass.doSomeOtherClassThing())
    }
}


class SomeClass
@Inject
//constructor injection
constructor(private  val someOtherClass: SomeOtherClass){
    fun doAThing(): String{
        return "Look I did a thing"
    }

    fun doSomeOtherClassThing(): String {
        return someOtherClass.doSomeOtherThing()
    }
}


@Singleton
class SomeOtherClass
@Inject
constructor(){
    fun doSomeOtherThing(): String{
        return "Look I did some other thing"
    }
}