package racingcar.controller;

import racingcar.domain.RacingCar;
import racingcar.service.RacingCarService;

import java.util.List;

public class RacingCarController {
    private final RacingCarService racingCarService;
    public RacingCarController(RacingCarService racingCarService) { this.racingCarService = racingCarService; }

    public void start() {
        // 1. 자동차 이름 입력받기 (5개 이하)
        // 2. 입력받은 개수의 자동차 생성, 이름 부여
        List<RacingCar> cars = racingCarService.makeCars();

        // 3. 시도할 회수 입력받기
        int raceCount = racingCarService.getRaceCount();

        // 4. 입력받은 회수만큼 시도
        // 4-1. 자동차별 회수만큼 전진 (0~9)
        // 4-2. 전진 상황 출력 (-)로 표시
        List<RacingCar> racedCars = racingCarService.racingGame(cars, raceCount);

        // 5. 우승자 출력 (여러 명일 경우 쉼표로 구분)
        racingCarService.calculateRacingWinner(racedCars);
    }
}
