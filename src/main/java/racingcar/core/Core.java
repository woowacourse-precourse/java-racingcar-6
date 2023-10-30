package racingcar.core;

import camp.nextstep.edu.missionutils.Console;
import racingcar.utils.Utils;

import java.util.Arrays;
import java.util.List;

public class Core {
    public List<String> stringToStringList(String input) {
        return Arrays.stream(input.split(",")).toList();
    }

    public int getCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String count = Console.readLine();
        Utils.validateStringDigit(count);
        return Integer.parseInt(count);
    }
}
