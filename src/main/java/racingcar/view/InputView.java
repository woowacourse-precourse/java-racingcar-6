package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.CarFactory;
import racingcar.exception.InvalidAttemptCountException;
import racingcar.exception.InvalidCarNameException;

public class InputView {

    public static List<Car> inputCarNames() {
        System.out.println("자동차 이름을 입력하세요 (이름은 쉼표(,)로 구분)");
        String name = Console.readLine();

        InvalidCarNameException.validateNameLength(name);
        List<Car> cars = CarFactory.fromNameString(name);
        InvalidCarNameException.validateUniqueNames(cars);

        return cars;
    }

    public static int inputAttemptCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        int attemptCount = InvalidAttemptCountException.parseAttemptCount(Console.readLine());
        InvalidAttemptCountException.validate(attemptCount);
        return attemptCount;
    }
}
