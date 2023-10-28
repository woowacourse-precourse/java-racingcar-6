package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Random;
import racingcar.domain.dto.CarDTO;

public class Car {
    private final String name;
    private int distance;

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
        int num = Randoms.pickNumberInRange(0,9);
        return num >= 4;
    }

    public int getDistance() {
        return this.distance;
    }

    public String getName() {
        return name;
    }
}
