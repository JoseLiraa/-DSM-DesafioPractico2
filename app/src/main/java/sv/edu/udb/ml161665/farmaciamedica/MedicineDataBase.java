package sv.edu.udb.ml161665.farmaciamedica;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import  java.util.concurrent.Executors;
import   java.util.concurrent.ExecutorService;

@Database(entities = {Order.class}, version = 1,exportSchema = false)
public abstract class MedicineDataBase  extends RoomDatabase{
    public abstract DAO DAO();

    private static volatile MedicineDataBase BASE;
    private static final int NUMBER_OF_THREADS=4;

    static final ExecutorService executorBase = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static MedicineDataBase getBase(final Context context){
        if(BASE==null){
            synchronized (MedicineDataBase.class){
                if(BASE==null){
                    BASE= Room.databaseBuilder(context.getApplicationContext(),MedicineDataBase.class,"Medicines").addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        } return BASE;
    }
    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);


            executorBase.execute(() -> {

                DAO dao = BASE.DAO();
                dao.deleteAll();
            });
        }
    };
}
