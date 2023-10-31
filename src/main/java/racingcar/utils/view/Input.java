package racingcar.utils.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.car.Cars;

public class Input {
    public Cars readCarsName() {
        return new Cars(Console.readLine());
    }
}
