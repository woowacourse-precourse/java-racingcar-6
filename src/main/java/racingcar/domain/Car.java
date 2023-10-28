package racingcar.domain;

public class Car {


    private String name;
    private int moveCount;

    private final String distance;

    public String getDistance() {
        return distance;
    }

    public Car(String carNames) {
        this.name=carNames;
        this.moveCount =0;
        this.distance="";
    }

    public String getName() {
        return name;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public int move(){
        return this.moveCount++;
    }


}
