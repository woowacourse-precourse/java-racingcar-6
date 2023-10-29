package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.CarList;
import racingcar.domain.CarListFactory;

import static racingcar.Constant.*;

public class GameManager {

    private final CarListFactory carListFactory;

    public GameManager(CarListFactory carListFactory) {
        this.carListFactory = carListFactory;
    }

    public void play() {
        CarList carList = create();

        move(carList, moveCount());

        carList.printWinners();
    }

    private CarList create() {
        System.out.println(MESSAGE_INPUT_CAR_NAMES);

        String carNames = Console.readLine();
        return carListFactory.create(carNames);
    }

    private void move(CarList carList, int moveCount) {
        System.out.println(MESSAGE_OUTPUT);

        for (int i = 0; i < moveCount; i++) {
            carList.move();
            System.out.println(carList);
        }
    }

    private int moveCount() {
        System.out.println(MESSAGE_INPUT_MOVE_COUNT);

        String input = Console.readLine();
        return parseAndCheckValid(input);
    }

    private int parseAndCheckValid(String input) {
        int moveCount;
        try {
            moveCount = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_INPUT_MOVE_COUNT);
        }
        return moveCount;
    }
}
