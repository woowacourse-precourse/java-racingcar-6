package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import racingcar.view.OutputView;

import java.util.List;

public class GameService {

    private static List<String> carNameList;
    private static int numberOfTry;


    public static void startGame(){
        OutputView.printStartCarNameMessage();
        carNameList = CheckCarInput.checkCarNameInput(Console.readLine());

        OutputView.printTryNumberMessage();
        numberOfTry = CheckTryNumber.checkTryNumber(Integer.parseInt(Console.readLine()));
        System.out.println("");

    }

    public static void playGame(){

    }

    public static void endGmae(){

    }
}
