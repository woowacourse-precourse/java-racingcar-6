package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class UserInput {
    private String[] names;
    private int location;

    public String[] carName() {
        String input = Console.readLine();
        names = input.split(",");

        if (InputValidator.carName(names)) {
            return names;
        } else {
            throw new IllegalArgumentException("Wrong input");
        }
    }

    public int attemptsNumber() {
        String input = Console.readLine();

        try {
            location = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Wrong input");
        }

        if(location < 0) {
            throw new IllegalArgumentException("Wrong input");
        }

        return location;
    }
}