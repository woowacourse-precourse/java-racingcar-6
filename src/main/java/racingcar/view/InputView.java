package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import number.RandomNumberPicker;
import racingcar.domain.car.Cars;
import racingcar.domain.move.RandomMovePicker;
import racingcar.domain.racinggame.RacingGame;
import racingcar.domain.round.Round;

public final class InputView {

    public RacingGame inputRacingGame() {
        return RacingGame.of(
                inputCars(),
                inputMaxRound(),
                new RandomMovePicker(
                        new RandomNumberPicker()
                )
        );
    }

    private Cars inputCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Cars.from(readLine());
    }

    private Round inputMaxRound() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Round.from(readLine());
    }

    private String readLine() {
        return Console.readLine().trim();
    }
}
