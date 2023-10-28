package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class RaceTrack {

    public String[] carNames;

    public RaceTrack(String[] carNames) {
        this.carNames = carNames;
    }

    // carNames 배열의 각 요소를 줄바꿈하여 출력하는 메서드
    public void printCarNames() {
        for (String carName : carNames) {
            String movement = countMovement();
            System.out.println(carName + " : " + movement);
        }
    }

    // 각 자동차의 전진 여부를 랜덤하게 반환하는 메서드
    private String countMovement() {
        if (moveCar()) {
            return "-";
        }
        return "";
    }

    public static boolean moveCar() {
        int drive = Randoms.pickNumberInRange(0,9);
        if(drive >= 4) {
            return true;
        }
        return false;
    }

}
