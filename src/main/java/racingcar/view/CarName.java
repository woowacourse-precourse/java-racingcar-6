package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.util.CarNameValidator;

public class CarName {
    CarNameValidator carNameValidator = new CarNameValidator();
    Order order = new Order();
    public String input() {
        order.racingStart();
        String carNames = Console.readLine();

        if(carNameValidator.check(carNames)){
            return carNames;
        }
        throw new IllegalArgumentException();
    }
}
