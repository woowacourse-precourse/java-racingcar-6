package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.message.ExceptionMessage;
import racingcar.message.InputMessage;

public class InputView {
    public String[] getNames(){
        printMessage(InputMessage.START_GAME);
        String inputNames = Console.readLine();
        String [] names = inputNames.split(",");
        nameCheckLength(names);
        nameContainsNumber(names);
        return names;
    }

    public void nameCheckLength(String[] names){
        for(String name : names){
            if(name.length() > 5){
                printMessage(ExceptionMessage.NAME_LENGTH_OVER);
                throw new IllegalArgumentException();
            }
        }
    }

    public void nameContainsNumber(String[] names){
        for(String name : names){
            if(containsNumber(name)){
                printMessage(ExceptionMessage.NAME_NOT_NUMBER);
                throw new IllegalArgumentException();
            }
        }
    }

    private boolean containsNumber(String str) {
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    public int getRounds(){
        printMessage(InputMessage.SET_GAME_ROUND);
        String inputRounds = Console.readLine();
        int round = Integer.parseInt(inputRounds);
        return round;
    }

    private void printMessage(String text){
        System.out.println(text);
    }
}
