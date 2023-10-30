package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class InputView {

    public static List<String> readCarNames(){
        String names = Console.readLine();
        return parseCarNames(names);
    }

    public static List<String> parseCarNames(String names){
        return List.of(names.split(","));
    }
}
