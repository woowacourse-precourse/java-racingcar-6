package racingcar.input;

import camp.nextstep.edu.missionutils.Console;

/**
 * @author 민경수
 * @description number of movement input reader
 * @since 2023.10.27
 **********************************************************************************************************************/
public class NumberOfMovementInputReader implements InputReader{

    @Override
    public String readLine() {
        return Console.readLine();
    }

}