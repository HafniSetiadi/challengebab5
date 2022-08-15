package com.setiadi.myapplicationbab5

//V2#5 buat interface sebagai jembatan fragment kotlin/class > interface >Communicator

interface Communicator {

//V2#5 buat function utk terima Input text (  android:id="@+id/messageInput")
// next implement interface ini di main activity

    fun passDataCom(editTextInput: String)

    fun navigateActivity()

    }

