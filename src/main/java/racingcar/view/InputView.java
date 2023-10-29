package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;
import java.util.NoSuchElementException;

public class InputView {
    public List<String> readCarsNamesInput() {
        String input = readLine();
        List<String> carsNames = List.of(input.split(","));

        return carsNames;
    }

    public Integer readNumberInput() {
        String input;
        int intValue;

        try {
            input = readLine();
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }

        try {
            intValue = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }

        if (intValue <= 0){
            throw new IllegalArgumentException("최소 한번 이상 이동해야합니다");
        }
        return intValue;
    }
}
