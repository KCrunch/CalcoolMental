package fr.kcrunch.calcoolmental.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.td1.R;
import com.example.td1.controller.CalculBaseHelper;
import com.example.td1.controller.CalculDao;
import com.example.td1.controller.CalculService;
import com.example.td1.model.TypeOpérationÉnum;
import com.example.td1.model.exception.DivideException;

public class CalculActivity extends AppCompatActivity {
    Integer premierElement = 0;
    Integer deuxiemeElement = 0;
    TypeOpérationÉnum typeOperation = null;
    TextView textViewCalcul;
    Integer BORNE_HAUTE = 9999;
    private CalculService calculService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcul);
        calculService = new CalculService(new CalculDao(new CalculBaseHelper(this)));
        textViewCalcul = findViewById(R.id.textViewCalcul);
        Button bouton1 = findViewById(R.id.button_1);
        bouton1.setOnClickListener(view -> ajouterNombre(1));
        Button bouton2 = findViewById(R.id.button_2);
        bouton2.setOnClickListener(view -> ajouterNombre(2));
        Button bouton3 = findViewById(R.id.button_3);
        bouton3.setOnClickListener(view -> ajouterNombre(3));
        Button bouton4 = findViewById(R.id.button_4);
        bouton4.setOnClickListener(view -> ajouterNombre(4));
        Button bouton5 = findViewById(R.id.button_5);
        bouton5.setOnClickListener(view -> ajouterNombre(5));
        Button bouton6 = findViewById(R.id.button_6);
        bouton6.setOnClickListener(view -> ajouterNombre(6));
        Button bouton7 = findViewById(R.id.button_7);
        bouton7.setOnClickListener(view -> ajouterNombre(7));
        Button bouton8 = findViewById(R.id.button_8);
        bouton8.setOnClickListener(view -> ajouterNombre(8));
        Button bouton9 = findViewById(R.id.button_9);
        bouton9.setOnClickListener(view -> ajouterNombre(9));
        Button bouton0 = findViewById(R.id.button_0);
        bouton0.setOnClickListener(view -> ajouterNombre(0));
        Button boutonAddition = findViewById(R.id.button_addition);
        boutonAddition.setOnClickListener(view -> ajouterSymbol(TypeOpérationÉnum.ADD));
        Button boutonMultiplication = findViewById(R.id.button_multiplication);
        boutonMultiplication.setOnClickListener(view -> ajouterSymbol(TypeOpérationÉnum.MULTIPLY));
        Button boutonDivision = findViewById(R.id.button_division);
        boutonDivision.setOnClickListener(view -> ajouterSymbol(TypeOpérationÉnum.DIVIDE));
        Button boutonSoustraction = findViewById(R.id.button_substraction);
        boutonSoustraction.setOnClickListener(view -> ajouterSymbol(TypeOpérationÉnum.SUBSTRACT));
    }

    private void ajouterSymbol(TypeOpérationÉnum typeOpération) {
        this.typeOperation = typeOpération;
        majText();
    }

    public void ajouterNombre(Integer valeur){
        if(typeOperation == null){
            if(10*premierElement + valeur > BORNE_HAUTE){ Toast.makeText(this, getString(R.string.ERROR_VALEUR_TROP_GRANDE), Toast.LENGTH_LONG).show(); }
            else { premierElement = 10 * premierElement + valeur; }
        }else{
            if(10*deuxiemeElement + valeur > BORNE_HAUTE){ Toast.makeText(this, getString(R.string.ERROR_VALEUR_TROP_GRANDE), Toast.LENGTH_LONG).show(); }
            else { deuxiemeElement = 10*deuxiemeElement + valeur; }
        }
        majText();
    }

    public void majText(){
        String textAfficher="";
        if(typeOperation == null){
            textAfficher = premierElement.toString();
        }else {
            textAfficher = premierElement + " " + typeOperation.getSymbol() + " " + deuxiemeElement;
        }
        textViewCalcul.setText(textAfficher);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar,menu);
        MenuItem boutonCalculer = menu.findItem(R.id.toolbarCalculer);
        boutonCalculer.setOnMenuItemClickListener(MenuItem -> ouvrirDernierCalcul());
        MenuItem boutonClean = menu.findItem(R.id.toolbarClean);
        boutonClean.setOnMenuItemClickListener(MenuItem -> nettoyerCalculs());
        return true;
    }

    private boolean nettoyerCalculs() {
        TextView textViewCalcul = findViewById(R.id.textViewCalcul);
        textViewCalcul.setText("");
        premierElement = 0;
        deuxiemeElement = 0;
        typeOperation = null;
        return true;
    }

    private Integer faisLeCalcul()throws DivideException {
        try {
            switch (typeOperation){
                case ADD:
                    return premierElement + deuxiemeElement;
                case SUBSTRACT:
                    return premierElement - deuxiemeElement;
                case DIVIDE:
                    if(deuxiemeElement!=0)
                        return premierElement / deuxiemeElement;
                    else
                        throw new DivideException();
                case MULTIPLY:
                    return premierElement * deuxiemeElement;
            }
            return 0;
        } catch (DivideException e){
            Toast.makeText(this, getString(R.string.ERROR_DIVISION_ZERO), Toast.LENGTH_LONG).show();
        }
        return 0;
    }

    private boolean ouvrirDernierCalcul() {
        try {
            Intent intent = new Intent(this, HistoryActivity.class);
            intent.putExtra("premierElement", premierElement);
            intent.putExtra("deuxiemeElement",deuxiemeElement);
            intent.putExtra("symbol",typeOperation.getSymbol());
            intent.putExtra("resultat",faisLeCalcul());
            startActivity(intent);
        } catch (DivideException e){
            Toast.makeText(this, getString(R.string.ERROR_DIVISION_ZERO), Toast.LENGTH_SHORT).show();
        }

        return true;
    }
}