package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.constant.InputMessage;

public class Input {

    InputException inputException = new InputException();

    public String[] inputCarName(){
        System.out.println(InputMessage.INIT_CAR_NAME.getMessage());
        String input = Console.readLine();

        inputException.inputSeparatorException(input);

        String[] cars = input.split(",");
        inputException.inputCarsSizeException(cars);
        inputException.inputCarNameOfLengthException(cars);
        return cars;
    }

    public int inputMovingNumber(){
        System.out.println(InputMessage.INIT_NUMBER.getMessage());
        String input = Console.readLine();

        inputException.inputMovingNumberException(input);

        return Integer.parseInt(input);
    }
}
