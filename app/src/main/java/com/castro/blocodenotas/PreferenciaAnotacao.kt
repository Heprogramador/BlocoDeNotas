package com.castro.blocodenotas

import android.content.Context
import android.content.SharedPreferences
import android.os.Parcel
import android.os.Parcelable
import androidx.lifecycle.viewmodel.viewModelFactory


class PreferenciaAnotacao(private val context: Context)  {

    private val ARQUIVO = "anotacao.preferencia"
    private val CHAVE = "nome"
    private val preferences: SharedPreferences
    private  val editor: SharedPreferences.Editor

    fun SalvarAnotacao(anotacao: String?){
        editor.putString(CHAVE,anotacao)
        editor.commit()
    }

        fun RecuperarAnotacao(): String? {
            return preferences.getString(CHAVE,"")
        }


      init {
          preferences = context.getSharedPreferences(ARQUIVO,0)
          editor = preferences.edit()
      }
}

