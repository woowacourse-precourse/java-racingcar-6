package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

import racingcar.util.NameParser;
import racingcar.validation.NameInputValidator;
import racingcar.validation.TryCountInputValidator;

public class RacingManager {
    private final static String INPUT_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final static String INPUT_TRY_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";
    private final static String GAME_RESULT_MESSAGE = "실행 결과";
    private final static String FINAL_WINNER_MESSAGE = "최종 우승자 : ";

    private static List<String> nameList;
    private static String tryCount;

    public void run() {
        inputCarName();
        inputTryCount();
        playRacing();
        announceWinner();
    }

    private void inputCarName() {
        System.out.println(INPUT_NAME_MESSAGE);
        String nameString = Console.readLine();

        nameList = new NameParser().parseName(nameString);
        new NameInputValidator().validateInput(nameList);
    }

    private void inputTryCount() {
        System.out.println(INPUT_TRY_COUNT_MESSAGE);
        tryCount = Console.readLine();

        new TryCountInputValidator().validateInputTryCount(tryCount);
    }

    private void playRacing() {

    }

    private void announceWinner() {
    }
}
