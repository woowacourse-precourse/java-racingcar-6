package racingcar.domain;

import racingcar.view.InputView;

import java.util.ArrayList;
import java.util.Arrays;

public class Car {
    public static ArrayList<String> inputNames() {
        String names = InputView.printInputCarNamesMessage();
        String[] eachNames = names.split(",");
        ArrayList<String> listOfNames = new ArrayList<String>(Arrays.asList(eachNames));
        System.out.print(listOfNames);
        return listOfNames;
    }

    public boolean checkNameLength() {
        return false;
    }
}
