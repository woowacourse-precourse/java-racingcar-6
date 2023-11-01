package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.CarFactory;
import racingcar.exception.InvalidAttemptCountException;
import racingcar.exception.InvalidCarNameException;
import racingcar.utils.AttemptCountParser;

/**
 * <p>사용자 입력을 담당하는 뷰 클래스입니다.</p>
 *
 * <p>이 클래스는 사용자로부터 자동차 이름과 시도할 횟수를 입력받는 기능을 제공합니다.</p>
 */
public class InputView {

    /**
     * <p>사용자로부터 자동차 이름을 입력받습니다.</p>
     *
     * <p>입력받은 자동차 이름은 쉼표(,)로 구분되며, 각 이름은 {@link CarFactory#fromNameString(String)}
     * 메서드를 통해 자동차 객체로 변환됩니다. 유효하지 않은 자동차 이름에 대해서는 {@link InvalidCarNameException#validate(List)}를
     * 통해 예외 처리됩니다.</p>
     *
     * @return 사용자로부터 입력받은 자동차 이름에 대한 {@link Car} 객체 리스트
     */
    public static List<Car> inputCarNames() {
        System.out.println("자동차 이름을 입력하세요 (이름은 쉼표(,)로 구분)");
        List<Car> cars = CarFactory.fromNameString(Console.readLine());
        InvalidCarNameException.validate(cars);
        return cars;
    }

    /**
     * <p>사용자로부터 시도할 횟수를 입력받습니다.</p>
     *
     * <p>유효하지 않거나 양수가 아닌 값에 대한 처리는 {@link InvalidAttemptCountException}에서 합니다.</p>
     *
     * @return 사용자로부터 입력받은 시도할 횟수
     */
    public static int inputAttemptCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        int attemptCount = AttemptCountParser.parseAttemptCount(Console.readLine());
        InvalidAttemptCountException.validate(attemptCount);
        return attemptCount;
    }
}
