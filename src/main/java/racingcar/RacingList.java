package racingcar;

import java.util.LinkedHashMap;

public class RacingList {

    private final LinkedHashMap<String, Integer> carList = new LinkedHashMap<>();

    public void initData(String input) {
        String[] list = input.split(",");
        for (String s : list) {
            sizeValidate(s);
            duplicateValidate(s);
            carList.put(s, 0);
        }
    }

    public LinkedHashMap<String, Integer> getCarList() {
        return carList;
    }

    public void sizeValidate(String input) {
        int size = input.length();
        if (size > 5) {
            throw new IllegalArgumentException("이름의 길이가 5 이상입니다.");
        }
    }

    public void duplicateValidate(String input) {
        if (carList.containsKey(input)) {
            throw new IllegalArgumentException("자동차 이름이 중복됩니다.");
        }
    }
}
