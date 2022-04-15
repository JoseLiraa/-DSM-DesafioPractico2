package sv.edu.udb.ml161665.farmaciamedica;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class HomeScreen extends AppCompatActivity {
    private Repository mainRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        final AdapterList adapter = new AdapterList(new AdapterList.OrderDiff());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mainRepository = new Repository(this.getApplication());

        mainRepository.getListed().observe(this, medicines -> {
            adapter.submitList(medicines);
        });

        FloatingActionButton neew = findViewById(R.id.btnfloating);
        neew.setOnClickListener(view -> {
            Intent newActivity = new Intent(HomeScreen.this, NewOrder.class);
            startActivity(newActivity);
        });
    }


}