package racingcar.InputView;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.Validator;

public class InputView {
    private Validator validator = new Validator();

    public List<String> getCarNames() {
        List<String> names = new ArrayList<>();

        while (names.isEmpty()) {
            String carNames = getCarNamesFromUser();
                validator.validateCarName(carNames);
                names = Arrays.asList(carNames.split(","));
        }
        return names;
    }

    public String getCarNamesFromUser() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    public int getRoundNumber() {
        int round = 0;

        while(round == 0) {
            System.out.println("시도할 회수는 몇회인가요?");
            String input = Console.readLine();
            validator.checkRoundNumberBlank(input);
            round = Integer.parseInt(input);
        }
        return round;

    }
}
