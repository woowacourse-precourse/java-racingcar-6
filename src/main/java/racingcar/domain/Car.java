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
    private int location = 0;

    public Car(String carName) {
        this.carName = carName;
        validateDuplicate();
    }

    // 전진 기능
    public void forward() {
        this.location++;
    }

    // 후진 기능
    public void backward() {
        this.location--;
    }

    // car 중복 검사
    public void validateDuplicate() {
        if (Cars.cars.contains(carName)) {
            throw new IllegalArgumentException("중복된 이름의 자동차는 동시에 경기할 수 없습니다.");
        }
    }
}
