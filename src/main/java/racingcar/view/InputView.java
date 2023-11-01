package racingcar.view;

import static racingcar.domain.Constant.PLAYER_NAMES_DELIMITER;
import static racingcar.domain.Constant.PLAYER_NAMES_DELIMITER_NAME;
import static racingcar.view.OutputView.printEmptyLine;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.RaceCount;
import racingcar.dto.PlayerNamesDto;
import racingcar.util.InputConvertor;
import racingcar.util.InputValidator;

public class InputView {

    private static final String RACE_COUNT_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";

    public static PlayerNamesDto InputPlayerNames() {
        System.out.printf("경주할 자동차 이름을 입력하세요.(이름은 %s(%s) 기준으로 구분)", PLAYER_NAMES_DELIMITER_NAME,
                PLAYER_NAMES_DELIMITER);
        printEmptyLine();
        String rawPlayerNames = Console.readLine();
        InputValidator.validatePlayerNames(rawPlayerNames);
        return InputConvertor.convertPlayerNames(rawPlayerNames);
    }

    public static RaceCount InputRaceCount() {
        System.out.println(RACE_COUNT_INPUT_MESSAGE);
        String rawRaceCount = Console.readLine();
        InputValidator.validateRaceCount(rawRaceCount);
        return InputConvertor.convertRaceCount(rawRaceCount);
    }
}
