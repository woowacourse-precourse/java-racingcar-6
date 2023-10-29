package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.collection.CarNames;
import racingcar.domain.collection.RacingCars;
import racingcar.domain.interfaces.CarFactory;
import racingcar.util.InputUtil;
import racingcar.util.OutputUtil;

import java.util.ArrayList;
import java.util.List;

import static racingcar.app.RacingGameConst.INITIAL_CAR_PROGRESS;

public class RacingCarFactory implements CarFactory {
    @Override
    public RacingCars createCars() {
        CarNames carNames = createCarNames();
        return createRacingCars(carNames, carNames.getCount());
    }

    public CarNames createCarNames() {
        OutputUtil.printWithLine("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String input = Console.readLine();
        List<String> carNames = InputUtil.getSplitTokensFrom(input);
        RacingGameValidator.validateCarNameInput(carNames);

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

