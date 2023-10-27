package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Game {
    private final IO io;

    public Game(IO io) {
        this.io = io;
    }

    public void start() {
        String[] nameArr = io.inputCarNames();
        Map<String, Integer> nameMap = generateMapFromArray(nameArr);
        int number = io.inputNumberOfAttempts();
        run(nameArr, nameMap, number);
    }

    public Map<String, Integer> generateMapFromArray(String[] arr) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : arr) {
            map.put(s, 0);
        }
        return map;
    }

    public void run(String[] nameArr, Map<String, Integer> nameMap, int number) {
        io.outputResultIntroduction();
        for (int i = 0; i < number; i++) {
            for (int j = 0; j < nameMap.size(); j++) {
                determineCarMove(nameArr[j], nameMap);
            }
            io.outputRacingStatus(nameArr, nameMap);
        }
        io.outputResult(findMaxValueInMap(nameMap), nameArr, nameMap);
    }

    public void determineCarMove(String name, Map<String, Integer> nameMap) {
        int random = Randoms.pickNumberInRange(0, 9);
        if (random >= 4) {
            nameMap.replace(name, nameMap.get(name) + 1);
        }
    }

    public int findMaxValueInMap(Map<String, Integer> map) {
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
