package racingcar.domain;

import java.util.List;

public class Game {
    private final int trial;
    private final List<Car> cars;
    private int trialNumber = 0;
    //자동차들의 배열과 시행 해야 할 시행 횟수
    public Game(List<Car> cars, int trial) {
        this.cars = cars;
        this.trial = trial;
    }
    //자동차들의 배열 호출
    public List<Car> getCars() {
        return cars;
    }
    //동작한 시행 횟수 카운트
    public void increaseTrialNumber() {
        this.trialNumber += 1;
    }
    //카운트된 시행 횟수가 입력된 시행 횟수와 같은 지 체크
    public boolean checkReach_TrialNumber() {
        return this.trial == this.trialNumber;
    }
}