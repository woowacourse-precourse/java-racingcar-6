package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.constant.ExceptionMessage;

public class GameBuilder {
    private String[] names;
    private int roundNumber;

    /**
     * (use builder pattern) get cars name from user
     */
    public GameBuilder getCarsName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        this.names = Console.readLine().split(",");
        InputValidator.validateCarsName(this.names);
        return this;
    }

    /**
     * (use builder pattern) get round number from user
     */
    public GameBuilder getRoundNumber() {
        System.out.println("시도할 회수는 몇회인가요?");
        String roundNumberString = Console.readLine();
        InputValidator.validateRoundNumber(roundNumberString);
        this.roundNumber = Integer.parseInt(roundNumberString);
        return this;
    }


    public Game build() {
        if (names == null || roundNumber == 0) {
            throw new IllegalArgumentException(ExceptionMessage.CANT_BUILD_GAME_YET);
        }

        return new Game(names, roundNumber);
    }
}
