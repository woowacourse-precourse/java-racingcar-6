package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.car.CarList;
import racingcar.domain.car.CarListFactory;
import racingcar.domain.round.Round;
import racingcar.domain.round.RoundFactory;

import static racingcar.Constant.*;

public class GameManager {

    private final CarListFactory carListFactory;
    private final RoundFactory roundFactory;

    public GameManager(CarListFactory carListFactory, RoundFactory roundFactory) {
        this.carListFactory = carListFactory;
        this.roundFactory = roundFactory;
    }

    public void play() {
        CarList carList = getCarList();

        Round round = getRound();

        move(carList, round);

        carList.printWinners();
    }

    private CarList getCarList(){
        System.out.println(MESSAGE_INPUT_CAR_NAMES);
        String input = Console.readLine();

        return carListFactory.create(input);
    }

    private Round getRound(){
        System.out.println(MESSAGE_INPUT_ROUND);
        String input = Console.readLine();

        return roundFactory.create(input);
    }

    private void move(CarList carList, Round round) {
        System.out.println(MESSAGE_SHOW_OUTPUT);

        while (round.isLeft()) {
            carList.move();
            System.out.println(carList);
        }
    }
}
