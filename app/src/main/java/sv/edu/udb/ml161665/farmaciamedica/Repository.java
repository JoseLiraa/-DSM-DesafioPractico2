package sv.edu.udb.ml161665.farmaciamedica;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class Repository {

    private DAO repoDAO;
    public LiveData<List<Order>> allMedicines;
    Repository(Application application) {
        MedicineDataBase db = MedicineDataBase.getBase(application);
        repoDAO = db.DAO();
        allMedicines = repoDAO.getList();
    }

    void insert(Order order){
        MedicineDataBase.executorBase.execute(()->{
            repoDAO.insert(order);
        });
    }
    LiveData<List<Order>> getListed() {
        return allMedicines;
    }
}
