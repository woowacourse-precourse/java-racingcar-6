package racingcar.model;

import java.util.HashMap;
import java.util.List;

public class GameMember {
    private List<String> carPlayers;

    private HashMap<String, String> hs;

    private int tryNum;

    public HashMap<String, String> getHs() {
        return hs;
    }

    public void setHs(List<String> carPlayers) {
        HashMap<String, String> hs = new HashMap<>();
        for (String key : carPlayers) {
            hs.put(key, "");
        }
        this.hs = hs;
    }

    public void setDuringGame(String playerName) {
        String beforeRecord = hs.get(playerName);
        hs.put(playerName, beforeRecord + "-");
    }

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
