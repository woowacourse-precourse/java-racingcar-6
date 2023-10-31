package racingcar.view;

import racingcar.domain.Racingcar;

import java.util.ArrayList;

public class ResultView {

    // 자동차 이름 입력 안내문 출력
    public void scanRacingcarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    // 시도 회수 입력 안내문 출력
    public void scanTestTimes() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    // 실행 결과 출력
    public void printProcess(ArrayList<Racingcar> racingcarList) {
        for (Racingcar racingcar : racingcarList) {
            System.out.print(racingcar.getName() + " : ");
            System.out.println("-".repeat(racingcar.getMovingforward()));
        }

        System.out.println();
    }

    // 우승자 출력
    public void printWinners(ArrayList<String> winners) {
        System.out.print("최종 우승자 : ");
        for (int i = 0; i < winners.size(); i++) {
            System.out.print(winners.get(i));
            if (i != winners.size() - 1) {
                System.out.print(", ");
            }
        }
    }

}
