package sv.edu.udb.ml161665.farmaciamedica;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class DetailOrder extends AppCompatActivity {
    private TextView tvId, tvClien, tvMedi, tvPric, tvAmou, tvTota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_order);
        tvId=(TextView) findViewById(R.id.orderId);
        tvClien=(TextView) findViewById(R.id.clienteName);
        tvMedi=(TextView) findViewById(R.id.medicineName);
        tvPric=(TextView) findViewById(R.id.price);
        tvAmou=(TextView) findViewById(R.id.amount);
        tvTota=(TextView) findViewById(R.id.total);

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"MedicineDataBase", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        Cursor fila = bd.rawQuery("select MAX(orderId) from orderTable",null);
        tvId.setText(fila.getString(0));
        tvClien.setText(fila.getString(1));
        tvMedi.setText(fila.getString(2));
        tvPric.setText(fila.getString(3));
        tvAmou.setText(fila.getString(4));
        tvTota.setText(fila.getString(5));

    }
}