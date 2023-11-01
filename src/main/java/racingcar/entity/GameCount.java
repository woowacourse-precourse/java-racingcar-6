package racingcar.entity;

import java.util.ArrayList;
import java.util.List;

public class GameCount {
    public List<String> participantes;
    public List<Integer> wincount = new ArrayList<>();

    public GameCount(List<String> participantes) {

        this.participantes = new ArrayList<>(participantes);
    }

    public void makeWinCountList() {
        for (int i = 0; i < participantes.size(); i++) {
            wincount.add(0);
        }
    }

    public List<Integer> getWincount() {
        makeWinCountList();
        return wincount;
    }
}




