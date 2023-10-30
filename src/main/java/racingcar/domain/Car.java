package racingcar.domain;

import racingcar.view.InputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Car {
    public static ArrayList<String> inputNames() {
        String names = InputView.printInputCarNamesMessage();
        String[] eachNames = names.split(",");
        ArrayList<String> listOfNames = new ArrayList<String>(Arrays.asList(eachNames));
        System.out.print(listOfNames);
        return listOfNames;
    }

    public static HashMap<String, Integer> makeMap(ArrayList<String> carsList) {
        HashMap<String, Integer> carsMap = new HashMap<>();
        for (String s : carsList) {
            carsMap.put(s, 0);
        }
        return carsMap;
    }

    public boolean checkNameLength() {
        return false;
    }
}
