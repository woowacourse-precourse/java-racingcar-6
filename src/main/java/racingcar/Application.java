package racingcar;

import java.util.Arrays;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Game;
import racingcar.domain.RandomMovingStrategy;
import racingcar.domain.Round;
import racingcar.utils.Utils;
import racingcar.view.Input;
import racingcar.view.Output;

public class Application {
    public static void main(String[] args) {
        Output.printCarsNameInputMessage();
        Cars cars = createCars();

        Output.printRoundInputMessage();
        Round round = Round.from(Input.readInteger());

        Output.printResultMessage();
        Game game = Game.of(cars, round);
        game.play(new RandomMovingStrategy());
    }

    private static Cars createCars() {
        String carNames = Input.readLine();
        String[] carNamesSplitByComma = Utils.splitStringByComma(carNames);
        List<Car> carList = Arrays.stream(carNamesSplitByComma)
                .map(Car::zeroPositionFrom)
                .toList();
        return Cars.from(carList);
    }
}
