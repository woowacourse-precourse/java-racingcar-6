package racingcar;

import racingcar.controller.RacingController;
import racingcar.domain.Car;
import racingcar.service.InputService;
import racingcar.service.RacingReferee;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Application.run();
    }

    public static void run(){
        RacingReferee referee = set();
        RacingController racingController = new RacingController(referee);

        racingController.play();
        racingController.end();
    }

    public static RacingReferee set(){
        ArrayList<Car> cars = InputService.requestRacingCars();
        Integer racingRound = InputService.requestRacingRound();

        return new RacingReferee(cars, racingRound);
    }
}
