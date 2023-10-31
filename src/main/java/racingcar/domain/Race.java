package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Race {
    /**
     * Race (Domain, 실제로 경주를 진행하는 객체) 경주에 참여하는 자동차들의 목록을 설정하는 기능 (InputView) 라운드 별 자동차의 전진/멈춤을 결정하는 기능 (Car) 라운드 별 경기
     * 결과를 저장하고 반환하는 기능 (RaceResult)종료 조건을 확인하는 기능 (라운드 수)
     */
    private final List<Car> cars;
    private final int round;
    private int currentRound;

    public Race(List<String> carNames, int round) {
        this.cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
        this.round = round;
        this.currentRound = 0;
    }

    public void proceedRound() {
        cars.forEach(Car::move);
        currentRound++;
    }

    public RaceResult getCurrentResult() {
        return new RaceResult(cars);
    }

    public boolean isRaceFinished() {
        return currentRound == rounds;
    }
}
