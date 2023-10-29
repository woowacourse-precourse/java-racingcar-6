package racingcar.entity;

import racingcar.generator.ListLengthGenerator;

import java.util.ArrayList;
import java.util.List;

public class GameCount {
    private List<String> participantes = new ArrayList<>();
    private List<Integer> wincount = new ArrayList<>();

    public void MakeWinCountList() {
        int n = ListLengthGenerator.count(participantes);
        for (int i = 0; i < n; i++) {
            wincount.add(0);
        }
    }

    public int getWinCountListSize() {
        return wincount.size();
    }
}
