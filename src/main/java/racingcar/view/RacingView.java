package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.dto.RacingData;

public class RacingView {

    private RacingView() {
    }

    public static RacingView getInstance() {
        return RacingView.LazyHolder.INSTANCE;
    }

    private static class LazyHolder {
        private static final RacingView INSTANCE = new RacingView();
    }

    public RacingData initIO() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] names = Console.readLine().split(",( )*");
        System.out.println("시도할 회수는 몇회인가요?");
        int count = Integer.parseInt(Console.readLine());
        System.out.println("\n실행 결과");

        return new RacingData(names, count);
    }

    public void printResult(List<String> names) {
        String namesString = String.join(", ", names);
        System.out.printf("최종 우승자 : %s", namesString);
    }
}
