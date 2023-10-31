package racingcar.service;

import racingcar.domain.car.Cars;


public class ServiceFactory {
    public static Service offer(Cars cars, Attempt attempt) {
        return GameService.of(cars, attempt);
    }
}
