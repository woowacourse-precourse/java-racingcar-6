package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.domain.Car;

public class InputView {

    public static List<Car> inputCarNames() {
        System.out.println("자동차 이름을 입력하세요 (이름은 쉼표(,)로 구분)");
        String nameString = Console.readLine();

        // TODO: 예외처리

        return null;
    }

    public static int inputAttemptCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        int attemptCount = Integer.parseInt(Console.readLine());

        // TODO: 예외처리

        return attemptCount;
    }
}
