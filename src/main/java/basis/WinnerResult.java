package basis;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;

public class WinnerResult {

    public void printWinner(LinkedHashMap<String, String> carNameHashMap) {
        int largestMove = getLargestMove(carNameHashMap);
        List<String> winnerList = getWinnerList(carNameHashMap, largestMove);
        for (int i = 0; i < winnerList.size(); i++) {
            System.out.print(winnerList.get(i));
            if (winnerList.size() > 1) {
                System.out.print(", ");
            }
        }
    }

    private List<String> getWinnerList(LinkedHashMap<String, String> carNameHashMap, int largestMove) {
        List<String> winnerList = new ArrayList<>();
        for (Entry<String, String> element : carNameHashMap.entrySet()) {
            int moveLength = element.getValue().length();
            if (moveLength == largestMove) {
                winnerList.add(element.getKey());
            }
        }
        return winnerList;
    }

    private int getLargestMove(LinkedHashMap<String, String> carNameHashMap) {
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