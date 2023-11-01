package racingcar;

import java.util.ArrayList;
import java.util.HashMap;

public class NameMap {
    private HashMap<Integer, String> nameMap;

    public NameMap(ArrayList<String> names, ArrayList<Integer> numbers) {
        if (names.size() != numbers.size()) {
            throw new IllegalArgumentException("Names and numbers lists must have the same size.");
        }

        this.nameMap = new HashMap<>();

        for (int i = 0; i < numbers.size(); i++) {
            this.nameMap.put(numbers.get(i), names.get(i));
        }
    }

    public HashMap<Integer, String> getNameMap() {
        return nameMap;
    }
}
