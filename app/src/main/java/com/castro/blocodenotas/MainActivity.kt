package com.castro.blocodenotas

import android.os.Bundle
import android.view.LayoutInflater
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.castro.blocodenotas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val preferencia = PreferenciaAnotacao(applicationContext)
        val botaoSalvar = binding.fab

        botaoSalvar.setOnClickListener {
            val anotacaoRecuperado = binding.editContainer.editAnotacao.text.toString()

            if (anotacaoRecuperado == "") {
                Toast.makeText(this, "Digite albuma coisa", Toast.LENGTH_SHORT).show()
            } else {
                preferencia.SalvarAnotacao(anotacaoRecuperado)
                Toast.makeText(this, "Anotacao salva com sucesso", Toast.LENGTH_SHORT).show()
            }

        }

        val anotacao = preferencia.RecuperarAnotacao()
        if(anotacao != "") {
            binding.editContainer.editAnotacao.setText(anotacao)
        }
    }
}