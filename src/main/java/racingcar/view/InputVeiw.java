package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputVeiw {

    public List<String> inputCarName() {
        return Arrays.stream(Console.readLine()
                .split(",")).toList();
    }

    public Integer inputRoundNumber() {
        return Integer.parseInt(Console.readLine());
    }
}
