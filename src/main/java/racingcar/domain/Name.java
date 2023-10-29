package racingcar.domain;

import static racingcar.view.InputView.askCarNames;

import java.util.Arrays;
import java.util.List;

public class Name {
    private List<String> names;

    private Name(String userInput) {
        //validate input
        this.names = convertStringToList(userInput);
    }

    public static Name generateNames() {
        String userInput = askCarNames();
        return new Name(userInput);
    }

    private List<String> convertStringToList(String userInput) {
        return Arrays.stream(userInput.split(","))
                .toList();
    }

    @Override
    public String toString() {
        return names.toString();
    }
}
