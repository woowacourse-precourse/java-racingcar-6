package racingcar.domain;

public class RacingCar {
    public final static int defaultValue = 0;
    private String car;
    private int move;
    private int randomNumber;

    public RacingCar(String car){
        this.car = car;
        this.move = defaultValue;
    }

    public void makeRandomNumber(){
    }

    public void moveForward(){
    }

    public int getMove(){
        return this.move;
    }
}
