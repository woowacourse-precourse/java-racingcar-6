package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class Input {

    public List<String> carName() {

        String[] carNames = Console
                .readLine()
                .split(",");
        Exception.checkName(carNames);
        return Arrays.asList(carNames);

    }

    public int numberTry() {

        return Integer.parseInt(Console.readLine());

    }


}
