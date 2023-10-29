package racingcar.domain;

import java.util.List;

/* Car 전부 관리하는 클래스
* List<Car> 을 관리
*  최대 5개까지
*  중복 검사
*  */
public class Cars {
    public static final int MAX_CAR_NUMBER = 5;
    public static List<Car> cars;
    public Cars(Car car) {
        validateCarNumbers();
    }

    // car 5대 이하 check
    public void validateCarNumbers() {
        if (cars.size() > MAX_CAR_NUMBER) {
            throw new IllegalArgumentException("최대 5대까지 참가 가능합니다.");
        }
    }
}
