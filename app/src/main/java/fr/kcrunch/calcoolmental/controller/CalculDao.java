package fr.kcrunch.calcoolmental.controller;

import android.content.ContentValues;
import android.database.Cursor;

import com.example.td1.model.Calcul;

public class CalculDao extends BaseDao<Calcul>{
    static String clePremierElement = "premierElement";
    static String cleDeuxiemeElement = "deuxiemeElement";
    static String cleSymbol = "symbol";
    static String cleResultat = "resultat";
    public CalculDao(DataBaseHelper helper) {
        super(helper);
    }

    @Override
    protected String getTableName() {
        return "calculs";
    }

    @Override
    protected void putValues(ContentValues values, Calcul entity) {
        values.put(clePremierElement, entity.getPremierElement());
        values.put(cleDeuxiemeElement, entity.getDeuxiemeElement());
        values.put(cleSymbol, entity.getSymbol());
        values.put(cleResultat, entity.getResultat());
    }

    @Override
    protected Calcul getEntity(Cursor cursor) {
        cursor.moveToFirst();
        Integer indexPremierElement = cursor.getColumnIndex(clePremierElement);
        Integer indexDeuxiemeElement = cursor.getColumnIndex(cleDeuxiemeElement);
        Integer indexSymbol = cursor.getColumnIndex(cleSymbol);
        Integer indexResultat = cursor.getColumnIndex(cleResultat);
        Calcul calcul = new Calcul();
        calcul.setPremierElement(cursor.getInt(indexPremierElement));
        calcul.setDeuxiemeElement(cursor.getInt(indexDeuxiemeElement));
        calcul.setSymbol(cursor.getString(indexSymbol));
        calcul.setResultat(cursor.getInt(indexResultat));
        cursor.close();
        return calcul;
    }
}
