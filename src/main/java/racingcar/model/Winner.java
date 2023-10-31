package racingcar.model;

import racingcar.domain.*;

import java.util.Map;

public class Winner {
    public String selectWinner(AllRaceRecords allRecords, MoveCnt moveCnt) {
        int max = Integer.MIN_VALUE;
        StringBuilder sb = new StringBuilder();

        for (RaceRecord record : allRecords) {
            String name = record.getCar().getName();
            int dist = record.getRaceResult().get(moveCnt.getMoveCnt() - 1);

            if (dist == max) {
                sb.append(name + ", ");
            } else if (dist > max) {
                max = dist;
                sb.delete(0, sb.length());
                sb.append(name + ", ");
            }
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }
}
