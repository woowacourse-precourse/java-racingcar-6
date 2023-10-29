package racingcar.domain;

import java.util.ArrayList;
import java.util.LinkedHashMap;
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
        int maxValue = 0;
        for (String value : getCarList().values()) {
            if (value.length() > maxValue) {
                maxValue = value.length();
            }
        }

        for (String key : getCarList().keySet()) {
            if (getCarList().get(key).length() == maxValue) {
                winnerList.add(key);
            }
        }

        String winners = String.join(", ", winnerList);

        return winners;
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
            if (key.charAt(getCarList().size() - 1) == ' ') {
                throw new IllegalArgumentException("자동차의 이름의 마지막 글자에 띄어쓰기가 있습니다");
            }
        }
    }

    public void checkContainsConsecutiveCommas() {
        Pattern pattern = Pattern.compile(",,+");
        Matcher matcher = pattern.matcher(stringCarList);

        if (matcher.find()) {
            throw new IllegalArgumentException("연속적인 쉼표가 발견되었습니다.");
        }
    }
}
