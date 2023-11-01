package racingcar.controller;

import racingcar.model.Car;
import racingcar.service.RacingService;

import java.util.List;

public class RacingController {

    private final RacingService racingService = new RacingService();

    // 경주에 참여할 자동차 리스트 생성 메서드
    public List<Car> createCarList(String[] carNames) {
        return racingService.createCarList(carNames);
    }

    // 자동차 경주 라운드 진행 메서드
    public List<Car> playSingleRound(List<Car> cars) {
        return racingService.playSingleRound(cars);
    }

    // 우승자 확인 메서드
    public List<String> readVictoryPlayers(List<Car> cars) {
        return racingService.findByVictoryPlayers(cars);
    }
}
