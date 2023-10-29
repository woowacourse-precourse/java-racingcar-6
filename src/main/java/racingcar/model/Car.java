package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

// 입력한 자동차들 하나하나 전부 어떤 클래스의 인스턴스로 취급할 수 있지 않을까
// 예를 들면, 자동차 이름과 등수만 다르지 다른 건 다 같잖아..?
public class Car {
    // 입력받아 각각 쪼개진 자동차
    private String carName;
    // 그 자동차들 위치(얼마나 나갔니)
    private int position;

    public Car(String carName) {
        this.carName = carName;
        this.position = 0;
    }

    // 나중에 우승자 출력할 때 써먹기
    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }

    // 얼마나 나갔는지 동적으로 업뎃
    private int countMovement() {
        if (moveCar()) {
            return position++;
        }
        return position;
    }

    public boolean moveCar() {
        int drive = Randoms.pickNumberInRange(0,9);
        if (drive >= 4) {
            return true;
        }
        return false;
    }
}
