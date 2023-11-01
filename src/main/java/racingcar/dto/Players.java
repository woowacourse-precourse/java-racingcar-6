package racingcar.dto;

import java.util.ArrayList;
import java.util.List;

public class Players {

    private List<String> playersList;
    private List<Integer> forwardStepList = new ArrayList<>();


    public List<String> getPlayersList() {
        return playersList;
    }

    public void attemptListInit() {
        playersList.forEach(i -> forwardStepList.add(0));
    }

    public List<Integer> getForwardStepList() {
        return forwardStepList;
    }

    public void moveForwardStep(int index) {
        int fowardStepCount = forwardStepList.get(index);
        forwardStepList.set(index, ++fowardStepCount);
    }

    public Players(List<String> playersList) {
        this.playersList = playersList;
    }

    public int getMaxStep() {
        return forwardStepList.stream().mapToInt(i -> i).max().orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public String toString() {
        String result = "";

        for (int index = 0; index < playersList.size(); index++) {
            result += playersList.get(index) + " : " + "-".repeat(forwardStepList.get(index)) + '\n';
        }

        return result;
    }

}
