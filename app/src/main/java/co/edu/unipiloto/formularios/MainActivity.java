package co.edu.unipiloto.formularios;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText emailTo, emailSubject, emailMessage;
    Button sendButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        emailTo = findViewById(R.id.emailTo);
        emailSubject = findViewById(R.id.eSubject);
        emailMessage = findViewById(R.id.eMessage);
        sendButton = findViewById(R.id.sendButton);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String to = emailTo.getText().toString();
                String subject = emailSubject.getText().toString();
                String message = emailMessage.getText().toString();

                // Validación para campos vacíos
                if (to.isEmpty() || subject.isEmpty() || message.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Porfavor llenar todos los campos", Toast.LENGTH_SHORT).show();
                } else {
                    // Simulación de envío de correo
                    Toast.makeText(MainActivity.this, "Correo enviado correctamente (simulado)", Toast.LENGTH_LONG).show();
                    // Limpiar los campos de texto
                    emailTo.setText("");
                    emailSubject.setText("");
                    emailMessage.setText("");
                }
            }
        });
    }
}