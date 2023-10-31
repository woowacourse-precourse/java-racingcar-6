package racingcar.domain;

import java.util.List;

/* Car 전부 관리하는 클래스
* List<Car> 을 관리
*  최대 5개까지
*  중복 검사
*  */
public class Cars {
    public static List<Car> cars;
    public Cars(List<Car> cars) {
        this.cars = cars;
    }
}
