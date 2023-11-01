package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import racingcar.view.OutputView;

import java.util.List;

public class GameService {

    private static List<String> carNameList;

    public static void startGame(){
        OutputView.printStartCarNameMessage();
        carNameList = CheckCarInput.checkCarNameInput(Console.readLine());

    }

    public static void playGame(){

    }

    public static void endGmae(){

    }
}
