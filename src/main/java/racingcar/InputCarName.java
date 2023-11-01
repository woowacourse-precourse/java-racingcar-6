package racingcar;

import java.util.ArrayList;
import java.util.List;

public class InputCarName {
    public List<Integer> makeTrack(int carCount) {
        List<Integer> track = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            track.add(0);
        }
        return track;
    }
}

