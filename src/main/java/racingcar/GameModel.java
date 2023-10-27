package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;

public class GameModel {
    private int generateRandomNumber() {
        return Randoms.pickNumberInRange(Constants.MIN, Constants.MAX);
    }

    private boolean decideGoAndStop() {
        if (generateRandomNumber() >= Constants.CRITICAL_NUMBER) {
            return true;
        }
        return false;
    }

    public ArrayList<String> decideFinalWinner(ArrayList<Cars> players) {
        ArrayList<String> winners = new ArrayList<>();
        int maxDistance = -1;
        for (Cars player : players) {
            int distance = player.askDistance();
            if (distance > maxDistance) {
                maxDistance = distance;
                winners.clear();
                winners.add(player.getName());
            } else if (distance == maxDistance) {
                winners.add(player.getName());
            }
        }
        return winners;
    }

    public void tryOneCycle(ArrayList<Cars> players) {
        for (Cars player : players) {
            if (decideGoAndStop()) {
                player.goOneStep();
            }
        }
    }

}
