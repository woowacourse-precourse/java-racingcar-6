package racingcar.domain;

public class MoveNumber {
    private int number;

    public MoveNumber (int number){
        this.number= number;
    }

    public int getNumber() {
        return number;
    }
    public void moveRacingCar() {
        this.number = this.number - 1;
    }

}
