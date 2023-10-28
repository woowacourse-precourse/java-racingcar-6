package racingcar.model;

import java.util.Arrays;
import java.util.List;

public class CarCreator {

    public List<String> splitPlayerInput(String playerInput) {
        return arrayToList(playerInput.split(","));
    }

    private List<String> arrayToList(String[] array) {
        return Arrays.asList(array);
    }
}
