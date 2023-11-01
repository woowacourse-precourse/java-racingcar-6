package racingcar.service.winner;

import java.util.List;
import java.util.stream.IntStream;

public class WinnerSelector {
    public static List<String> getWinners(int maxCount, String[] names, int[] countsByName) {
        return IntStream.range(0, names.length)
                .filter(i -> countsByName[i] == maxCount)
                .mapToObj(i -> names[i])
                .toList();
    }
}
