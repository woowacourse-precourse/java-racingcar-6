package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.CarList;

public class RacingCarService {

    public static final int DRIVE_STANDARD_NUMBER = 4;
    public static final int START_INCLUSIVE = 0;
    public static final int END_INCLUSIVE = 9;


    // 이름 출력 + 횟수만큼 전진한 거리 출력
    public List<Car> race(CarList carList) {

        List<Car> cars = carList.getCarList();
        for (Car car : cars) {
            run(car);
            System.out.println(car.showCarInfo());
        }
        System.out.println();
        return cars;
    }

    // 랜덤값뽑아서 4이상일때만전진
    public void run(Car car) {
        if (DRIVE_STANDARD_NUMBER <= Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE)) {
            car.addDistance();
        }
    }

    public String compareMileage(List<Car> cars) {
        int maxMileage = cars.stream()
                .mapToInt(car -> car.getMileage().length())
                .max()
                .orElse(0);

        List<String> maxMileageCarNames = cars.stream()
                .filter(car -> car.getMileage().length() == maxMileage)
                .map(Car::getName)
                .collect(Collectors.toList());

        return String.join(", ", maxMileageCarNames);
    }
}
