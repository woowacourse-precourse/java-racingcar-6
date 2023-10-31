package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.console.ConsoleInput;
import racingcar.interceptors.*;
import racingcar.model.Car;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private List<Car> carList;

    public void start() {
        ConsoleInput<List<String>, List<Car>> carInput = buildCarInput();
        ConsoleInput<Long, Long> countInput = buildCountInput();

        carList = carInput.getUserInput("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        Long count = countInput.getUserInput("시도할 회수는 몇회인가요?");

        for (int i = 0; i < count; i++) {
            carList.forEach(this::process);
            System.out.println();
        }

        System.out.println("최종 우승자 : " + String.join(", ", getVictor()));
    }

    private ConsoleInput<List<String>, List<Car>> buildCarInput() {
        return new ConsoleInput<>(new CarNameInitInterceptor(), new CarNameFinalizeInterceptor())
                .registerInterceptor(new CarNameStripInterceptor())
                .registerInterceptor(new CarNameLengthCheckInterceptor());
    }

    private ConsoleInput<Long, Long> buildCountInput() {
        return new ConsoleInput<>(new CountInitInterceptor(), new CountFinalizeInterceptor())
                .registerInterceptor(new CountRangeInterceptor());
    }

    private void process(Car car) {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            car.increaseDistance();
        }

        System.out.println(car);
    }

    private List<String> getVictor() {
        List<String> result = new ArrayList<>();

        long farthestDistance = getFarthestDistance();

        carList.forEach(car -> {
            if (car.getDistance() == farthestDistance) {
                result.add(car.getName());
            }
        });

        return result;
    }

    private long getFarthestDistance() {
        return carList
                .stream()
                .mapToLong(Car::getDistance)
                .max()
                .orElseThrow(IllegalArgumentException::new);
    }
}
