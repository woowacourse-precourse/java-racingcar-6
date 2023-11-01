package racingcar.model;
import camp.nextstep.edu.missionutils.Console;

public class User {
    private Integer tryCount;
    public Integer getUserInputForTryCount() throws IllegalArgumentException {
        System.out.println("시도할 회수는 몇회인가요?");
        this.tryCount = Integer.parseInt(Console.readLine());
        return tryCount;
    }
    public String[] getUserInputForCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNames = Console.readLine().split(",");
        return carNames;
    }
}
