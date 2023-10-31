package racingcar.interceptors;

import racingcar.model.Car;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toMap;

public class CarNameFinalizeInterceptor implements Interceptor<List<String>, List<Car>> {
    @Override
    public List<Car> handling(List<String> targetObject) throws IllegalArgumentException {
        return targetObject.stream().map(Car::new).toList();
    }
}
