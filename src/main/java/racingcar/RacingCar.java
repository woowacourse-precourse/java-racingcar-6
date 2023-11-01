package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.common.Constants;
import racingcar.domain.CarManager;
import racingcar.domain.Referee;
import racingcar.domain.Validator;

public class RacingCar {

    public void play() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputCarNames = Console.readLine();
        CarManager carManager = CarManager.createFromInputCarNames(inputCarNames);

        System.out.println("시도할 회수는 몇회인가요?");
        String inputMoveCount = Console.readLine();
        Validator.validateMoveCountNaturalNumber(inputMoveCount);
        int moveCount = Integer.parseInt(inputMoveCount);

        System.out.println("실행 결과");
        for (int count = 0; count < moveCount; count++) {
            carManager.orderCarsMoveForward();
            List<String> currentConditions = carManager.orderCarsPrintCurrentCondition();
            printCurrentConditions(currentConditions);
        }

        Referee referee = new Referee();
        List<String> winners = referee.determineWinners(carManager);
        printWinners(winners);
    }

    private void printCurrentConditions(List<String> currentConditions) {
        currentConditions.forEach(System.out::println);
        System.out.println();
    }

    private void printWinners(List<String> winners) {
        String winnersString = String.format("최종 우승자 : %s", String.join(Constants.COMMA_BLANK_IN_BACK, winners));
        System.out.println(winnersString);
    }

}
