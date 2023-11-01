package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

import static racingcar.constant.Constant.INIT_CAR_NAME;
import static racingcar.constant.Constant.INIT_NUMBER;

public class Input {

    InputException inputException = new InputException();

    public String[] inputCarName(){
        System.out.println(INIT_CAR_NAME);
        String input = Console.readLine();

        inputException.inputSeparatorException(input);

        String[] cars = input.split(",");
        inputException.inputCarsSizeException(cars);
        inputException.inputCarNameOfLengthException(cars);
        return cars;
    }

    public int inputMovingNumber(){
        System.out.println(INIT_NUMBER);
        String input = Console.readLine();

        inputException.inputMovingNumberException(input);

        return Integer.parseInt(input);
    }
}
