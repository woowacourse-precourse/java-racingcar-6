package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;

public class InputView {
    public List<String> readCarsNamesInput() {
        String input = readLine();
        List<String> carsNames = List.of(input.split(","));

        return carsNames;
    }
}
