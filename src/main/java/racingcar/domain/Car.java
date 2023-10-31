package racingcar.domain;

import java.util.LinkedHashMap;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Car {

    private String stringCarList;
    private LinkedHashMap<String, String> carList;

    public String getStringCarList() {
        return stringCarList;
    }

    public void setStringCarList(String stringCarList) {
        this.stringCarList = stringCarList;
    }

    public LinkedHashMap<String, String> getCarList() {
        return carList;
    }

    public void setCarList(LinkedHashMap<String, String> carList) {
        this.carList = carList;
    }

    public void getCurrentRacingResult() {
        getCarList().forEach((key, value) -> {
            System.out.println(key + " :" + " " + value);
        });
    }

    public String getFinalWinner() {
        ArrayList<String> winnerList = new ArrayList<>();

        for (String carName : getCarList().keySet()) {
            if (getCarList().get(carName).length() == findMaxMoveValueFromCarList()) {
                winnerList.add(carName);
            }
        }

        return String.join(", ", winnerList);
    }

    public Integer findMaxMoveValueFromCarList() {
        int maxMoveValue = 0;

        for (String moveValue : getCarList().values()) {
            if (moveValue.length() > maxMoveValue) {
                maxMoveValue = moveValue.length();
            }
        }

        return maxMoveValue;
    }

    public void checkCarNameLength() {
        for (String key : getCarList().keySet()) {
            if (key.length() > 5) {
                throw new IllegalArgumentException("각 자동자의 이름은 5자 이하여야만 합니다.");
            }
        }
    }

    public void checkCarNameFirstLetterIsSpace() {
        for (String key : getCarList().keySet()) {
            if (key.charAt(0) == ' ') {
                throw new IllegalArgumentException("자동차의 이름의 첫 글자에 띄어쓰기가 있습니다");
            }
        }
    }

    public void checkCarNameLastLetterIsSpace() {
        for (String key : getCarList().keySet()) {
            if (key.charAt(key.length() - 1) == ' ') {
                throw new IllegalArgumentException("자동차의 이름의 마지막 글자에 띄어쓰기가 있습니다");
            }
        }
    }

    public void checkInputStringContainsConsecutiveCommas() {
        Pattern pattern = Pattern.compile(",,+");
        Matcher matcher = pattern.matcher(getStringCarList());

        if (matcher.find()) {
            throw new IllegalArgumentException("연속적인 쉼표가 발견되었습니다.");
        }
    }

    public void checkInputStringFirstLetterContainsCommas() {
        if (getStringCarList().charAt(0) == ',') {
            throw new IllegalArgumentException("문자열의 첫 글자가 쉼표입니다 확인해주세요");
        }
    }

    public void checkInputStringLastLetterContainsCommas() {
        if (getStringCarList().charAt(getStringCarList().length() - 1) == ',') {
            throw new IllegalArgumentException("문자열의 마지막 글자가 쉼표입니다 확인해주세요");
        }
    }
}