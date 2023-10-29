package racingcar.ui.input;

import camp.nextstep.edu.missionutils.Console;

/**
 * @author 민경수
 * @description number of movement input reader
 * @since 2023.10.27
 **********************************************************************************************************************/
public class NumberOfMovementInputReader{

    public int readLine() {
        System.out.println("시도할 회수는 몇회인가요?");
        return convertToInteger(Console.readLine());
    }

    private int convertToInteger(String number) {
        return Integer.parseInt(number);
    }

}