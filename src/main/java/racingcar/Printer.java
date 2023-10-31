package racingcar;

import java.util.List;
import racingcar.domain.Unchangeable;

public class Printer {
    private static final String REQUEST_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String REQUEST_TRIAL = "시도할 회수는 몇회인가요?";
    private static final String RESULT = "실행 결과";

    public void requestNames() {
        System.out.println(REQUEST_NAMES);
    }

    public void requestTrial() {
        System.out.println(REQUEST_TRIAL);
    }

    public void resultMessage() {
        System.out.println();
        System.out.println(RESULT);
    }

    public void gameResult(List<Unchangeable> carList) {
        for (Unchangeable car : carList) {
            System.out.println(car);
        }
        System.out.println();
    }

    public void winner(String winners) {
        System.out.print("최종 우승자 : " + winners);
    }
}

