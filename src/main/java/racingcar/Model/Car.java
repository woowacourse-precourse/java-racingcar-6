package racingcar.Model;

public class Car {
    private String carName;
    private int moveCount = 0;

    private String distance = "";

    public Car(String carName) {
        this.carName = carName;
    }

    public String getName(){
        return this.carName;
    }

    public int getMoveCount(){
        return this.moveCount;
    }

    public void accel(){
        this.moveCount += 1;
        this.distance += "-";
    }

    public String getCurrentState(){
        return this.carName + " : " + this.distance;
    }
}
