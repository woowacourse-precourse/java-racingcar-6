package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.RacingCar;
import racingcar.service.InputValidation;

import java.util.List;

public class InputView {

    private InputValidation inputValidation;

    public InputView() {
        inputValidation = new InputValidation();
    }

    public List<RacingCar> inputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputCarName = Console.readLine();
        inputValidation.validateUserInput(inputCarName);

        return RacingCar.fromInputCarName(inputCarName);
    }

    public Integer inputMovement() {
        try {
            System.out.println("시도할 회수는 몇회인가요?");
            Integer movement = Integer.parseInt(Console.readLine());
            inputValidation.validateMovement(movement);

            return movement;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("문자열을 입력할 수 없습니다.");
        }
    }
}
