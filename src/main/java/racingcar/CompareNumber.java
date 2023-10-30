package racingcar;

import java.util.HashMap;
import java.util.ArrayList;

public class CompareNumber {
    private HashMap<Integer, String> nameMap;
    private ArrayList<String> maxNames;

    public CompareNumber(HashMap<Integer, String> nameMap) {
        this.nameMap = nameMap;
        this.maxNames = new ArrayList<>();
    }

    public void compare() {
        // 가장 큰 숫자를 찾습니다.
        int maxNumber = -1;
        for (Integer number : nameMap.keySet()) {
            if (number > maxNumber) {
                maxNumber = number;
            }
        }

        // 가장 큰 숫자에 대응하는 모든 이름을 찾아 리스트에 저장합니다.
        for (Integer number : nameMap.keySet()) {
            if (number == maxNumber) {
                maxNames.add(nameMap.get(number));
            }
        }
    }

    public ArrayList<String> getMaxNames() {
        return maxNames;
    }
}
