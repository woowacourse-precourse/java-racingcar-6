package racingcar.interceptors;

import racingcar.model.Car;

import java.util.List;

public class CarNameFinalizeInterceptor implements Interceptor<List<String>, List<Car>> {
    @Override
    public List<Car> handling(List<String> targetObject) throws IllegalArgumentException {
        // 입력 받은 문자열을 최종적으로 List<Car> 자료형으로 반환 받기 위한 인터셉터이다.
        return targetObject.stream().map(Car::new).toList();
    }
}
