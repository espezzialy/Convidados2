package com.espezzialy.convidados.ui.allguests

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.espezzialy.convidados.service.constants.GuestConstants
import com.espezzialy.convidados.service.model.GuestModel
import com.espezzialy.convidados.service.repository.GuestRepository

class AllGuestsViewModel(application: Application) : AndroidViewModel(application) {

    private val mGuestRepository = GuestRepository.getInstance(application.applicationContext)

    private val mGuestList = MutableLiveData<List<GuestModel>>()
    val guestList: LiveData<List<GuestModel>> = mGuestList

    fun load(filter: Int) {

        when (filter) {
            GuestConstants.FILTER.ABSENT -> mGuestList.value = mGuestRepository.getAbsents()
            GuestConstants.FILTER.PRESENT -> mGuestList.value = mGuestRepository.getPresents()
            else -> mGuestList.value = mGuestRepository.getAll()
        }
    }

    fun delete(id: Int) {
        mGuestRepository.delete(id)
    }
}