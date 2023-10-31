package racingcar.printer;

import racingcar.car.RacingCar;

import java.util.List;

public interface RacingPrinter {
    void requestInputRacingCarName();

    void requestInputTryCount();

    void noticeResult();

    void printResultDetail(RacingCar racingCar);

    void printLine();

    void noticeWinner(List<String> racingCars);
}
