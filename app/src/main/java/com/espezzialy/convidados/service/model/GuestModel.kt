package com.espezzialy.convidados.service.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ColumnInfo

// Entidade no Rooom é o modelo junto com o DataBaseHelper;
@Entity(tableName = "Guest")
class GuestModel{

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0

    @ColumnInfo(name = "name")
    var name: String = ""

    @ColumnInfo(name = "presence")
    var presence: Boolean = true
}