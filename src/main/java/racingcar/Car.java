package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    //이름, 이동 횟수 저장
    String carName;
    int movedDistance;

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
        return Randoms.pickNumberInRange(0,9);
    }

    //값이 4보다 클 경우 이동 횟수를 +1하는 기능
    public boolean isMoving() {
        int randomNumber = generateRandomNumber();
        if (randomNumber >= 4) {
            movedDistance++;
            return true;
        }
        return false;
    }

}
