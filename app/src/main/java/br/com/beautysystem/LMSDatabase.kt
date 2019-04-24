package br.com.beautysystem

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import br.com.beautysystem.Historico
import br.com.beautysystem.HistoricoDao

// aqui é colocado toda clase que eu marquei como @enty e fiz o dao
@Database(entities = arrayOf(Historico::class), version = 1)
abstract class LMSDatabase : RoomDatabase(){

    //CRIAR ISSO PARA CADA DAO
    abstract fun historicoDao(): HistoricoDao

}