package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {

    public Cars inputName() {
        return new Cars(Console.readLine());
    }

    public int inputRound() {
        return Integer.parseInt(Console.readLine());
    }
}
