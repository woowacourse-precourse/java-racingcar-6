package racingcar.View;

import static racingcar.util.StringToList.stringToList;

import camp.nextstep.edu.missionutils.Console;

public class inputView {

    public static void getCarNameFromUser(){
        String input = Console.readLine();
        stringToList(input);
    }

}
