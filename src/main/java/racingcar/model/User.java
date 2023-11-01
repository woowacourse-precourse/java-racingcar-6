package racingcar.model;
import camp.nextstep.edu.missionutils.Console;

public class User {
    public String[] getUserInputForCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNames = Console.readLine().split(",");
        return carNames;
    }
}
