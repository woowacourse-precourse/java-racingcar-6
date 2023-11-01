package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;
import racingcar.validator.Vaildator;


public class InputView {

    public static final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String INPUT_MOVE_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";

    private final Vaildator vaildator = new Vaildator();

    public InputView() {
    }

    public String inputCarNames() {
        System.out.println(INPUT_CAR_NAME_MESSAGE);
        return readLine();
    }

    public List<String> parseCarNames(String input) {
        List<String> carNameList = List.of(input.split(","));
        validateCarNames(carNameList);
        return carNameList;
    }

    public String inputMoveCount() {
        System.out.println(INPUT_MOVE_COUNT_MESSAGE);
        return readLine();
    }

    public int parseMoveCount(String input) {
        validateMoveCount(input);
        return Integer.parseInt(input);
    }

    public void validateMoveCount(String input) {
        if (!vaildator.isPositiveInteger(input)) {
            throw new IllegalArgumentException("error: 숫자가 아닌 값이 입력되었습니다.");
        }
    }

    public void validateCarNames(List<String> carNameList) {
        if (vaildator.checkDuplicateName(carNameList)) {
            throw new IllegalArgumentException("error: 중복된 이름이 입력되었습니다.");
        }
        if (vaildator.checkCharactorLimit(carNameList)) {
            throw new IllegalArgumentException("error: 글자수가 초과된 이름이 입력되었습니다.");
        }
        if (vaildator.checkEmptyName(carNameList)) {
            throw new IllegalArgumentException("error: 구분자 사이에 입력되지 않은 이름이 있습니다.");
        }
    }
}
