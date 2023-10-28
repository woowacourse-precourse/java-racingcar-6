package racingcar.domain.car;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.constant.ConstantNumber;

public class Car {
    private String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void selectMoveOrStop() {
        if (generateRandomNumber() > 3){
            move();
        }
    }

    public int generateRandomNumber() {
        return Randoms.pickNumberInRange(ConstantNumber.RANDOM_NUMBER_MIN_SIZE.value(),
                ConstantNumber.RANDOM_NUMBER_MAX_SIZE.value());
    }
    public void move(){
        this.position++;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
