package racingcar.entity;


import java.util.ArrayList;
import java.util.List;

public class GameCount {
    public List<String> participantes = new ArrayList<>();
    public List<Integer> wincount = new ArrayList<>();

    public void MakeWinCountList() {
        for (int i = 0; i < participantes.size(); i++) {
            wincount.add(0);
        }
    }

    public List<Integer> getWincount() {
        return wincount;
    }
}




