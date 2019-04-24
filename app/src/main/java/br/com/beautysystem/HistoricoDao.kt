package br.com.beautysystem

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

@Dao
interface HistoricoDao {

    @Query("SELECT * FROM agenda where id= :id")
    fun getById(id: Long): Historico?

    @Query("SELECT * FROM agenda")
    fun findAll(): List<Historico>

    @Insert
    fun insert(historico: Historico)

    @Delete
    fun delete(historico :Historico)

}