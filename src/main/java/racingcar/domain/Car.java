package racingcar.domain;

import racingcar.view.InputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Car {
    public String name;
    public int distance;

    public Car(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public void moveForward() {
        int beforeDistance = this.distance;
        this.distance = beforeDistance + 1;
    }

    public static ArrayList<String> inputNames() {
        String names = InputView.printInputCarNamesMessage();
        String[] eachNames = names.split(",");
        ArrayList<String> listOfNames = new ArrayList<>(Arrays.asList(eachNames));
        return listOfNames;
    }

    public static HashMap<String, Integer> makeMap(ArrayList<String> carNames) {
        LinkedHashMap<String, Integer> carsMap = new LinkedHashMap<>();
        for (String s : carNames) {
            checkLength(s);
            carsMap.put(s, 0);
        }
        return carsMap;
    }

    public static void checkLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException();
        }
    }
}
