package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.util.TypeConvertor;

public class InputView {
    private static final String CAR_NAME_INPUT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String MOVE_CNT_INPUT = "시도할 회수는 몇회인가요?";

    private final TypeConvertor typeConvertor;

    public InputView(TypeConvertor typeConvertor) {
        this.typeConvertor = typeConvertor;
    }

    public RacingGame getRacingGame() {
        System.out.println(CAR_NAME_INPUT);
        String input = Console.readLine();
        List<Car> cars = typeConvertor.converStringToCarList(input);
        return new RacingGame(cars);
    }

    public Long getMoveCount() {
        System.out.println(MOVE_CNT_INPUT);
        String input = Console.readLine();
        return typeConvertor.convertStringToLong(input);
    }
}
