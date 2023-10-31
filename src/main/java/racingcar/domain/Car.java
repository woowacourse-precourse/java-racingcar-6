package racingcar.domain;

public class Car {
    private String carName;
    private int randomNumber;
    private int forwardDistance;

    private StringBuilder distance;


    public Car(){
        distance = new StringBuilder();
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public void setRandomNumber(int randomNumber){
        this.randomNumber = randomNumber;
    }

    public String getCarName() {
        return carName;
    }

    public int getRandomNumber() {
        return randomNumber;
    }

    public int getForwardDistance() {
        return distance.length();
    }

    public void setForwardDistance(int forwarDistance) {
        this.forwardDistance = forwarDistance;
    }

    public void setDistance(String distance) {
        this.distance.append(distance);
    }

    public StringBuilder getDistance() {
        return distance;
    }
}
