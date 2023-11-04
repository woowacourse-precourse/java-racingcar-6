package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

import racingcar.domain.Car;
import racingcar.domain.ResultGenerator;
import racingcar.domain.UserInputParser;
import racingcar.view.InputView;

import java.util.List;

public class Application {
    private static final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String HOW_MANY_ROUND_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";

    public static void main(String[] args) {

        UserInputParser userInputParser = new UserInputParser();

        String carNameInput = InputView.readInput(CAR_NAME_INPUT_MESSAGE);
        List<Car> carList = userInputParser.generateCarList(carNameInput);

        String roundInput = InputView.readInput(CAR_NAME_INPUT_MESSAGE);
        int totalRound = userInputParser.parseInt(roundInput);

        ResultGenerator resultGenerator = new ResultGenerator();

        System.out.println();
        System.out.println("실행 결과");

        for (int round = 0; round < totalRound; round++) {
            resultGenerator.playRound(carList);
            System.out.println();
        }

        List<String> winnerList = resultGenerator.generateWinnerList(carList);
        resultGenerator.printFinalResult(winnerList);
    }
}
