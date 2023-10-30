package view;

import controller.RaceController;

import java.util.Map;

public class View {

    public void start() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        RaceController raceController = new RaceController();

        Map<String, Integer> racer = raceController.checkName();

        System.out.println("시도할 회수는 몇회인가요?");
        int attempt = raceController.attemptCount();

        System.out.println("실행 결과");
        for (int i = 0; i < attempt; i++) {
            racer = raceController.raceStart(racer, 1);
        }
    }

}