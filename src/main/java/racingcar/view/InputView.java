package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.RacingCar;
import racingcar.utils.CarNameValidation;
import racingcar.utils.MovementValidation;

import java.util.List;

import static racingcar.message.IllegalArgumentExceptionMessage.NULL_OR_STRING_MESSAGE;

public class InputView {

    public static final String START_SENTENCE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    public static final String MOVEMENT_SENTENCE = "시도할 회수는 몇회인가요?";

    private CarNameValidation carNameValidation;

    private MovementValidation movementValidation;

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
            throw new IllegalArgumentException(NULL_OR_STRING_MESSAGE);
        }
    }
}
