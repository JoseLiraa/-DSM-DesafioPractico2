package sv.edu.udb.ml161665.farmaciamedica;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ItemRecyclerView extends RecyclerView.ViewHolder {

    private TextView orderId;
    private TextView clienteName;
    private TextView medicineName;
    private TextView price;
    private TextView amount;
    private TextView total;

    private ItemRecyclerView(View view){
        super(view);
        orderId=view.findViewById(R.id.orderId);
        clienteName=view.findViewById(R.id.clienteName);
        medicineName=view.findViewById(R.id.medicineName);
        price=view.findViewById(R.id.price);
        amount=view.findViewById(R.id.amount);
        total=view.findViewById(R.id.total);
    }
    public void fill(String[] datos){
        orderId.setText("Id compra: "+datos[0]);
        clienteName.setText("Cliente: "+datos[1]);
        medicineName.setText("Medicamento: "+datos[2]);
        price.setText("Precio: $"+datos[3]);
        amount.setText("Cantidad: "+datos[4]);
        total.setText("Total: $"+datos[5]);
    }

    static  ItemRecyclerView create(ViewGroup padre){
        View view = LayoutInflater.from(padre.getContext()).inflate(R.layout.item_recyclerview,padre,false);
        return new ItemRecyclerView(view);
    }
}