package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashMap;
import java.util.Map;

public class Game {
    private final IO io = new IO();

    public void start() {
        String[] nameArr = io.inputName();
        Map<String, Integer> nameMap = arrToMap(nameArr);
        int number = io.inputNumber();
        logic(nameArr, nameMap, number);
    }

    public Map<String, Integer> arrToMap(String[] arr) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : arr) {
            map.put(s, 0);
        }
        return map;
    }

    public void logic(String[] nameArr, Map<String, Integer> nameMap, int number) {
        int len = nameMap.size();
        for (int i = 0; i < number; i++) {
            for (int j = 0; j < len; j++) {
                judge(nameArr[j], nameMap);
            }
            //output
        }
    }

    public void judge(String name, Map<String, Integer> nameMap) {
        int random = Randoms.pickNumberInRange(0, 9);
        if (random >= 4) {
            go(name, nameMap);
        }
    }

    public void go(String name, Map<String, Integer> nameMap) {
        nameMap.replace(name, nameMap.get(name) + 1);
    }
}
