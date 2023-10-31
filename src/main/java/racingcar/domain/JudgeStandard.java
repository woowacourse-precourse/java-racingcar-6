package racingcar.domain;

import racingcar.utill.Utill;

public class JudgeStandard {

    public Boolean isVictoryCondition(RaceCar raceCar, Integer numOfCondition) {
        // 자동차중에 전진을 한 숫자가 정해진 조건 숫자와 같으면 승리를 한것이다.
        Integer cntMoveOfRaceCar = raceCar.getCntMovementOfCar();
        return Utill.isSameNum(cntMoveOfRaceCar, numOfCondition);
    }
}
