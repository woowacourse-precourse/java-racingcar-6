package racingcar.input;

import camp.nextstep.edu.missionutils.Console;

/**
 * @author 민경수
 * @description user input reader
 * @since 2023.10.27
 **********************************************************************************************************************/
public class UserInputReader implements InputReader{

    @Override
    public String readLine() {
        return Console.readLine();
    }

}