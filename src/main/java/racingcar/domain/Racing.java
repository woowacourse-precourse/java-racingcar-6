package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Racing {
    public List<Integer> play(List<String> cars) {
        List<Integer> playResult = new ArrayList<>();
        Selector selector = new Selector();
        for (int i = 0; i < cars.size(); i++) {
            String goOrStop = selector.whetherToGo();
            if (goOrStop.equals("전진")) {
                playResult.add(1);
            } else {
                playResult.add(0);
            }
        }
        return playResult;
    }
}
