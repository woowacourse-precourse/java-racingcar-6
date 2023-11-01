package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

import racingcar.domain.Car;
import racingcar.domain.ResultGenerator;
import racingcar.domain.UserInputParser;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        String userInput = "";
        UserInputParser userInputParser = new UserInputParser();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        userInput = readLine();

        List<Car> carList = userInputParser.generateCarList(userInput);

        System.out.println("시도할 회수는 몇회인가요?");
        userInput = readLine();

        int totalRound = userInputParser.parseInt(userInput);

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
