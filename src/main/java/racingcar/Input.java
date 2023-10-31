package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    public String input_name() {
        String input = Console.readLine();
        return input;
    }

    public String[] devide_name(String input) {
        String[] split = input.split(",");
        return split;
    }

    public int input_count() {
        int cnt = Integer.parseInt(Console.readLine());
        return cnt;
    }

}
