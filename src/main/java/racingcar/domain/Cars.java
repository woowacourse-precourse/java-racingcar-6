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
        validateDuplicate(cars);
        this.cars = cars;
    }

    // car 중복 검사 --> contins 할 방법을 찾아야함
    public void validateDuplicate(List<Car> cars) {
        int hasDuplicate = (int)cars.stream().
                map(car -> car.carName).
                distinct()
                .count();

        if (hasDuplicate < cars.size()) {
            throw new IllegalArgumentException("중복된 이름의 차는 참가할 수 없습니다.");
        }
    }
}
