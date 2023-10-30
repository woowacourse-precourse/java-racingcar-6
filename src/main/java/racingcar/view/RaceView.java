package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Set;
import racingcar.domain.CarNameList;
import racingcar.domain.GameResult;
import racingcar.exception.BusinessException;
import racingcar.exception.ExceptionCode;
import racingcar.model.Model;
import racingcar.model.ModelConst;
import racingcar.domain.TotalGameResult;

public class RaceView {

    public static final String CAR_NAME_SPLIT_REGEX = ",";
    public static final String RESULT_FORMAT = "실행 결과";
    public static final String WINNER_FORMAT = "최종 우승자 : ";
    public static final String WINNER_JOINING_DELIMITER = ", ";
    public static final String MOVE_MARK = "-";
    public static final String COLON = " : ";
    public static final String CAR_NAME_FORMAT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String ATTEMPT_NUMBER_FORMAT = "시도할 회수는 몇회인가요?";
    private final Model model;

    public RaceView(Model model) {
        this.model = model;
    }


    public void conveyCarNames() {
        printAnnouncementForInputCarName();
        String carNames = conveyInput();
        model.setAttribute(
                ModelConst.CAR_NAME,
                new CarNameList(carNames.split(CAR_NAME_SPLIT_REGEX))
        );
    }

    public void conveyAttemptNumber() {
        printAnnouncementForAttemptNumber();
        String attemptNumber = conveyInput();
        model.setAttribute(
                ModelConst.ATTEMPT_NUMBER,
                attemptNumber
        );
    }

    private String conveyInput() {
        return Console.readLine().trim();
    }

    public void printAnnouncementForInputCarName() {
        System.out.println(CAR_NAME_FORMAT);
    }

    public void printAnnouncementForAttemptNumber() {
        System.out.println(ATTEMPT_NUMBER_FORMAT);
    }

    public void printResult() {
        TotalGameResult totalGameResult = (TotalGameResult) model.getAttribute(
                ModelConst.TOTAL_GAME_RESULT
                )
                .orElseThrow(() -> new BusinessException(
                        ExceptionCode.NO_RESULT,
                        this.getClass()
                ));

        printAnnouncementOfResult();

        totalGameResult.results()
                .forEach(this::printResultEachMove);

        printWinner(totalGameResult);
    }

    private void printAnnouncementOfResult() {
        System.out.println(RESULT_FORMAT);
    }

    private void printWinner(TotalGameResult totalGameResult) {
        String winners = String.join(
                WINNER_JOINING_DELIMITER,
                totalGameResult.winners()
        );
        System.out.println(WINNER_FORMAT + winners);
    }

    private void printResultEachMove(GameResult gameResult) {
        Set<String> names = gameResult.getKeySet();
        names.forEach(n ->
            printResultEachMoveOfCar(gameResult, n)
        );
    }

    private void printResultEachMoveOfCar(GameResult gameResult, String name) {
        System.out.println(name
                + COLON
                + MOVE_MARK.repeat(
                        Math.max(
                                0,
                                gameResult.getDistance(name)
                        )
                )
        );
    }
}
