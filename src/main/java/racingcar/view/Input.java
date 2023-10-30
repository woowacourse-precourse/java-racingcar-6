package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.race.CarNameExceptionProcessing;

public class Input {

    public List<String> carName() {

        String[] carNames = Console
                .readLine()
                .split(",");
        CarNameExceptionProcessing.checkName(carNames);
        return Arrays.asList(carNames);

    }

    public int numberTimesTry() {

        return Integer.parseInt(Console.readLine());

    }


}
