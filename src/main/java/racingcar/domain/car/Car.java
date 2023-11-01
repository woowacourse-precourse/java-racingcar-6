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

    // 각 자동차의 무작위 값 조건 검사하기
    public void selectMoveOrStop() {
        if (generateRandomNumber() > ConstantNumber.CAR_IS_STOP.value()){
            move();
        }
    }

    // 무작위 값 생성하기
    public int generateRandomNumber() {
        return Randoms.pickNumberInRange(ConstantNumber.RANDOM_NUMBER_MIN_SIZE.value(),
                ConstantNumber.RANDOM_NUMBER_MAX_SIZE.value());
    }

    // 전진 함수
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
