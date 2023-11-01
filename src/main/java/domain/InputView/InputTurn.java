package domain.InputView;

import camp.nextstep.edu.missionutils.Console;
public class InputTurn {

    public static int turnInput(){
        System.out.println("시도할 회수는 몇회인가요?");
        return inputToInt(Console.readLine());
    }

    private static int inputToInt(String turnNum){
        TurnValidiator check = new TurnValidiator(turnNum);
        return Integer.parseInt(turnNum);

    }
}
