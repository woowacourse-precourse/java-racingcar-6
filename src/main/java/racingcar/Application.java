package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.CarDto;
import racingcar.domain.CarManufacturer;
import racingcar.domain.Judgement;
import racingcar.domain.Winner;
import racingcar.input.InputManager;
import racingcar.output.OutputManager;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        final OutputManager om = new OutputManager();
        final InputManager im = new InputManager();
        final CarManufacturer carManufacturer = new CarManufacturer();
        final Judgement judgement = new Judgement();

        List<Car> cars = createCars(om, im, carManufacturer);
        int attemptCount = createAttemptCount(om, im);

        startRacingDuringAttemptCount(cars, attemptCount, om);
        List<Winner> winners = judgement.judgeGameResult(cars);
        om.printGameResult(winners);

    }

    private static int pickRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    private static void startRacingDuringAttemptCount(final List<Car> cars,
                                                      final int attemptCount,
                                                      final OutputManager om) {
        om.printTitleOfGameResult();
        for (int i = 0; i < attemptCount; i++) {
            startRacing(cars);
            om.printResultOfTrial(cars.stream()
                    .map(car -> new CarDto(car.getName(),
                            car.getForwardCount()))
                    .toList());
        }
    }

    private static void startRacing(List<Car> cars) {
        for (Car car : cars) {
            car.forward(pickRandomNumber());
        }
    }

    private static int createAttemptCount(final OutputManager om, final InputManager im) {
        om.printNumberOfAttempts();
        return im.inputAttemptCount();
    }

    private static List<Car> createCars(final OutputManager om, final InputManager im,
                                        CarManufacturer carManufacturer) {
        om.printStartGame();
        return carManufacturer.createCars(im.inputCarNames());
    }
}
