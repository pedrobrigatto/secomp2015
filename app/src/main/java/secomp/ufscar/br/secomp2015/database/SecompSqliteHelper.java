package secomp.ufscar.br.secomp2015.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SecompSqliteHelper extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String DB_NAME = "secomp_db";

    private static final String[] DROP_SCRIPTS = {
            "drop table if exists acessos"
    };

    private static final String[] CREATE_SCRIPTS = {
            "create table acessos (id_ integer not null primary key autoincrement, " +
                    "username text not null, horario real not null)"
    };

    public SecompSqliteHelper(Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        for (String script : CREATE_SCRIPTS) {
            db.execSQL(script);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        for (String script : DROP_SCRIPTS) {
            db.execSQL(script);
        }
        onCreate(db);
    }
}
