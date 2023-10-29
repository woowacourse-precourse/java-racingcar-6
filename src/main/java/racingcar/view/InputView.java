package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.message.InputMessage;

public class InputView {
    public String[] getNames(){
        printMessage(InputMessage.START_GAME);
        String inputNames = Console.readLine();
        return inputNames.split(",");
    }

    public int getRound(){
        printMessage(InputMessage.SET_GAME_ROUND);
        String inputRounds = Console.readLine();
        int round = Integer.parseInt(inputRounds);
        return round;
    }

    private void printMessage(String text){
        System.out.println(text);
    }
}
