package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.message.InputMessage;

public class InputView {
    public String[] setNames(){
        printMessage(InputMessage.START_GAME);
        String inputNames = Console.readLine();
        String [] names = inputNames.split(",");
        return names;

    }

    public int setRounds(){
        printMessage(InputMessage.SET_GAME_ROUND);
        String inputRounds = Console.readLine();
        int round = Integer.parseInt(inputRounds);
        return round;
    }

    private void printMessage(String text){
        System.out.println(text);
    }
}
