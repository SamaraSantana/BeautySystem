package br.com.beautysystem

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken

object HistoricoService {
/*
    fun getHistoricos (context: Context): List<Historico> {
        val historicos = mutableListOf<Historico>()

        for (i in 1..5){
            val d = Historico()
            d.nome = "Historico $i"
            d.tratamento = "Tratamento $i"
            d.data = "Data $i"
            d.foto = "https://blog.plantei.com.br/wp-content/uploads/2018/06/Ciclame.jpg"
            historicos.add(d)
        }
        return historicos

*/

        val host = "http://beautysystem.pythonanywhere.com"
        val TAG = "WS_LMS"

        fun getHistoricos(context: Context): List<Historico> {
            if(AndroidUtils.isInternetDisponivel(context)) {
            val url = "$host/historicos"
            //val json = URL(url).readText()
            val json = HttpHelper.get(url)
                var historicos:ArrayList<Historico> =  parseJson(json)
                for(d in historicos){
                    saveOffline(d)
                }
                return historicos
            } else {
                val dao = DatabaseManager.getHistoricoDao()
                var historicos = dao.findAll()

                return  historicos
            }

        }


    fun getHistorico (context: Context, id: Long): Historico? {

        if (AndroidUtils.isInternetDisponivel(context)) {
            val url = "$host/historicos/${id}"
            val json = HttpHelper.get(url)
            val historico = parseJson<Historico>(json)

            return historico
        } else {
            val dao = DatabaseManager.getHistoricoDao()
            val historico = dao.getById(id)
            return historico
        }

    }

        fun save(historico: Historico): Response{
            val url = "$host/historicos"
            val json = GsonBuilder().create().toJson(historico)
            val retorno = HttpHelper.post(url,json)

            return  parseJson<Response>(retorno)
        }



    fun saveOffline(historico: Historico) : Boolean {

            val dao = DatabaseManager.getHistoricoDao()

            if (!existeDisciplina(historico)) {
                dao.insert(historico)
            }

        return true

    }


    fun existeDisciplina(historico: Historico): Boolean {
        val dao = DatabaseManager.getHistoricoDao()
        return dao.getById(historico.id) != null

    }
        inline fun <reified T> parseJson(json: String): T {
            val tipo = object : TypeToken<T>(){}.type
            return Gson().fromJson<T>(json,tipo)

        }
    }

