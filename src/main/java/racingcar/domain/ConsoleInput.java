package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleInput implements Input {
    @Override
    public void getCarNames() {
        String carNames = Console.readLine();
        System.out.println(carNames);
    }

    @Override
    public void getMoveCount() {
        String moveCount = Console.readLine();
        System.out.println(moveCount);
    }
}
