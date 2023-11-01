package racingcar.domain;

import java.util.Map;

public class UserCar {
    private Map<String, Integer> car;

    public UserCar() {
    }

    public UserCar(Map<String, Integer> resource) {
        this.car = resource;
    }

    public Map<String, Integer> getCar() {
        return this.car;
    }
}

