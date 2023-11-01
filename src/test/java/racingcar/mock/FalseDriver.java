package racingcar.mock;

import racingcar.domain.driver.Driver;

public class FalseDriver implements Driver {
    public boolean drive() {
        return false;
    }
}
