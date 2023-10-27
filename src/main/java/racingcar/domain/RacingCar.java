package racingcar.domain;

public class RacingCar {
    private String car;
    private int move;
    private int randomNumber;

    public RacingCar(String car){
        this.car = car;
        this.move = 0;
    }

    public void makeRandomNumber(){
    }

    public void moveForward(){
    }

    public int getMove(){
        return this.move;
    }
}
