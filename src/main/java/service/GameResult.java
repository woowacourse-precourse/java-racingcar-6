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
        List<Map.Entry<String, String>> carIdxNamePosList = Controller.gameManager.getCarIdxNamePosList();
        carIdxNamePosList.sort(Comparator.comparing(e -> e.getValue().length(),
                Comparator.reverseOrder()));

        int longestMove = carIdxNamePosList.get(0).getValue().length();

        for (Map.Entry<String, String> car : carIdxNamePosList) {
            String name = car.getKey();
            String position = car.getValue();

            if (position.length() != longestMove) {
                break;
            }

            winnersList.add(name);
        }
    }
}
