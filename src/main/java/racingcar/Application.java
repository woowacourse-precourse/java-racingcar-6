package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        String input = Console.readLine();

        if (input.isEmpty()) {
            throw new IllegalArgumentException();
        }

        if (!input.contains(",")) {
            throw new IllegalArgumentException();
        }

        input = input.strip();

        String[] strCars = input.split(",");

        List<String> carList = Arrays.stream(strCars)
                .map(String::strip)
                .filter(strCar -> strCar.length() <= 5 && !strCar.isEmpty())
                .toList();

        if (strCars.length != carList.size()) {
            throw new IllegalArgumentException();
        }

        Map<String, String> carDistanceMap = carList.stream().collect(toMap(Object::toString, data -> ""));


        input = Console.readLine();
        int count = 0;

        try {
            count = Integer.parseInt(input);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < count; i++) {
            for (Map.Entry<String, String> entry : carDistanceMap.entrySet()) {
                if (Randoms.pickNumberInRange(0, 9) < 4) {
                    continue;
                }
                String beforeDistance = entry.getValue();
                carDistanceMap.replace(entry.getKey(), beforeDistance + "-");
            }
        }
    }
}
