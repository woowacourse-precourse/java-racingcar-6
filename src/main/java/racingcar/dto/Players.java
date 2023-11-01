package racingcar.dto;

import java.util.List;

public class Players {

    private List<String> playersList;
    private List<Integer> forwardStepList;


    public List<String> getPlayersList(){
        return playersList;
    }

    public List<Integer> getForwardStepList(){
        return forwardStepList;
    }
    public void moveForwardStep(int index){
        int fowardStepCount = forwardStepList.get(index);
        forwardStepList.set(index, fowardStepCount++);
    }
    public Players(List<String> playersList) {
        this.playersList = playersList;
    }

}
