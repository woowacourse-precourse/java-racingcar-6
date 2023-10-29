package racingcar.mock;

import racingcar.domain.driver.Driver;

public class TrueDriver implements Driver {
    public boolean drive() {
        return true;
    }
}
