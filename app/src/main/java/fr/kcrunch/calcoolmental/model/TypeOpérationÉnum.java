package fr.kcrunch.calcoolmental.model;

public enum TypeOpérationÉnum {
    ADD("+"),
    SUBSTRACT("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    public String getSymbol() {
        return symbol;
    }

    private String symbol;

    TypeOpérationÉnum(String symbol) {
        this.symbol = symbol;
    }
}
