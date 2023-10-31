package racingcar.view;

import racingcar.constant.GameMessage;
import racingcar.domain.*;

public class OutputView {
    public void printResultMsg() {
        System.out.println(GameMessage.GAME_RESULT_MESSAGE);
    }

    public void printWinner(String winner) {
        System.out.printf(GameMessage.GAME_WINNER_MESSAGE, winner);
    }

    // 전체 레이스 결과 출력
    public void printRaceResult(AllRaceRecords allRecords, MoveCnt moveCnt) {
        for (int i = 0; i < moveCnt.getMoveCnt(); i++) {
            printEachRaceResult(allRecords, i);
        }
    }

    // seq번째 레이스 결과 출력
    public void printEachRaceResult(AllRaceRecords allRecords, int seq) {
        for (RaceRecord record : allRecords) {
            printEachRaceCarResult(record, seq);
        }
        System.out.println();
    }

    // seq번째 레이스의 자동차 위치 출력
    public void printEachRaceCarResult(RaceRecord record, int seq) {
        Car car = record.getCar();
        int dist = record.getRaceResult().get(seq);

        System.out.printf(GameMessage.EACH_MOVE_RESULT_MESSAGE, car.getName(),
                GameMessage.DASH.repeat(dist));
    }
}
