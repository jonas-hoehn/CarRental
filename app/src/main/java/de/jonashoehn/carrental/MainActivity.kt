package de.jonashoehn.carrental

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.zxing.integration.android.IntentIntegrator
import de.jonashoehn.carrental.databinding.ActivityMainBinding
import de.jonashoehn.carrental.model.LKW
import de.jonashoehn.carrental.model.PKW
import de.jonashoehn.carrental.model.Vehicle

class MainActivity : AppCompatActivity() {

    private lateinit var mQrResultLauncher: ActivityResultLauncher<Intent>
    private lateinit var binding: ActivityMainBinding

    private val listOfVehicles: MutableList<Vehicle> = mutableListOf() //sealed und mutablelist (--> abstract class in c++)

    override fun onCreate(savedInstanceState: Bundle?) {
        initCars()
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Alternative to "onActivityResult", because that is "deprecated"
        mQrResultLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                if (it.resultCode == Activity.RESULT_OK) {
                    val result = IntentIntegrator.parseActivityResult(it.resultCode, it.data)

                    val carId = result.contents
                    if (carId != null) {
                        val textField = findViewById<EditText>(R.id.carIdInput)
                        textField.setText(carId)
                        for (car in listOfVehicles) {
                            if (car.id == carId) {
                                findViewById<TextView>(R.id.carBrand).setText(car.brand)
                                findViewById<TextView>(R.id.carModel).setText(car.model)

                            }
                        }

                    }
                }
            }

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_rent, R.id.navigation_return, R.id.navigation_addcar
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    fun onClickScanCarId(view: android.view.View) {
        startScanner() // Starts scanner on Create of Overlay (you can also call this function using a button click)

    }

    private fun startScanner() {
        val scanner = IntentIntegrator(this)
        // QR Code Format
        scanner.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE)
        // Set Text Prompt at Bottom of QR code Scanner Activity
        scanner.setPrompt("QR Code Scanner Prompt Text")
        // Start Scanner (don't use initiateScan() unless if you want to use OnActivityResult)
        mQrResultLauncher.launch(scanner.createScanIntent())
    }


    private fun initCars() {
        for (vehicle in listOfVehicles) {

            //listOfVehicles.add(Vehicle("43902936", "BMW", "x3er", 123, "MTK-JP-144", 4, "grau", 100, "Auto", "In Shop"))
            //listOfVehicles.add(Vehicle("02830283", "Audi", "e-Tron"))
            //listOfVehicles.add(Vehicle("9220375", "Ford", "s-Max"))
            //listOfVehicles.add(Vehicle("114253698", "Landrover", "discovery"))
            //listOfVehicles.add(Vehicle("90083726", "Porsche", "Carrera"))
            //listOfVehicles.add(Vehicle("2134567654321", "Lambooo", "Sesssssto Elemontooooooo"))
            PKW("123", "Audi", "etron", 4, "MTK-JP-144", 4, "grau", 2000,  4)

        }


    }

    private fun createVehicle(){

        val autoBmw = Vehicle("111", "Audi", "etron", 768854, "Mtk Jp 144", 4, "Grau", 3)
        //val lkwEins = LKW("111", "BMW", "1er Cabrio",4)



    }

    private fun printVehicle(v:Vehicle) {
        when (v) {
            is LKW -> print("is just a LKW of ${v.model}")
            is PKW -> print("is a car of ${v.model} with ${v.doors}")
        }
    }




}