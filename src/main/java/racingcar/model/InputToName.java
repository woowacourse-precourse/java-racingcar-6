package racingcar.model;

import java.util.ArrayList;
import java.util.Arrays;

public class InputToName {

    private final String Separator = ",";
    private final int MaxNameLength = 5;

    private final ArrayList<String> nameList;

    public InputToName(String input) {
        String[] inputArray = input.split(Separator);
        nameList = new ArrayList<>(Arrays.asList(inputArray));
        validateCarNameSize(nameList);
    }

    public ArrayList<String> getNameList() {
        return nameList;
    }

    private void validateCarNameSize(ArrayList<String> NameList) {
        for (String Name : NameList) {

            if (Name.length() > MaxNameLength)
                throw new IllegalArgumentException("자동차 이름 5자 이하 가능");

            if (Name.isEmpty())
                throw new IllegalArgumentException("공백 불가");
        }
    }
}
