package racingcar.domain;

import java.util.*;

public class CarNameList {
    public List<String> compareName(String carName) {

        String[] ArraysStr = carName.split(",");
        List<String> listA = new ArrayList<String>();
        for (int i = 0; i < ArraysStr.length; i++) {
            listA.add(ArraysStr[i]);
        }
        return listA;
    }
}
