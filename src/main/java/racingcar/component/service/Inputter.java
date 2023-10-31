package racingcar.component.service;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class Inputter {
    private Inputter() {}
    private static Inputter inputter;

    public static Inputter getInputter() {
        if (inputter == null) {
            inputter = new Inputter();
        }
        return inputter;
    }

    public List<String> getNameInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> input = Arrays.stream(Console.readLine().split(",")).toList();

        validateName(input);

        return input;
    }

    public int getDuration() {
        int duration;
        System.out.println("시도할 회수는 몇회인가요?");

        try {
            duration = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        return duration;
    }

    private void validateName(List<String> names) {
        if (names.size() < 1) {
            throw new IllegalArgumentException();
        }
        for (String name : names) {
            if (name.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }
}
