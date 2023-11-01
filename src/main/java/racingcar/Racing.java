package racingcar;

import camp.nextstep.edu.missionutils.Console;


public class Racing {
    Utils utils = new Utils();
    Exceptions exceptions = new Exceptions();

    public void start() {
        generateCarName();
        moveTry();
        utils.finalWinner();
    }

    public void generateCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        exceptions.isInvalidNullName(input);
        utils.carNames(input);
    }

    public void moveTry() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = Console.readLine();
        exceptions.isInvalidStringCount(input);
        System.out.println();
        utils.race(input);
    }
}
