package model;

public class HardwareProduct extends Product{
    private int warrantyPeriod;

    public HardwareProduct( String name, String description, float pricePerUnit, int warrantyPeriod) {
        super( name, description, pricePerUnit);
        this.warrantyPeriod = warrantyPeriod;
    }

    public int getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public void setWarrantyPeriod(int warrantyPeriod) {
        this.warrantyPeriod = warrantyPeriod;
    }

    @Override
    public float getPrice() {
        return warrantyPeriod+this.getPricePerUnit();
    }
}
