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
        if(isMoving()){
            move();
        }
        return CarDTO.from(this);
    }

    private void move() {
        this.distance += 1;
    }

    private boolean isMoving() {
        int num = Randoms.pickNumberInRange(MIN_RANDOM_NUM, MAX_RANDOM_NUM);
        return num >= CONDITION_FOR_FORWARD;
    }

    public int getDistance() {
        return this.distance;
    }

    public String getName() {
        return name;
    }
}
