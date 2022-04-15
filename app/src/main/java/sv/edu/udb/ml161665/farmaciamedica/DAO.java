package sv.edu.udb.ml161665.farmaciamedica;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DAO {

    @Insert
    void insert(Order medicine);

    @Query("SELECT * FROM `orderTable` ORDER BY orderId DESC")
    LiveData<List<Order>> getList();


    @Query("DELETE FROM `orderTable`")
    void deleteAll();
}
