package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String carNameInput() {
        String carNames = Console.readLine();
        if (carNames == null)
            throw new IllegalArgumentException();
        if (carNames.trim().isEmpty())
            throw new IllegalArgumentException();
        if (carNames.startsWith(","))
            throw new IllegalArgumentException();
        if (carNames.endsWith(","))
            throw new IllegalArgumentException();

        String[] carNamesArray = carNames.split(",");

        for (String carName : carNamesArray) {
            if (carName.length() > 5)
                throw new IllegalArgumentException();
        }
        return carNames;
    }

    public int numberOfAttempsInput() {
        try {
            String numberOfAttemps = Console.readLine();
            if (numberOfAttemps == null)
                throw new IllegalArgumentException();
            if (numberOfAttemps.trim().isEmpty())
                throw new IllegalArgumentException();
            if (numberOfAttemps.matches("^[^0-9]*$"))
                throw new IllegalArgumentException();
            int number = Integer.parseInt(numberOfAttemps);
            
            if (number < 1)
                throw new IllegalArgumentException();
            return number;
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException();
        }
    }
}
