package br.com.beautysystem

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log


open class DebugActivity : AppCompatActivity(){
    private  val TAG = "LMSApp"
    private val classname:String
    get(){
        val s = javaClass.name
        return s.substring(s.lastIndexOf("."))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG,".onCreate() chamado")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG,"$classname.onStart() chamado")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG,"$classname.onReume() chamado")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG,"$classname.onRestart() chamado")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG,"$classname.onPause() chamado")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG,"$classname.onStop() chamado")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"$classname.onDestroy() chamado")
    }


}

// sobscrever onResume,onRestart,onPause,onStop,OnDestroy