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
        validateCarLength(carName);

        this.carName = carName;
        this.location = 0;
    }

    // 전진 기능 -- > go 처럼 직관적인 이름도  괜찮을 듯
    public void forward() {
        this.location++;
    }




    // car 5자 이하 check
    public void validateCarLength(String carName) {
        if ( carName.length() > MAX_CAR_NAME) {
            throw new IllegalArgumentException("이름은 최대 5자까지 가능합니다.");
        }
    }
}
