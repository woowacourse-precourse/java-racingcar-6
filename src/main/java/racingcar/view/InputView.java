package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String[] readRacingCarName(){
        String input = Console.readLine();

        return toStringArray(input);
    }

    public int readNumberOfTry(){
        String input = Console.readLine();

        return toInt(input);
    }

    private int toInt(String str){
        return Integer.parseInt(str);
    }

    private String[] toStringArray(String str){
        return str.split(",");
    }
}
