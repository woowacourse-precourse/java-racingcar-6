package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class User {
    private List<String> carName;

    void setCar() throws IllegalArgumentException {
        String input = Console.readLine();
        Console.close();

        if(!(input.contains(","))) {
            throw new IllegalArgumentException();
        }

        List<String> carName = List.of(input.split(","));

        for (String element: carName) {
            if (element.length() > 5) {
                throw new IllegalArgumentException();
            }
        }

        this.carName = carName;
    }
}
