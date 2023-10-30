package service;

import controller.Controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class GameResult {

    private final ArrayList<String> winnersList = new ArrayList<>();

    public ArrayList<String> getWinnersList() {
        return winnersList;
    }

    public void setWinnersList() {
        List<Map.Entry<String, String>> carIdxNamePosList = sortCarIdxNamePosListByPosLen();

        int longestPos = setLongestPos(carIdxNamePosList);

        // 길이가 가장 긴 pos와 같은 car들이 winners에 해당한다. (winner가 여려명일 수 있기 때문이다.)
        for (Map.Entry<String, String> car : carIdxNamePosList) {
            String name = car.getKey();
            String position = car.getValue();

            if (position.length() != longestPos) {
                break;
            }

            winnersList.add(name);
        }
    }

    private List<Map.Entry<String, String>> sortCarIdxNamePosListByPosLen() {
        List<Map.Entry<String, String>> carIdxNamePosList = Controller.gameManager.getCarIdxNamePosList();
        carIdxNamePosList.sort(Comparator.comparing(e -> e.getValue().length(),
                Comparator.reverseOrder()));

        return carIdxNamePosList;
    }

    private int setLongestPos(List<Map.Entry<String, String>> carIdxNamePosList) {
        return carIdxNamePosList.get(0).getValue().length();
    }

    public void cleanup() {
        winnersList.clear();
    }
}
