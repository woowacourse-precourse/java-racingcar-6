package racingcar;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListConverter {
    public ArrayList<String> carNameStringToArrayList(String targetNameString) {
        String[] targetStringArray = targetNameString.split(",");
        ArrayList<String> convertedArrayList = new ArrayList<>(Arrays.asList(targetStringArray));

        return convertedArrayList;
    }
}
