package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.controller.RacingGameController;
import racingcar.dto.UserRequestDTO;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        UserRequestDTO userInputDTO = getUserInput();

        RacingGameController racingGameController = new RacingGameController();
        racingGameController.gameStart(userInputDTO);
    }

    private static UserRequestDTO getUserInput() {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();
        System.out.println("시도할 회수는 몇회인가요?");
        String tryNum = Console.readLine();

        return new UserRequestDTO(carNames, tryNum);
    }
}
