package racingcar;

import java.util.ArrayList;


public class CheckValidation {

    public static ArrayList<String> checkCarName(String input) {
        ArrayList<String> carNameList = new ArrayList<>();
        String[] carNameArr = input.split(",");

        if (carNameArr.length < 2) {
            throw new IllegalArgumentException("최소 입력 개수 오류");
        }

        for (String carName : carNameArr) {
            if (carName.contains(" ")) {
                throw new IllegalArgumentException("공백 입력 오류");
            }
            if (carName.length() > 5) {
                throw new IllegalArgumentException("입력값 길이 오류");
            }
            if (!carNameList.contains(carName)) {
                carNameList.add(carName);
            } else {
                throw new IllegalArgumentException("중복 입력 오류");
            }
        }
        return carNameList;
    }

    public static int checkIfIntAndReturnIntForm(String input) {
        try {
            return Integer.parseInt(input);
        } catch (IllegalArgumentException exception) {
            throw new IllegalArgumentException("입력 오류");
        }
    }
}