package racingcar.component;

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
        String input = Console.readLine();

        if (input.length() < 1) {
            throw new IllegalArgumentException();
        }

        return Arrays.stream(input.split(",")).toList();
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
}
