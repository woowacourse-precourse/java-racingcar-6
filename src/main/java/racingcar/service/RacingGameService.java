package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGameService {

    private List<String> carsName;
    private Integer count;

    public RacingGameService() {
    }

    public RacingGameService(List<String> carsName, Integer count) {
        this.carsName = carsName;
        this.count = count;
    }

    public void play() {
        List<Car> cars = new ArrayList<>();
        for (String name : carsName) {
            cars.add(new Car(name));
        }

        System.out.println();
        System.out.println("실행 결과");
        while (count > 0) {
            for (Car car : cars) {
                car.move(Randoms.pickNumberInRange(0, 9));
                System.out.println(car);
            }
            System.out.println();
            count--;
        }

        Integer maxPosition = cars.stream().max(Comparator.comparingInt(Car::getPosition)).get().getPosition();
        List<String> result = cars.stream().filter(car -> car.getPosition() == maxPosition).map(Car::getName).collect(Collectors.toList());
        System.out.println("최종 우승자 : " + String.join(", ", result));
    }
}
