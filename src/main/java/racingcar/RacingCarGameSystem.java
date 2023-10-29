package racingcar;

import static java.lang.Integer.parseInt;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import racingcar.display.RacingCarGameDisplay;
import racingcar.domain.entity.Car;
import racingcar.domain.entity.GameType;
import racingcar.domain.repository.CarRepository;
import racingcar.domain.repository.RacingCarGameRepository;
import racingcar.domain.service.CarService;
import racingcar.domain.service.RacingCarGameService;
import racingcar.graphics.RacingCarDistanceGraphics;
import racingcar.input.RegisterRacingCarGameInput;

public class RacingCarGameSystem extends GameSystem {

    private final CarRepository carRepository = new CarRepository();
    private final RacingCarGameRepository racingCarGameRepository = new RacingCarGameRepository();
    private final CarService carService = new CarService(carRepository);
    private final RacingCarGameService racingCarGameService = new RacingCarGameService(racingCarGameRepository);
    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 9;

    @Override
    public void run() {
        Long racingGameId = 1L;

        RacingCarGameDisplay.printGameStartMessage();
        String carNamesLine = Console.readLine();
        List<Car> cars = carService.registerCarsByCarNames(carNamesLine);
        RacingCarDistanceGraphics racingCarDistanceGraphics = new RacingCarDistanceGraphics(cars);

        RacingCarGameDisplay.printGameCountMessage();
        String gameCountLine = Console.readLine();
        RegisterRacingCarGameInput input =
                new RegisterRacingCarGameInput(racingGameId, GameType.RACING_CAR_GAME, gameCountLine, cars);
        racingCarGameService.registerCarsAndGameCounter(input);

        RacingCarGameDisplay.printGameResultMessage();
        for (int count = 0; count < parseInt(gameCountLine); count++) {
            List<Car> movedCars = new ArrayList<>();
            for (Car car : cars) {
                int number = Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
                Car moveCar = carService.move(car.getCarName(), number);
                movedCars.add(moveCar);
            }

            racingCarGameService.computeCarsDistanceAndGameCount(racingGameId, movedCars);
            Map<String, String> carMovementMap = racingCarDistanceGraphics.updateCarGraphicsBasedOnDistance(movedCars);
            RacingCarGameDisplay.printCarMovementResultMessage(carMovementMap);
        }

        List<String> winnerNames = racingCarGameService.computeGameWinners(racingGameId);
        RacingCarGameDisplay.printFinalWinnerNames(winnerNames);
    }
}
