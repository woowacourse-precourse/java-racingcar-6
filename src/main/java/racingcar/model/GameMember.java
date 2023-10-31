package racingcar.model;

import java.util.List;

public class GameMember {
    private List<String> carPlayers;

    private int tryNum;

    public int getTryNum() {
        return tryNum;
    }

    public void setTryNum(int tryNum) {
        this.tryNum = tryNum;
    }

    public void setCarPlayers(List<String> carPlayers) {
        this.carPlayers = carPlayers;
    }

    public List<String> getCarPlayers() {
        return carPlayers;
    }


}
