package domain.InputValues;

import camp.nextstep.edu.missionutils.Console;
public class InputTurn {

    public static String turnInput(){
        System.out.println("시도할 회수는 몇회인가요?");
        return Console.readLine();
    }

    public static int inputToInt(String turnNum){
        TurnValidiator check = new TurnValidiator(turnNum);
        return Integer.parseInt(turnNum);

    }
}
