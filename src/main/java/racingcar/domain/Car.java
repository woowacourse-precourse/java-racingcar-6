package racingcar.domain;

import java.util.Map;

/* Car 하나하나 관리 하는 클래스
*  이름
*  위치
*  전진 기능
*  후진 기능
* */
public class Car {
    private String carName;
    private Map<String, Integer> car;
    public Car(String carName) {
        validateDuplicate(carName);
        this.carName = carName;
    }

    // 전진 기능
    public void forward() {
        int location = car.get(carName);
        car.put(carName,++location);
    }

    // 후진 기능
    public void backward() {
        int location = car.get(carName);
        car.put(carName,--location);
    }

    // car 중복 검사
    public void validateDuplicate(String carName) {
        if (Cars.cars.contains(car)) {
            throw new IllegalArgumentException("중복된 이름의 자동차는 동시에 경기할 수 없습니다.");
        }
    }
}
