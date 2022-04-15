package sv.edu.udb.ml161665.farmaciamedica;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;


@Entity(tableName = "orderTable")
public class Order {

    @PrimaryKey
    @NotNull
    public String orderId;
    public String clientName;
    public String medicineName;
    public double price;
    public int amount;
    public double total;

    public Order(String orderId, String clientName, String medicineName, double price, int amount, double total){
        this.orderId = orderId;
        this.clientName = clientName;
        this.medicineName = medicineName;
        this.price = price;
        this.amount = amount;
        this.total = total;

    }

    public String[]getOrder(){
        String[] result = {this.orderId, this.clientName, this.medicineName, String.valueOf(this.price), String.valueOf(this.amount), String.valueOf(this.total)};
        return result;

    }

}
