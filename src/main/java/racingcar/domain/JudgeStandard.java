package racingcar.domain;

public class JudgeStandard {

    /**
     * 자동차중에 전진을 한 숫작 numOfWinCondition 이면 승리를 한것이다.
     *
     * @param raceCar
     * @param numOfWinCondition
     * @return
     */
    public Boolean isVictoryCondition(RaceCar raceCar, Integer numOfWinCondition) {
        // 자동차중에 전진을 한 숫자가 정해진 조건 숫자와 같으면 승리를 한것이다.
        if (raceCar.getCntMovementOfCar() == numOfWinCondition) {
            return true;
        }
        return false;
    }
}
