package basis;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;

public class WinnerResult {
    public static List<String> getWinnerList(LinkedHashMap<String, String> carNameHashMap, int largestMove) {
        List<String> winnerList = new ArrayList<>();
        for (Entry<String, String> element : carNameHashMap.entrySet()) {
            int moveLength = element.getValue().length();
            if (moveLength == largestMove) {
                winnerList.add(element.getKey());
            }
        }
        return winnerList;
    }

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
