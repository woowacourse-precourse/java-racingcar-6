package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.RandomNumber;

public class Car {
    //이름, 이동 횟수 저장

    private final String carName;
    private int movedDistance;

    public Car(String carName) {
        this.carName = carName;
        this.movedDistance = 0;
    }

    public String getCarName() {
        return carName;
    }

    public int getMovedDistance() {
        return movedDistance;
    }

    //랜덤 값 생성 기능
    public int generateRandomNumber() {
        return Randoms.pickNumberInRange(RandomNumber.RANDOM_MIN, RandomNumber.RANDOM_MAX);
    }

    //값이 4보다 클 경우를 확인하는 기능
    public boolean isMovable(int number) {
        return number >= RandomNumber.MOVABLE_MIN;
    }

    //이동하는 기능
    public void move() {
        if (isMovable(generateRandomNumber())) {
            movedDistance++;
        }
    }

//    CarDto로 변환하는 로직
}
