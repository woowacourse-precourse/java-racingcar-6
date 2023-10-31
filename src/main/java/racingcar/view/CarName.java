package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.util.CarNameValidator;

public class CarName {
    private CarNameValidator carNameValidator = new CarNameValidator();
    private Order order = new Order();
    public String input() {
        order.racingStart();
        String carNames = Console.readLine();

        if(carNameValidator.check(carNames)){
            return carNames;
        }
        throw new IllegalArgumentException("잘못된 차 이름입니다.");
    }
}
