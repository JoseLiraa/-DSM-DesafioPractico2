package sv.edu.udb.ml161665.farmaciamedica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NewOrder extends AppCompatActivity {

    public EditText OrderIdET,ClientNameET,MedicineET,AmountET;
    private Repository rep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_order);

        OrderIdET=findViewById(R.id.IdOrderET);
        ClientNameET=findViewById(R.id.ClientNameET);
        MedicineET=findViewById(R.id.MedicineET);
        AmountET=findViewById(R.id.amountET);


    final Button SaveBtn=findViewById(R.id.SaveBtn);
        SaveBtn.setOnClickListener(view -> {
        Intent principal = new Intent();
        if(TextUtils.isEmpty(OrderIdET.getText())){
            Toast.makeText(this, "El campo Id Pedido es requeridos", Toast.LENGTH_SHORT).show();
        }else {
            int IntAmount = Integer.parseInt(AmountET.getText().toString());
            Double DoublePrice = 28.54;
            Double Total;
            Total = IntAmount * DoublePrice;

            Intent atras = new Intent(this, DetailOrder.class);
            rep = new Repository(this.getApplication());
            Order order = new Order(OrderIdET.getText().toString(), ClientNameET.getText().toString(), MedicineET.getText().toString(), DoublePrice, IntAmount, Total);
            rep.insert(order);

            startActivity(atras);
        }
    });
}
}