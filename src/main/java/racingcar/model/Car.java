package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private final String name;
    private int location;

    public Car(String name) {
        this.name = name;
        this.location = 0;
    }

    public void move() {
        int randomNumber = generateRandomNumber();
        moveOrStop(randomNumber);
    }

    //TODO private으로 변경
    public int generateRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    //TODO private으로 변경
    public void moveOrStop(int randomNumber) {
        if (randomNumber >= 4) {
            location++;
        }
    }

    public String getName() {
        return name;
    }

    //test 만을 위한 코드
    public int getLocation() {
        return location;
    }
}
