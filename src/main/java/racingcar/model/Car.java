package racingcar.model;

public class Car {
    private String carName;
    private int number;
    private StringBuilder distance;

    public Car(){
        distance = new StringBuilder();
    }
    public void setCarName(String carName) {
        this.carName = carName;
    }
    public void setNumber(int number){
        this.number = number;
    }
    public String getCarName() {
        return carName;
    }
    public int getNumber() {
        return number;
    }
    public int getForwardDistance() {
        return distance.length();
    }
    public void forward() {
        this.distance.append("-");
    }
    public String getDistance() {
        return distance.toString();
    }
}
