package racingcar.Model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import racingcar.Constants;

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

    /**
     * Cars 객체에서 askDistance로 길이를 반환받은 후 가장 먼 거리를 나아간 객체의 이름을 getName으로 반환받아서 ArrayList로 반환하는 메서드입니다. 최초에 maxDistance를
     * 음수로 설정한 후 Cars 객체를 하나씩 순회하면서 가장 긴 거리가 나올때마다 maxDistance를 갱신시킵니다.
     */
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
