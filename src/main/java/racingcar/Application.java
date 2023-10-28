package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // 차 목록, 시도 횟수 입력 받기
        Stadium stadium = new Stadium();
        stadium.saveInputCars(stadium.inputCars());
        stadium.saveTryCount(stadium.inputTryCount());

        // 경기 진행
        for(int order=0; order< stadium.getTryCount(); order++){
            stadium.runAllCars();
        }

    }
}
