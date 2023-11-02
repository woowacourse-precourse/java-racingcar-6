package racingcar.domain;

import racingcar.utill.Utill;

public class JudgeStandard {

    public Boolean isVictory(RaceCar raceCar, Integer numOfCondition) {
        Integer cntMoveOfRaceCar = raceCar.getCntMovement();

        return Utill.isSameNum(cntMoveOfRaceCar, numOfCondition);
    }
}
