package racingcar.model;

import racingcar.domain.*;

public class Winner {
    // 자동차별 각 레이스 전체 이동 기록에서 마지막 기록만 비교하여 최종 우승자 선정하는 메서드
    public String selectWinner(AllRaceRecords allRecords, MoveCnt moveCnt) {
        int max = Integer.MIN_VALUE;
        StringBuilder sb = new StringBuilder();

        for (RaceRecord record : allRecords) {
            String name = record.getCar().getName();
            int dist = record.getRaceResult().get(moveCnt.getMoveCnt() - 1);

            if (dist == max) {
                sb.append(name + ", ");
            }
            if (dist > max) {
                max = dist;
                sb.delete(0, sb.length());
                sb.append(name + ", ");
            }
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }
}
