package racingcar.input;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String carName;
    private StringBuilder driving;
    private static final char MOVE_FORMAT = '-';
    private static final int MOVE_CONDITION = 4;
    private static final int START_INCLUSIVE = 0;
    private static final int END_INCLUSIVE = 9;

    public static Car inputCarname(String carName) {
        return new Car(carName);
    }

    private Car(String carName) {
        InputValidator.validateCarname(carName);
        this.carName = carName;
        this.driving = new StringBuilder();
    }

    private Car() {

    }

    public void moveCar() {
        if(isMove()){
            move();
        }
    }

    private boolean isMove(){
        int randomNumber = Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);

        return randomNumber >= MOVE_CONDITION;
    }

    private void move() {
        this.driving.append(MOVE_FORMAT);
    }

    public String getCarName() {
        return this.carName;
    }

    public StringBuilder getDriving() {
        return this.driving;
    }
}
