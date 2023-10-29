package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Random;
import racingcar.domain.dto.CarDTO;

public class Car {
    private String name;
    private int distance;
    private static final int MIN_RANDOM_NUM = 0;
    private static final int MAX_RANDOM_NUM = 9;
    private static final int CONDITION_FOR_FORWARD = 4;

    public Car(String name){
        this.name = name;
        this.distance = 0;
    }

    public CarDTO playRound() {
        int randNum = getRandNum();
        move(randNum);
        return CarDTO.from(this);
    }

    public void move(int randNum) {
        if (isMoving(randNum)) {
            addDistance();
        }
    }

    private void addDistance() {
        this.distance += 1;
    }

    private boolean isMoving(int randNum) {
        return randNum >= CONDITION_FOR_FORWARD;
    }

    private int getRandNum(){
        return Randoms.pickNumberInRange(MIN_RANDOM_NUM, MAX_RANDOM_NUM);
    }

    public int getDistance() {
        return this.distance;
    }

    public String getName() {
        return name;
    }
}
