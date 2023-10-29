package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

// 입력한 자동차들 하나하나 전부 어떤 클래스의 인스턴스로 취급할 수 있지 않을까
// 예를 들면, 자동차 이름과 등수만 다르지 다른 건 다 같잖아..?
public class Car {
    // 입력받아 각각 쪼개진 자동차
    private String carName;
    private int carRank;

    public Car(String carName) {
        // 우승 자동차 출력시킬 때 여기에다가 SubString 써먹기
        this.carName = carName + " : ";
        // 그 자동차들 위치(얼마나 나갔니)
        this.carRank = this.carName.length() - carName.length();
    }

    // 단위 횟수에서 업데이트값 출력 시키기 위한 메소드
    public String getCarName() {
        return carName;
    }

    // 횟수 끝나고 우승 차량 누군지 확인시키기 위한 메소드
    public int getCarRank() {
        return carRank;
    }

    // 얼마나 나갔는지 동적으로 업뎃
    private String printMovement() {
        if (moveCar()) {
            carName = carName + "-";
            return carName;
        }
        return carName;
    }

    public boolean moveCar() {
        int drive = Randoms.pickNumberInRange(0,9);
        if (drive >= 4) {
            return true;
        }
        return false;
    }
}
