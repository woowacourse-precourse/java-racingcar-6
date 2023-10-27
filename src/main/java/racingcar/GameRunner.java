package racingcar;

import racingcar.dto.InputDTO;
import racingcar.view.InputView;

public class GameRunner {

    public static void playGame() {

        InputDTO inputDTO = InputView.readUserInput();
        Cars cars = Cars.createCars(inputDTO.names());

        System.out.println("\n실행 결과");
        for (int i = 0; i < inputDTO.trialCount(); i++) {
            cars.calculateMoveCount();
            System.out.println();
        }

        System.out.print("최종 우승자 : ");
        System.out.println(String.join(", ", cars.getWinner()));
    }
}
