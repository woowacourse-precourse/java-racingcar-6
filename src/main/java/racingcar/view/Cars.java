package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.LinkedList;
import java.util.List;

public class Cars {
    private static final int maxNameLength = 5;
    private static int location = 0;
    private String name;

    Cars(String name, int location) {
        this.name = name;
        this.location = location;
    }

    public static List<Cars> make() {
        List<String> names = name();
        List<Cars> cars = new LinkedList<>();
        for (String name : names) {
            cars.add(new Cars(name, location));
        }
        return cars;
    }
    public static List<String> name() {
        String inputNames = Console.readLine();
        List<String> names = List.of(inputNames.split(","));

        for (String number : names) {
            validNumber(number);
        }
        return names;
    }

    private static void validNumber(String name) {
        if (name.length() > maxNameLength) {
            throw new IllegalArgumentException("이름의 길이나 너무 깁니다");
        }
    }
}
