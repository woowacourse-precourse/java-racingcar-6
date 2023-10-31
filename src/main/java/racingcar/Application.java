package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.console.ConsoleInput;
import racingcar.interceptors.*;
import racingcar.model.Car;

import java.util.*;

import static java.util.stream.Collectors.toMap;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        ConsoleInput<List<String>, List<Car>> carInput = new ConsoleInput<>(
                new CarNameInitInterceptor(),
                new CarNameFinalizeInterceptor()
        )
                .registerInterceptor(new CarNameStripInterceptor())
                .registerInterceptor(new CarNameLengthCheckInterceptor());

        List<Car> carList = carInput.getUserInput();

        ConsoleInput<Long, Long> countInput = new ConsoleInput<>(
                new CountInitInterceptor(),
                new CountFinalizeInterceptor()
        )
                .registerInterceptor(new CountRangeInterceptor());

        Long count = countInput.getUserInput();

        // logic
        for (int i = 0; i < count; i++) {
            for (Car car : carList) {
                if (Randoms.pickNumberInRange(0, 9) >= 4) {
                    car.increaseDistance();
                }

                System.out.println(car);
            }

            System.out.println();
        }

//        List<String> result = new ArrayList<>();
//
//        int maxLength = carDistanceMap.values()
//                .stream()
//                .mapToInt(String::length)
//                .max()
//                .orElse(0);
//
//        carDistanceMap.forEach((k, v) -> {
//            if (v.length() == maxLength) {
//                result.add(k);
//            }
//        });

//        System.out.println("최종 우승자 : " + String.join(", ", result));

    }
}
