package racingcar;

import java.util.ArrayList;
import java.util.Collections;

public class InputProcessor {

    public static ArrayList<String> carNameInputProcess(String input) {
        ArrayList<String> names = new ArrayList<>();
        String[] splitInput = input.split(",");
        Collections.addAll(names, splitInput);
        return names;
    }
}
