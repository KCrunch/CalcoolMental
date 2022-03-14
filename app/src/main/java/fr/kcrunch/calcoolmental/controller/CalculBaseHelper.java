package fr.kcrunch.calcoolmental.controller;

import android.content.Context;

public class CalculBaseHelper extends DataBaseHelper {

    public CalculBaseHelper(Context context) {
        super(context, "historique", 1);
    }

    @Override
    protected String getCreationSql() {
        return "CREATE TABLE IF NOT EXISTS calculs (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                CalculDao.clePremierElement + " INTEGER NOT NULL," +
                CalculDao.cleDeuxiemeElement + " INTEGER NOT NULL," +
                CalculDao.cleSymbol + " VARCHAR(255) NOT NULL," +
                CalculDao.cleResultat + " INTEGER NOT NULL" +
                ")";
    }

    @Override
    protected String getDeleteSql() {
        return null;
    }
}
