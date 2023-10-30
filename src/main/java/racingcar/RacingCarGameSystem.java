package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import racingcar.display.RacingCarGameDisplay;
import racingcar.display.graphics.RacingCarDistanceGraphics;
import racingcar.domain.entity.Car;
import racingcar.domain.entity.GameType;
import racingcar.domain.repository.CarRepository;
import racingcar.domain.repository.RacingCarGameRepository;
import racingcar.domain.service.CarService;
import racingcar.domain.service.RacingCarGameService;
import racingcar.domain.service.input.RegisterRacingCarGameInput;

public class RacingCarGameSystem extends GameSystem {

    private final CarService carService = new CarService(new CarRepository());
    private final RacingCarGameService racingCarGameService = new RacingCarGameService(new RacingCarGameRepository());
    private static final int MIN_RANDOM_NUMBER = 1;
    private static final int MAX_RANDOM_NUMBER = 9;

    @Override
    public void run() {
        Long racingGameId = 1L;

        List<Car> cars = registerCars();
        int gameCount = registerGameCount(racingGameId, cars);
        displaySimulateCarRacing(racingGameId, cars, gameCount);
        displayWinners(racingGameId);
    }

    private List<Car> registerCars() {
        RacingCarGameDisplay.printGameStartMessage();
        String carNamesLine = Console.readLine();

        return carService.registerCarsByCarNames(carNamesLine);
    }

    private int registerGameCount(Long racingGameId, List<Car> cars) {
        RacingCarGameDisplay.printGameCountMessage();
        String gameCountLine = Console.readLine();

        RegisterRacingCarGameInput input =
                new RegisterRacingCarGameInput(racingGameId, GameType.RACING_CAR_GAME, gameCountLine, cars);
        racingCarGameService.registerCarsAndGameCounter(input);

        return Integer.parseInt(gameCountLine);
    }

    private void displaySimulateCarRacing(Long racingGameId, List<Car> cars, int gameCount) {
        RacingCarGameDisplay.printGameResultMessage();
        RacingCarDistanceGraphics racingCarDistanceGraphics = new RacingCarDistanceGraphics(cars);
        for (int count = 0; count < gameCount; count++) {
            List<Car> movedCars = moveCars(cars);
            displayCarRacingResult(racingGameId, movedCars, racingCarDistanceGraphics);
        }
    }

    private void displayWinners(Long racingGameId) {
        List<String> winnerNames = racingCarGameService.computeGameWinners(racingGameId);
        RacingCarGameDisplay.printFinalWinnerNames(winnerNames);

        Console.close();
    }

    private List<Car> moveCars(List<Car> cars) {
        List<Car> movedCars = new ArrayList<>();
        for (Car car : cars) {
            int number = Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
            Car movedCar = carService.move(car.getCarName(), number);
            movedCars.add(movedCar);
        }

        return movedCars;
    }

    private void displayCarRacingResult(Long racingGameId, List<Car> movedCars, RacingCarDistanceGraphics graphics) {
        racingCarGameService.computeCarsDistanceAndGameCount(racingGameId, movedCars);
        Map<String, String> carMovementMap = graphics.updateCarGraphicsBasedOnDistance(movedCars);

        RacingCarGameDisplay.printCarMovementResultMessage(carMovementMap);
    }

}
