package racingcar.service.movement;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.stream.IntStream;

public class RacingCarController {
    public static boolean isMoveForward() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }
    public static void moveCars(int[] countsByName) {
        IntStream.range(0, countsByName.length).filter(t -> isMoveForward()).forEach(t -> countsByName[t]++);
    }
}
