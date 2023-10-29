package view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class Input {

    public List<String> carName() {

        String[] carNames = Console
                .readLine()
                .split(",");
        Exception.nameVerification(carNames);
        return Arrays.asList(carNames);

    }

    public int numberOfAttempts() {

        return Integer.parseInt(Console.readLine());

    }


}
