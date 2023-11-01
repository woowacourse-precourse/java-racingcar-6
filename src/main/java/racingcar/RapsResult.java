package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import pojo.RacingCar;

public class RapsResult {

    RacingCar racingCar;

    public RapsResult(RacingCar racingCar) {

        this.racingCar = racingCar;
    }

    //주어진 숫자가 4 이상일 경우 true를 반환합니다.
    public boolean reader(int num) {

        if (num >= 4) {
            return true;
        }

        return false;
    }

    //전진 여부를 결정하고, 자동차의 위치를 1 증가시킵니다.
    public void changeCarStatus(boolean flag) {

        if (flag) {
            racingCar.distanceFoward();
        }
    }

    //자동차의 최종 이동 거리 및 이름을 문자열 형태로 반환합니다.
    public String resultText() {

        return racingCar.getName() + " : " + distanceText();
    }

    //자동차의 이동 거리를 '-' 문자열로 표현하여 반환합니다.
    public String distanceText() {

        StringBuilder text = new StringBuilder();

        for (int i = 0; i < racingCar.getDistance(); i++) {
            text.append("-");
        }

        return text.toString();
    }

    //랜덤값을 생성합니다.
    public int generateNumber() {

        int num = Randoms.pickNumberInRange(0, 9);

        return num;
    }

    //랜덤값을 생성하여 전진할지 멈출지 결정하고, 경기 1회 끝난 후 결과를 반환합니다.
    public String raceResult() {

        int num = generateNumber();
        boolean forward = reader(num);
        changeCarStatus(forward);

        return resultText();
    }

}
