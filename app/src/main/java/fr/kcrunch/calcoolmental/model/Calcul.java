package fr.kcrunch.calcoolmental.model;

public class Calcul extends BaseEntity{
    Integer premierElement;
    Integer deuxiemeElement;
    String symbol;
    Integer resultat;

    public Integer getPremierElement() {
        return premierElement;
    }

    public Integer getDeuxiemeElement() {
        return deuxiemeElement;
    }

    public String getSymbol() {
        return symbol;
    }

    public Integer getResultat() {
        return resultat;
    }

    public void setPremierElement(Integer premierElement) {
        this.premierElement = premierElement;
    }

    public void setDeuxiemeElement(Integer deuxiemeElement) {
        this.deuxiemeElement = deuxiemeElement;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setResultat(Integer resultat) {
        this.resultat = resultat;
    }
}
