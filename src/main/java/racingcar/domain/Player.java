package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Player {
    public List<String> inputNames() throws IllegalArgumentException {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        List<String> names = new ArrayList<>();
        String input = Console.readLine();

        validateLine(input);
        for (String name : input.split(",")) {
            validateName(name);
            names.add(name);
        }

        return names;
    }

    private void validateLine(String line) throws IllegalArgumentException {
        if (line.substring(line.length() - 1).equals(",")) {
            throw new IllegalArgumentException();
        }
    }

    private void validateName(String name) throws IllegalArgumentException {
        if (name.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    public int inputNumberOfRounds() throws IllegalArgumentException {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = Console.readLine();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
