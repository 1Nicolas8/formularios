package co.edu.unipiloto.formularios;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FormProject extends AppCompatActivity {

    EditText projectName, projectDescription, projectLocation, projectBudget, projectPopulation;
    Button submitButton, firstActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_project);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        projectName = findViewById(R.id.projectName);
        projectDescription = findViewById(R.id.projectDescription);
        projectLocation = findViewById(R.id.projectLocation);
        projectBudget = findViewById(R.id.projectBudget);
        projectPopulation = findViewById(R.id.projectPopulation);
        submitButton = findViewById(R.id.submitButton);
        firstActivity = findViewById(R.id.firstActivity);

        submitButton.setOnClickListener(v -> {
            String name = projectName.getText().toString();
            String desc = projectDescription.getText().toString();
            String loc = projectLocation.getText().toString();
            String bud = projectBudget.getText().toString();
            String pop = projectPopulation.getText().toString();

            // Validación para campos vacíos
            if (name.isEmpty() || desc.isEmpty() || loc.isEmpty() || bud.isEmpty() || pop.isEmpty()) {
                Toast.makeText(FormProject.this, "Porfavor llenar todos los campos", Toast.LENGTH_SHORT).show();
            } else {
                // Simulación de envío de correo
                Toast.makeText(FormProject.this, "Correo enviado correctamente (simulado)", Toast.LENGTH_LONG).show();
                // Limpiar los campos de texto
                projectName.setText("");
                projectDescription.setText("");
                projectLocation.setText("");
                projectBudget.setText("");
                projectPopulation.setText("");
            }
        });
        firstActivity.setOnClickListener(v -> {
            // Navegar a SecondActivity
            Intent intent = new Intent(FormProject.this, FormEmail.class);
            startActivity(intent);
        });
    }
}