package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Racing;
import racingcar.view.OutputView;

import java.util.List;

public class GameService {

    private static List<String> carNameList;
    private static int numberOfTry;
    private static Racing racing = new Racing();


    public static void startGame(){
        OutputView.printStartCarNameMessage();
        carNameList = CheckCarInput.checkCarNameInput(Console.readLine());

        OutputView.printTryNumberMessage();
        numberOfTry = CheckTryNumber.checkTryNumber(Integer.parseInt(Console.readLine()));
        System.out.println("");


    }

    public static void playGame(){
        OutputView.printGameResultMessage();
        racing.updateCarList(carNameList);

        for (int i = 0; i < numberOfTry; i++) {
            racing.executingGame(racing.carList);
            OutputView.printExecutionMessage(racing.carList);
        }
    }

    public static void endGmae(){

        List<String> winnerList = Racing.getWinner();
        OutputView.printWinnerMessage(winnerList);
    }

}
