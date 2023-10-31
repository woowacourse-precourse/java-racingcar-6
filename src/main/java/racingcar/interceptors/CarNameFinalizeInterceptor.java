package racingcar.interceptors;

import racingcar.model.Car;

import java.util.List;

public class CarNameFinalizeInterceptor implements Interceptor<List<String>, List<Car>> {
    @Override
    public List<Car> handling(List<String> targetObject) throws IllegalArgumentException {
        return targetObject.stream().map(Car::new).toList();
    }
}
