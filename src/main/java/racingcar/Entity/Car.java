package racingcar.Entity;

import racingcar.constant.CarStatus;
import racingcar.constant.SymbolType;

public class Car {
    private String name;    // 자동차 이름
    private StringBuilder nowMoveTrace; // 현재 까지의 이동 경로 StringBuilder
    private int moveCount;  // 총 이동 횟수

    public Car(String name, StringBuilder nowMoveTrace, int moveCount) {
        this.name = name;
        this.nowMoveTrace = nowMoveTrace;
        this.moveCount = moveCount;
    }

    public void setNowMoveTrace(CarStatus status) {
        if (status.equals(CarStatus.MOVE)) {
            nowMoveTrace.append(SymbolType.TRACE_RACE_RESULT.getValue());
        }
    }

    public void setMoveCount(CarStatus status) {
        if (status.equals(CarStatus.MOVE)) {
            moveCount++;
        }
    }

    public String getName() {
        return name;
    }

    public StringBuilder getNowMoveTrace() {
        return nowMoveTrace;
    }

    public int getMoveCount() {
        return moveCount;
    }
}
