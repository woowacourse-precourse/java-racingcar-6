package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.controller.Validate;

import java.util.ArrayList;
import java.util.List;

public class InputView {

    public List<String> getNames(){
        String inputString = Console.readLine();
        List<String> nameList = new ArrayList<>();
        for (String name: inputString.replaceAll(" ", "").split(",")){
            nameList.add(name);
        }
        return nameList;
    }

    public String askHowMany(){
        String inputString = Console.readLine();
        return inputString;
    }
}
