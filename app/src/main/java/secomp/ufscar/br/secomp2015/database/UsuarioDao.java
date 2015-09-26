package secomp.ufscar.br.secomp2015.database;

import android.database.sqlite.SQLiteOpenHelper;

import java.util.List;

/**
 * Created by pedrobrigatto on 9/22/15.
 */
public class UsuarioDao implements Dao {

    private SQLiteOpenHelper helper;

    @Override
    public int save(Object object) {
        return 0;
    }

    @Override
    public List findAll() {
        return null;
    }

    @Override
    public List findBy(Object criteria) {
        return null;
    }

    @Override
    public void setHelper(SQLiteOpenHelper helper) {
        this.helper = helper;
    }
}
