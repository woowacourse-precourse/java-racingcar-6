package basis;

import static constant.Constant.BLANK;

import io.UserInput;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;

public class WinnerResult {
    UserInput ui = new UserInput();

    public void printWinner(LinkedHashMap<String, String> carNameHashMap) {
        int largestMove = getWinnerMovementCriteria(carNameHashMap);
        List<String> winnerList = getWinnerList(carNameHashMap, largestMove);
        for (int i = 0; i < winnerList.size(); i++) {
            ui.print(winnerList.get(i));
            addCommaIfMultipleWinners(winnerList);
        }
    }

    private void addCommaIfMultipleWinners(List<String> winnerList) {
        if (winnerList.size() > 1) {
            ui.print("," + BLANK);
        }
    }

    private List<String> getWinnerList(LinkedHashMap<String, String> carNameHashMap, int largestMove) {
        List<String> winnerList = new ArrayList<>();
        for (Entry<String, String> element : carNameHashMap.entrySet()) {
            compareElementMoveAndLargestMove(winnerList, element, largestMove);
        }
        return winnerList;
    }

    private void compareElementMoveAndLargestMove(List<String> winnerList, Entry<String, String> element,
                                                  int largestMove) {
        int moveLength = element.getValue().length();
        if (moveLength == largestMove) {
            winnerList.add(element.getKey());
        }
    }

    private int getWinnerMovementCriteria(LinkedHashMap<String, String> carNameHashMap) {
        int largestMove = 0;
        for (Entry<String, String> element : carNameHashMap.entrySet()) {
            int moveLength = element.getValue().length();
            largestMove = findMovementCriteria(moveLength, largestMove);
        }
        return largestMove;
    }

    private static int findMovementCriteria(int moveLength, int currentCriteria) {
        if (moveLength > currentCriteria) {
            currentCriteria = moveLength;
        }
        return currentCriteria;
    }
}