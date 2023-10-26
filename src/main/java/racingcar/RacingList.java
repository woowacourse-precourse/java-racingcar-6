package racingcar;

import java.util.LinkedHashMap;

public class RacingList {

    private final LinkedHashMap<String, Integer> carList = new LinkedHashMap<>();

    public void inputCarList(String input) {
        String[] list = input.split(",");
        for (String s : list) {
            sizeValidate(s);
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
}
