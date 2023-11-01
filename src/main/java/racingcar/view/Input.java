package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static racingcar.constants.StringStore.*;

public class Input {
    public String inputNames() {
        System.out.println(INPUT_CAR_NAMES);
        String inputCarString = Console.readLine();
        return inputCarString;
    }
}
