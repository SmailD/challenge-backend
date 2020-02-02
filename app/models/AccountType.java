package models;

public enum AccountType {

    SAVINGS("savings"),
    CHECKING("checking");

    private final String type;

    AccountType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
