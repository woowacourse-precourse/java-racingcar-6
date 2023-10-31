package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import racingcar.io.ConsoleMessage;
import racingcar.io.ConsoleProcessor;
import racingcar.model.Car;
import racingcar.model.LoopCount;
import racingcar.model.vo.CarList;

public class GameRound {

    private static final int LOWER_BOUND = 0;
    private static final int UPPER_BOUND = 9;

    private final ConsoleProcessor consoleProcessor;

    public GameRound(ConsoleProcessor consoleProcessor) {
        this.consoleProcessor = consoleProcessor;
    }

    protected CarList playGame(final CarList candidates, final LoopCount loopCount) {
        CarList carList = CarList.of(new ArrayList<>(candidates.cars()));

        consoleProcessor.printRacingGameResult();

        for (int i = 0; i < loopCount.getValue(); i++) {
            for (Car car : carList.cars()) {
                int randomValue = Randoms.pickNumberInRange(LOWER_BOUND, UPPER_BOUND);
                car.forward(randomValue);

                consoleProcessor.printRoundScore(car.getName(), car.getForwardCount());
            }

            consoleProcessor.printNewLine();
        }

        return carList;
    }

}
