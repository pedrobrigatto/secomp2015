package secomp.ufscar.br.secomp2015.database;

import android.database.sqlite.SQLiteOpenHelper;

import java.util.List;

/**
 * Created by pedrobrigatto on 9/22/15.
 */
public interface Dao<T> {

    int save (T object);

    List<T> findAll();

    List<T> findBy(Object criteria);

    void setHelper(SQLiteOpenHelper helper);
}
