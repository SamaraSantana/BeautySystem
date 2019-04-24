package br.com.beautysystem

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "agenda")
class Historico : Serializable {
    @PrimaryKey
    var id:Long = 0
    var tratamento = ""
    var foto = ""
    var data = ""
	var hora = ""

    override fun toString(): String {
        return "Historicos(tratamento='$tratamento',data='$data', hora='$hora' )"
    }

}