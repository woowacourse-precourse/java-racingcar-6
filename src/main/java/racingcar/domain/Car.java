package racingcar.domain;

import java.util.Objects;
import racingcar.vo.CarName;

public class Car {

     private final CarName name;
     private int forwardCount;

    public Car(CarName name) {
        this.name = name;
        forwardCount = 0;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
