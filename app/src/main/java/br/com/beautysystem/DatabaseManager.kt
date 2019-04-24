package br.com.beautysystem

import android.arch.persistence.room.Room
import br.com.beautysystem.HistoricoDao
import br.com.beautysystem.LMSApplication

object DatabaseManager {

    private var dbInstance: LMSDatabase

    init {
        val appContext = LMSApplication.getInstance().applicationContext
        dbInstance = Room.databaseBuilder(appContext, LMSDatabase::class.java, "lms.sqlite").build()
    }

    // PRA CADA DAO QUE EU TIVER EU CRIO UM DESSE
    fun getHistoricoDao(): HistoricoDao{
        return dbInstance.historicoDao()
    }
}