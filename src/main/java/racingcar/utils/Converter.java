package racingcar.utils;

import java.util.ArrayList;

public class Converter {
    public static ArrayList<String> convertStringToList(String carsName) {
        String[] carsNameArray = carsName.split(",");
        ArrayList<String> carsNameList = new ArrayList<>();
        for (String carName : carsNameArray) {
            carsNameList.add(carName);
        }
        return carsNameList;
    }

    public static int convertStringToInt(String inputTrialNumber) {
        int trialNumber;
        try {
            trialNumber = Integer.parseInt(inputTrialNumber);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("숫자를 입력해주세요");
        }
        return trialNumber;
    }
}
