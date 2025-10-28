package es.iesoretania.ejemplospinnerkotlin

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import es.iesoretania.ejemplospinnerkotlin.databinding.ActivityMainBinding

/**
 * Activity principal que demuestra el uso de un Spinner en Android
 * Implementa OnItemSelectedListener para manejar la selección de elementos
 */
class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    // View Binding para acceder a las vistas del layout de forma segura
    private lateinit var binding: ActivityMainBinding

    // Array con las opciones que se mostrarán en el Spinner
    private val contenido = arrayOf("Primera", "Segunda", "Tercera")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inicializamos el View Binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Creamos el adaptador que conecta los datos con el Spinner
        // android.R.layout.simple_spinner_item es el layout por defecto para cada elemento
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            contenido
        )

        // Establecemos el layout que se usa cuando el Spinner está desplegado
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // Asignamos el adaptador al Spinner
        binding.spinner.adapter = adapter

        // Registramos el listener para detectar cuando se selecciona un elemento
        binding.spinner.onItemSelectedListener = this
    }

    /**
     * Se ejecuta cuando el usuario selecciona un elemento del Spinner
     * @param parent El AdapterView donde ocurrió la selección
     * @param view La vista dentro del AdapterView que fue clickeada
     * @param position La posición del elemento seleccionado en el array (0, 1, 2...)
     * @param id El identificador de fila del elemento seleccionado
     */
    override fun onItemSelected(
        parent: AdapterView<*>?,
        view: View?,
        position: Int,
        id: Long
    ) {
        // Cambiamos el tamaño del texto
        binding.textView.textSize = 24F

        // Mostramos el elemento seleccionado usando su posición en el array
        binding.textView.text = contenido[position]
    }

    /**
     * Se ejecuta cuando no hay ningún elemento seleccionado
     * En la práctica, este método rara vez se llama en un Spinner
     */
    override fun onNothingSelected(parent: AdapterView<*>?) {
        Toast.makeText(
            this,
            "No se ha seleccionado nada",
            Toast.LENGTH_LONG
        ).show()
    }
}