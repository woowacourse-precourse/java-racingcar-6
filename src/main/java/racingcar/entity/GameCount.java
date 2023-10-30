package racingcar.entity;


import racingcar.generator.ListLengthGenerator;

import java.util.ArrayList;
import java.util.List;

import static racingcar.entity.Participantes.InputParticipantes;

public class GameCount {
    public List<String> participantes;
    public List<Integer> wincount = new ArrayList<>();

    public GameCount(List<String> participantes) {

        this.participantes = new ArrayList<>(participantes);
    }

    public void MakeWinCountList() {
        for (int i = 0; i < participantes.size(); i++) {
            wincount.add(0);
        }
    }

    public List<Integer> getWincount() {
        MakeWinCountList();
        return wincount;
    }
}




