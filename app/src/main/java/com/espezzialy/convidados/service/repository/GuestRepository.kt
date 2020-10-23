package com.espezzialy.convidados.service.repository

import android.content.Context
import com.espezzialy.convidados.service.model.GuestModel

class GuestRepository(context: Context) {

    private val mDataBase = GuestDataBase.getDataBase(context).guestDAO()

    fun get(id: Int): GuestModel{
        return mDataBase.get(id)
    }

    fun getAll(): List<GuestModel>{
        return mDataBase.getInvited()
    }

    fun getPresents(): List<GuestModel>{
        return mDataBase.getPresent()
    }

    fun getAbsents(): List<GuestModel>{
        return mDataBase.getAbsent()
    }

    fun save(guest: GuestModel): Boolean {
        return mDataBase.save(guest) > 0
    }

    fun update(guest: GuestModel): Boolean{
        return mDataBase.update(guest) > 0
    }

    fun delete(guest: GuestModel){
        return mDataBase.delete(guest)
    }
}