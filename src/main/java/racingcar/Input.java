package racingcar;

import java.util.List;
import java.util.Arrays;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    List<String> nameList;

    Input() {
        String nameString = Console.readLine();
        nameList = Arrays.asList(nameString.split(","));
    }

    public void print() {
        for (String carName : nameList)
            System.out.print(carName + " ");
        System.out.println();
    }


}