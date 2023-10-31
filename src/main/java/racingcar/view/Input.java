package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.race.CarNameExceptionProcessing;
import racingcar.race.NumberTimeTryExceptionProcessing;

public class Input {

    public List<String> carName() {

        String[] carNames = Console
                .readLine()
                .split(",");
        CarNameExceptionProcessing.checkName(carNames);
        return Arrays.asList(carNames);

    }

    public int numberTimesTry() {

        int numberTimeTry = Integer.parseInt(Console.readLine());
        return NumberTimeTryExceptionProcessing.checkNumber(numberTimeTry);

    }

}
