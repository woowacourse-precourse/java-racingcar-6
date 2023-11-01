package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.utils.ExceptionProcess;

import static racingcar.utils.GameMessage.START;
import static racingcar.utils.GameMessage.TRY;

public class Enter {

    private static ExceptionProcess exceptionProcess = new ExceptionProcess();

    public String[] enterCarsName() {
        System.out.println(START);
        String carName = Console.readLine();
        exceptionProcess.carNameEnterException(carName);
        return carName.split(",");
    }

    public int enterNumberTry() {
        System.out.println(TRY);
        String numberTry = Console.readLine();
        exceptionProcess.numberTryEnterException(numberTry);
        return Integer.parseInt(numberTry);
    }
}
