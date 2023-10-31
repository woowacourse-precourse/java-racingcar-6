package racingcar.domain;

import java.util.Map;

/* Car 하나하나 관리 하는 클래스
*  이름
*  위치
*  전진 기능
*  후진 기능
* */
public class Car {
    public String carName;
    public int location; // static으로 하니까 모든 car 객체들의 location++ 합쳐짐
    public static final int MAX_CAR_NAME = 5;

    public Car(String carName) {
        validateCarNumbers(carName);
        this.carName = carName;
        this.location = 0;
    }

    // 전진 기능 -- > go 처럼 직관적인 이름도  괜찮을 듯
    public void forward() {
        this.location++;
    }

    // 후진 기능 --> 필요 없을 듯
    public void backward() {
        this.location--;
    }

    // car 중복 검사 --> contins 할 방법을 찾아야함
    public void validateDuplicate() {
        if (Cars.cars.contains(carName)) {
            throw new IllegalArgumentException("중복된 이름의 자동차는 동시에 경기할 수 없습니다.");
        }
    }


    // car 5대 이하 check
    public void validateCarNumbers(String carName) {
        if ( carName.length() > MAX_CAR_NAME) {
            throw new IllegalArgumentException("이름은 최대 5자까지 가능합니다.");
        }
    }
}
