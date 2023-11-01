
package racingcar.domain;

import java.util.Map;

public class MoveContainer {
    private final Map<String, Integer> numMoveMap;

    public MoveContainer(Map<String, Integer> numMoveMap) {
        this.numMoveMap = numMoveMap;
    }

    public Map<String, Integer> getNumMoveMap() {
        return numMoveMap;
    }
}