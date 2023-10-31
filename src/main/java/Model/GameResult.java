package Model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class GameResult {

    private final static GameResult instance = new GameResult();

    private GameResult() {
    }

    public static GameResult getInstance() {
        return instance;
    }

    private final ArrayList<String> winnersList = new ArrayList<>();

    private List<Map.Entry<String, String>> sortByPositionLength(List<Map.Entry<String, String>> carIdxNamePosList) {
        carIdxNamePosList.sort(Comparator.comparing(e -> e.getValue().length(), Comparator.reverseOrder()));
        return carIdxNamePosList;
    }

    public void setWinnersList(List<Map.Entry<String, String>> carIdxNamePosList) {
        List<Map.Entry<String, String>> sortedCarIdxNamePosListByPosLen = sortByPositionLength(carIdxNamePosList);

        int longestPos = setLongestPos(carIdxNamePosList);

        // 길이가 가장 긴 pos와 같은 car들이 winners에 해당한다. (winner가 여려명일 수 있기 때문이다.)
        for (Map.Entry<String, String> car : sortedCarIdxNamePosListByPosLen) {
            String name = car.getKey();
            String position = car.getValue();

            if (position.length() != longestPos) {
                break;
            }

            winnersList.add(name);
        }
    }

    private int setLongestPos(List<Map.Entry<String, String>> carIdxNamePosList) {
        return carIdxNamePosList.get(0).getValue().length();
    }

    public ArrayList<String> getWinnersList() {
        return winnersList;
    }

    public void cleanup() {
        winnersList.clear();
    }
}
