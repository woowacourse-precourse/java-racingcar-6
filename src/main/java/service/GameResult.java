package service;


import controller.Controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;

public class GameResult {

    public ArrayList<String> winnersList = new ArrayList<>();

    public void chkWinners() {
        Controller.gameManager.carIdxNamePosList.sort(Comparator.comparing(e -> e.getValue().length(),
                Comparator.reverseOrder()));

        int longestMove = Controller.gameManager.carIdxNamePosList.get(0).getValue().length();

        for (Map.Entry<String, String> car : Controller.gameManager.carIdxNamePosList) {
            String name = car.getKey();
            String position = car.getValue();

            if (position.length() != longestMove) {
                break;
            }

            winnersList.add(name);
        }
    }
}
