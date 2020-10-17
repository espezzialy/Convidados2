package com.espezzialy.convidados.service.repository

import android.content.ContentValues
import android.content.Context
import com.espezzialy.convidados.GuestDataBaseHelper
import com.espezzialy.convidados.service.constants.DataBaseConstants
import com.espezzialy.convidados.service.model.GuestModel
import java.lang.Exception

class GuestRepository private constructor(context: Context) {

    private var mGuestDataBaseHelper: GuestDataBaseHelper = GuestDataBaseHelper(context)

    companion object {
        private lateinit var repository: GuestRepository

        fun getInstance(context: Context): GuestRepository {
            if(!::repository.isInitialized) {
                repository = GuestRepository(context)
            }
            return repository
        }
    }

    fun getAll(): List<GuestModel>{
        val list: MutableList<GuestModel> = ArrayList()
        return list
    }


    fun getPresents(): List<GuestModel>{
        val list: MutableList<GuestModel> = ArrayList()
        return list
    }


    fun getAbsents(): List<GuestModel>{
        val list: MutableList<GuestModel> = ArrayList()
        return list
    }


    //CRUD - Create, Read, Update, Delete



    //Singleton - Apenas uma instância da classe
    fun save(guest: GuestModel): Boolean {
        return try{
        val db = mGuestDataBaseHelper.writableDatabase

        val contentValues = ContentValues()

        contentValues.put(DataBaseConstants.GUEST.COLUMNS.NAME, guest.name)
        contentValues.put(DataBaseConstants.GUEST.COLUMNS.PRESENCE, guest.presence)

        db.insert(DataBaseConstants.GUEST.TABLE_NAME, null, contentValues)
        true
        }
        catch (e: Exception){
            false
        }
    }

    fun update(guest: GuestModel): Boolean{
        return try{
            val db = mGuestDataBaseHelper.writableDatabase

            val contentValues = ContentValues()

            contentValues.put(DataBaseConstants.GUEST.COLUMNS.NAME, guest.name)
            contentValues.put(DataBaseConstants.GUEST.COLUMNS.PRESENCE, guest.presence)

            val selection = DataBaseConstants.GUEST.COLUMNS.ID + " = ?"
            val args = arrayOf(guest.id.toString())

            db.update(DataBaseConstants.GUEST.TABLE_NAME, contentValues, selection, args)
            true
        }
        catch (e: Exception){
            false
        }
    }

    fun delete(id: Int): Boolean{
        return try{
            val db = mGuestDataBaseHelper.writableDatabase
            val selection = DataBaseConstants.GUEST.COLUMNS.ID + " = ?"
            val args = arrayOf(id.toString())

            db.delete(DataBaseConstants.GUEST.TABLE_NAME,selection, args)
            true
        }
        catch (e: Exception){
            false
        }

    }
}