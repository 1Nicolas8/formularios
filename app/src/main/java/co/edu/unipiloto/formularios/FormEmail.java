package co.edu.unipiloto.formularios;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FormEmail extends AppCompatActivity {

    EditText emailTo, emailSubject, emailMessage;
    Button sendButton, secActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_email);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        emailTo = findViewById(R.id.emailTo);
        emailSubject = findViewById(R.id.eSubject);
        emailMessage = findViewById(R.id.eMessage);
        sendButton = findViewById(R.id.sendButton);
        secActivity = findViewById(R.id.secActivity);

        sendButton.setOnClickListener(v -> {
            String to = emailTo.getText().toString();
            String subject = emailSubject.getText().toString();
            String message = emailMessage.getText().toString();

            // Validación para campos vacíos
            if (to.isEmpty() || subject.isEmpty() || message.isEmpty()) {
                Toast.makeText(FormEmail.this, "Porfavor llenar todos los campos", Toast.LENGTH_SHORT).show();
            } else {
                // Simulación de envío de correo
                Toast.makeText(FormEmail.this, "Correo enviado correctamente (simulado)", Toast.LENGTH_LONG).show();
                // Limpiar los campos de texto
                emailTo.setText("");
                emailSubject.setText("");
                emailMessage.setText("");
            }
        });
        secActivity.setOnClickListener(v -> {
            // Navegar a SecondActivity
            Intent intent = new Intent(FormEmail.this, FormProject.class);
            startActivity(intent);
        });
    }
}