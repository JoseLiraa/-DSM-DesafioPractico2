package sv.edu.udb.ml161665.farmaciamedica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Menu extends AppCompatActivity {

    ListView listData;
    ArrayList<Data> List;
    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        listData = (ListView) findViewById(R.id.lsData);
        List = new ArrayList<Data>();

        List.add(new Data(1, "Aspirina", "x1 $0.13", R.drawable.aspirina));
        List.add(new Data(2, "Paracetamol", "x1 $0.28", R.drawable.paracetamol));
        List.add(new Data(3, "Amoxicilina", "x1 $0.29", R.drawable.amoxicilina));
        List.add(new Data(4, "Lansoprazol", "x1 $0.40", R.drawable.lansoprazol));
        List.add(new Data(5, "Simvastatina", "x10 $7.99", R.drawable.simvastatina));
        List.add(new Data(6, "Omeprazol", "x1 $0.75", R.drawable.omeprazol));
        List.add(new Data(7, "Ramipril", "x30 $23.20", R.drawable.ramipril));
        List.add(new Data(8, "Salbutamol", "x200 Dosis $5.50", R.drawable.salbutamol));
        List.add(new Data(9, "Abrilar Jarabe", "$19.35", R.drawable.abrilar));
        List.add(new Data(10, "Cerebrofos", "$9.09", R.drawable.cerebrofos));
        List.add(new Data(11, "Fosfo B12", "$7.61", R.drawable.fosfo));

        Adapter mineadapter = new Adapter(getApplicationContext(),List);

        listData.setAdapter(mineadapter);



        FloatingActionButton next = findViewById(R.id.btn);
        next.setOnClickListener(view -> {
            Intent newActivity = new Intent(Menu.this, NewOrder.class);
            startActivity(newActivity);
        });


    }
}