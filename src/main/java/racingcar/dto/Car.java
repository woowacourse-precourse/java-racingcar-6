package racingcar.dto;

public class Car {
    private String name;
    private String separate;

    private String mileage;

    public Car(String name){
        this.name = name;
        this.separate = " : ";
        this.mileage = "";
    }

    public String getName() {
        return name;
    }
    public void setMileage(String mileage) {
        this.mileage += mileage;
    }

    public String getMileage() {
        return mileage;
    }

    @Override
    public String toString() {
        return this.name + this.separate + this.mileage;
    }



}
