package basis;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class WinnerResult {
    public static int getLargestMove(LinkedHashMap<String, String> carNameHashMap) {
        int largestMove = 0;
        for (Entry<String, String> element : carNameHashMap.entrySet()) {
            int moveLength = element.getValue().length();
            if (moveLength > largestMove) {
                largestMove = moveLength;
            }
        }
        return largestMove;
    }
}
