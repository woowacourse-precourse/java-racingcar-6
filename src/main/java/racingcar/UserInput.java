package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class UserInput {
    private static final String startMessage = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String intMessage = "시도할 회수는 몇회인가요?";
    private final List<Car> cars = new ArrayList<>();

    public String[] getInputName() {
        System.out.println(startMessage);
        String[] inputCarName = Console.readLine().split(",");
        return inputCarName;
    }

    public int getInputInt() {
        System.out.println(intMessage);
        String inputInt = Console.readLine();
        int number = Integer.parseInt(inputInt);
        return number;
    }
}
