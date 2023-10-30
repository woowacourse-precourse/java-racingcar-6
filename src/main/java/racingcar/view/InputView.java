package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.controller.dto.request.CarNameDto;

public class InputView {
    private static final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    public CarNameDto readCarName () {
        System.out.println(INPUT_CAR_NAME_MESSAGE);
        String carName = Console.readLine();

        return new CarNameDto(carName);
    }
}
