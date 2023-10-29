package racingcar.model;

public class RacingCar {
    private String name;
    private int moveNumber;

    public RacingCar(String name){
        this.name = name;
        moveNumber = 0;
    }

    public void moveRandom(int randomNumber){
        if(randomNumber >= 4) moveNumber++;
    }
}
