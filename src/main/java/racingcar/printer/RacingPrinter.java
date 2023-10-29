package racingcar.printer;

import racingcar.car.RacingCar;

public interface RacingPrinter {
    void requestInputRacingCarName();

    void requestInputTryCount();

    void noticeResult();

    void printResultDetail(RacingCar racingCar);
}
