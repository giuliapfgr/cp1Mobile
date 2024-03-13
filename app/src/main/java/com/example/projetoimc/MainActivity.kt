import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import com.example.projetoimc.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val alturaEditText = findViewById<EditText>(R.id.Altura)
        val opcFemRadioButton = findViewById<RadioButton>(R.id.opcFem)
        val opcMascRadioButton = findViewById<RadioButton>(R.id.opcMasc)
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)

        btnCalcular.setOnClickListener {
            val alturaStr = alturaEditText.text.toString().toDoubleOrNull()
            val sexo: String = when {
                opcFemRadioButton.isChecked -> "Feminino"
                opcMascRadioButton.isChecked -> "Masculino"
                else -> ""
            }

            fun calcularPesoIdeal(Altura: Double, sexo: String): Double {
                return if (sexo.equals("Masculino", ignoreCase = true)) {
                    (72.7 * Altura) - 58
                } else {
                    (62 * Altura) - 44
                }
            }
        }
    }
}