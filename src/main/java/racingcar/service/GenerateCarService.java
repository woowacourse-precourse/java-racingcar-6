package racingcar.service;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;

/**
 * Cars의 배열에 car을 삽입해주는 Service
 */
public class GenerateCarService {

    /**
     * 이름들로 car을 생성하여 cars의 배열에 삽입
     *
     * @param names 입력받았던 이름들
     * @param cars  car을 넣어줄 cars객체
     */
    public void setCars(List<String> names, Cars cars) {
        for (String name : names) {
            cars.addCar(new Car(name));
        }
    }
}
