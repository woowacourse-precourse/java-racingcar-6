package racingcar.validation;

import racingcar.model.Driver;

public class MoveService {

    public void move(int number,  Driver driver) {
        if (number > 4){
            driver.move();
        }
    }
}
