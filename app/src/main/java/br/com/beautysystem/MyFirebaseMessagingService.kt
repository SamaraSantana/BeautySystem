package br.com.beautysystem
import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage


class MyFirebaseMessagingService : FirebaseMessagingService() {
    override fun onNewToken(token : String){
        super.onNewToken(token)

        Log.d("BEAUTY SYSTEM","Nove token $token")
        Prefs.setString("FB_TPKEN", token!!)

    }

    override fun onMessageReceived(mensagemRemota: RemoteMessage?) {
        Log.d("BEAUTY SYSTEM", "chamou on message Received")

        if(mensagemRemota?.notification != null){
            val titulo = mensagemRemota?.notification?.title
            val texto = mensagemRemota?.notification?.body

            Log.d("BEAUTY SYSTEM",titulo)
            Log.d("BEAUTY SYSTEM",texto)

        }
    }

}