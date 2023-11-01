package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import racingcar.message.ExceptionMessage;
import racingcar.message.InputMessage;

public class InputView {
    public String[] getNames(){
        printMessage(InputMessage.START_GAME);
        String inputNames = Console.readLine();
        String [] names = inputNames.split(",");
        nameCheckDuplicate(names);
        nameCheckLength(names);
        nameContainsNumber(names);
        return names;
    }

    public int getRounds(){
        printMessage(InputMessage.SET_GAME_ROUND);
        String inputRounds = Console.readLine();
        int round = Integer.parseInt(inputRounds);
        return round;
    }

    public void nameCheckDuplicate(String[] names){
        List<String> duplicateCheck = new ArrayList<>();
        for(String name : names){
            if(duplicateCheck.contains(name)){
                printMessage(ExceptionMessage.NAME_NOT_DUPLICATE);
                throw new IllegalArgumentException();
            }else duplicateCheck.add(name);
        }
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

    private void printMessage(String text){
        System.out.println(text);
    }
}
