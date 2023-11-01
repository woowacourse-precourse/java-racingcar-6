package racingcar.utils.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.car.Cars;
import racingcar.game.TryCount;

public class Input {
    public Cars readCarsName() {
        return new Cars(Console.readLine());
    }

    public TryCount readTryCount() {
        return new TryCount(Console.readLine());
    }
}
