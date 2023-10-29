package racingcar;

import racingcar.Entity.Snapshot;
import racingcar.Entity.Stadium;

public class Application {
    public static void main(String[] args) {
        // 차 목록, 시도 횟수 입력 받기
        Stadium stadium = new Stadium();
        stadium.inputCars();
        stadium.inputTryCount();

        // 경기 진행
        Snapshot snapshot = new Snapshot(stadium.getTryCount());
        for(int order = 1; order <= stadium.getTryCount(); order++){
            stadium.runAllCars();
            snapshot.setSnapshot(order, stadium.getCars());
            snapshot.printSnapshot(order);
        }

        // 최종 결과
        snapshot.printWinner(stadium.getTryCount());
    }
}