package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

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
        io.outputIntro();
        for (int i = 0; i < number; i++) {
            for (int j = 0; j < nameMap.size(); j++) {
                judge(nameArr[j], nameMap);
            }
            io.outputStatus(nameArr, nameMap);
        }
        io.outputResult(findMaxVal(nameMap), nameArr, nameMap);
    }

    public void judge(String name, Map<String, Integer> nameMap) {
        int random = Randoms.pickNumberInRange(0, 9);
        if (random >= 4) {
            nameMap.replace(name, nameMap.get(name) + 1);
        }
    }

    public int findMaxVal(Map<String, Integer> map) {
        Optional<Map.Entry<String, Integer>> maxEntry = map.entrySet().stream()
                .max(Map.Entry.comparingByValue());
        if (maxEntry.isPresent()) {
            Map.Entry<String, Integer> entry = maxEntry.get();
            return entry.getValue();
        } else {
            throw new IllegalArgumentException();
        }
    }
}
