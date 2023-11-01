package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import racingcar.repository.CarAdmin;

public class Game {
    private static final int START_NUMBER = 0;
    private static final int END_NUMBER = 9;
    private static final int LIMIT_MOVE_MIN = 4;
    private final CarAdmin carAdmin = new CarAdmin();


    //자동차 이동
    public void movePosition(){ //자동차별 이동 메서드
        for (Car car : carAdmin.getCars()) {
            checkLimitMin(car);
        }
    }
    private void checkLimitMin(Car car){ //조건 체크
        if(getRandomNumber() >= LIMIT_MOVE_MIN){
            car.addDistance(1);
        }
    }
    private int getRandomNumber(){ //랜덤 숫자
        return Randoms.pickNumberInRange(START_NUMBER, END_NUMBER);
    }
}
