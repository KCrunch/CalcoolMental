package fr.kcrunch.calcoolmental.controller;

import com.example.td1.model.Calcul;

public class CalculService {
    private CalculDao calculDao;


    public CalculService(CalculDao calculDao) {
        this.calculDao = calculDao;
    }

    public long getComputeCount(){
        return calculDao.count();
    }

    public void storeInDB(Calcul calcul){
        calculDao.create(calcul);
    }
}
