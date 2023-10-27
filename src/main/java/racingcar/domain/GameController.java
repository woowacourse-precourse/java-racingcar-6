package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

public class GameController {

    public GameController() {
        setCars();
        setNumbers();
    }

    public void setCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String Car = Console.readLine();
    }

    public void setNumbers() {
        System.out.println("시도할 회수는 몇회인가요?");
        int numbers = Integer.parseInt(Console.readLine());
    }
}
