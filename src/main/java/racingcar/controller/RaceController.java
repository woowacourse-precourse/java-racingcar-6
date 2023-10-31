package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.service.RaceService;

import java.io.InputStream;

public class RaceController {
    public void run(InputStream inputStream) {
        RaceService raceService = new RaceService(inputStream);
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        Cars cars = raceService.inputCars();

        System.out.println("시도할 회수는 몇회인가요?");
        int cnt = raceService.inputCnt();

        raceService.raceStart(cars, cnt);

        raceService.showWinners(cars);
    }
}
