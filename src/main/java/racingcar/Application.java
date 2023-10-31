package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

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

        if (input.charAt(input.length() - 1) == ',') {
            throw new IllegalArgumentException();
        }

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
        long count = 0;

        try {
            count = Long.parseLong(input);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException();
        }

        if (count <= 0) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < count; i++) {
            for (Map.Entry<String, String> entry : carDistanceMap.entrySet()) {
                if (Randoms.pickNumberInRange(0, 9) >= 4) {
                    String beforeDistance = entry.getValue();
                    carDistanceMap.replace(entry.getKey(), beforeDistance + "-");
                }

                System.out.println(entry.getKey() + " : " + entry.getValue());
            }
            System.out.println();
        }

        List<String> result = new ArrayList<>();

        int maxLength = carDistanceMap.values()
                .stream()
                .mapToInt(String::length)
                .max()
                .orElse(0);

        carDistanceMap.forEach((k, v) -> {
            if (v.length() == maxLength) {
                result.add(k);
            }
        });

        System.out.println("최종 우승자 : " + String.join(", ", result));

    }
}
