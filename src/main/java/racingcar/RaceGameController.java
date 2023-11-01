package racingcar;

import java.util.Arrays;
import java.util.List;

public class RaceGameController {
    View view = new View();

    public void start() {
        view.showInputCars();
        String carNamesInput = view.getInput();
        validCarNamesInput(carNamesInput);
        List<String> carNamesList = splitCarNamesInput(carNamesInput);
        validCarNamesList(carNamesList);

        view.showInputRound();
        String roundInput = view.getInput();
        validRoundInput(roundInput);
        int roundInt = Integer.parseInt(roundInput);

        System.out.println(carNamesList);
        System.out.println(roundInt);
    }

    private void validCarNamesInput(String carNamesInput) {
        if (!carNamesInput.contains(",")) {
            throw new IllegalArgumentException();
        }
    }

    private List<String> splitCarNamesInput(String carNamesInput) {
        String[] carNames = carNamesInput.split(",");
        return Arrays.asList(carNames);
    }

    private void validCarNamesList(List<String> carNamesList) {
        for (String carName : carNamesList) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }

    private void validRoundInput(String roundInput) {
        try {
            Integer.parseInt(roundInput);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }
    }
}
