package fr.kcrunch.calcoolmental;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.td1.view.CalculActivity;
import com.example.td1.view.HistoryActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button boutonCalculer = findViewById(R.id.buttonCalculer);
        boutonCalculer.setOnClickListener(view -> lancerActivtyCalcul());
        Button boutonDernierCalcul = findViewById(R.id.buttonLastCompute);
        boutonDernierCalcul.setOnClickListener(view -> lancerActivtyHistory());
    }

    private void lancerActivtyHistory() {
        Intent intent = new Intent(this, HistoryActivity.class);
        startActivity(intent);
    }

    private void lancerActivtyCalcul() {
        Intent intent = new Intent(this, CalculActivity.class);
        startActivity(intent);
    }
}