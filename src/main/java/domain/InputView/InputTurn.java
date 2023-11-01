package domain.InputView;

import camp.nextstep.edu.missionutils.Console;

import static message.NoticeMessages.INPUT_TRY_CNT;

public class InputTurn {

    public static int turnInput(){
        System.out.println(INPUT_TRY_CNT);
        return inputToInt(Console.readLine());
    }

    private static int inputToInt(String turnNum){
        TurnValidiator check = new TurnValidiator(turnNum);
        return Integer.parseInt(turnNum);

    }
}
