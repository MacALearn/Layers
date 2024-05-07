package model;

public class SoftwareProduct extends Product {
    private int NumberOfUsers;

    public SoftwareProduct( String name, String description, float pricePerUnit, int numberOfUsers) {
        super( name, description, pricePerUnit);
        NumberOfUsers = numberOfUsers;
    }

    public int getNumberOfUsers() {
        return NumberOfUsers;
    }

    public void setNumberOfUsers(int numberOfUsers) {
        NumberOfUsers = numberOfUsers;
    }


    @Override
    public float getPrice() {
        return this.getPricePerUnit()+NumberOfUsers;
    }
}
