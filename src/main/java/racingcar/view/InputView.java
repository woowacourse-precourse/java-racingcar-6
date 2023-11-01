package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputView {

    private static final String SEPARATOR = ",";
    private static final String NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ROUND_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";

    public List<String> readCarNames() {
        System.out.println(NAME_INPUT_MESSAGE);
        return List.of(Console.readLine().split(SEPARATOR));
    }

    public int readNumRound() {
        System.out.println(ROUND_INPUT_MESSAGE);
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public void close(){
        Console.close();
    }

}
