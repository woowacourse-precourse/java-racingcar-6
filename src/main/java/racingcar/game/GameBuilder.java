package racingcar.game;

import camp.nextstep.edu.missionutils.Console;
import racingcar.constant.ExceptionMessage;

public class GameBuilder {
    private String[] names;
    private String roundString;

    public GameBuilder getCarsName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        this.names = Console.readLine().split(",");

        return this;
    }

    public GameBuilder getRoundNumber() {
        System.out.println("시도할 회수는 몇회인가요?");
        roundString = Console.readLine();

        return this;
    }

    public Game build() {
        if (names == null || roundString == null) {
            throw new IllegalArgumentException(ExceptionMessage.CANT_BUILD_GAME_YET);
        }
        return new Game(names, roundString);
    }
}