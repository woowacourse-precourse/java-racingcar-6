package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.RacingCar;
import racingcar.utils.CarNameValidation;
import racingcar.utils.MovementValidation;

import java.util.List;

public class InputView {

    private CarNameValidation carNameValidation;

    private MovementValidation movementValidation;

    private final String START_SENTENCE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    private final String MOVEMENT_SENTENCE = "시도할 회수는 몇회인가요?";

    public InputView() {
        carNameValidation = new CarNameValidation();
        movementValidation = new MovementValidation();
    }

    public List<RacingCar> inputCarName() {
        System.out.println(START_SENTENCE);
        String inputCarName = Console.readLine();
        carNameValidation.validateUserInput(inputCarName);

        return RacingCar.fromInputCarName(inputCarName);
    }

    public Integer inputMovement() {
        try {
            System.out.println(MOVEMENT_SENTENCE);
            Integer movement = Integer.parseInt(Console.readLine());
            movementValidation.validateMovement(movement);

            return movement;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("공백이나 문자열을 입력할 수 없습니다.");
        }
    }
}
