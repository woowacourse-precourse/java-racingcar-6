package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.collection.CarNames;
import racingcar.domain.collection.RacingCars;
import racingcar.domain.interfaces.Game;
import racingcar.util.InputUtil;
import racingcar.util.RacingGameConst;
import racingcar.util.RacingGameValidator;

import java.util.ArrayList;
import java.util.List;

import static racingcar.util.RacingGameConst.*;

public class RacingGame implements Game {


    @Override
    public void start() {
        int gameCount = createGameCount();
        CarNames carNames = createCarNames(gameCount);
        RacingCars racingCars = createRacingCars(carNames, gameCount);

    }

    public int createGameCount() {
        String input = Console.readLine();
        RacingGameValidator.validateGameCount(input);
        return Integer.parseInt(input);
    }

    public CarNames createCarNames(int count) {
        String input = Console.readLine();
        List<String> carNames = InputUtil.getSplitTokensFrom(input);
        return new CarNames(carNames);
    }

    public RacingCars createRacingCars(
            final CarNames names,
            int count
    ) {
        List<RacingCar> racingCars = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            RacingCar racingCar = createRacingCar(names.get(i));
            racingCars.add(racingCar);
        }

        return new RacingCars(racingCars);
    }

    public RacingCar createRacingCar(final String name) {
        return new RacingCar(name, INITIAL_CAR_PROGRESS);
    }

}
