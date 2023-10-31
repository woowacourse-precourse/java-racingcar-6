package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

import racingcar.repository.CarRepository;
import racingcar.service.JudgingService;
import racingcar.service.JudgingServiceImpl;
import racingcar.service.RacingService;
import racingcar.service.RacingServiceImpl;
import racingcar.util.NameParser;
import racingcar.validation.NameInputValidator;
import racingcar.validation.TryCountInputValidator;

public class RacingManager {
    private final static String INPUT_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final static String INPUT_TRY_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";
    private final static String GAME_RESULT_MESSAGE = "실행 결과";
    private final static String FINAL_WINNER_MESSAGE = "최종 우승자 : ";

    private static List<String> carList;
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

        carList = new NameParser().parseName(nameString);
        new NameInputValidator().validateInput(carList);
    }

    private void inputTryCount() {
        System.out.println(INPUT_TRY_COUNT_MESSAGE);

        tryCount = Console.readLine();

        new TryCountInputValidator().validateInputTryCount(tryCount);
    }

    private void playRacing() {
        System.out.println(GAME_RESULT_MESSAGE);

        RacingService racingService = new RacingServiceImpl();
        racingService.race(carList,tryCount);

        List<String> racingRecord = racingService.getRecord();

        for (String record : racingRecord) {
            System.out.println(record);
        }
    }

    private void announceWinner() {
        JudgingService judgingService = new JudgingServiceImpl();
        String winner = judgingService.determineWinner();

        System.out.println(FINAL_WINNER_MESSAGE+winner);
    }
}
