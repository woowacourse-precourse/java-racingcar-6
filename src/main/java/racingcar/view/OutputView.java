package racingcar.view;

import racingcar.model.RacingCar;

import java.util.List;

import static racingcar.util.constant.ProductConstant.FINAL_WINNERS;
import static racingcar.util.constant.ProductConstant.FINAL_WINNER_COUNT;
import static racingcar.util.validate.InputValidate.validatePrintWinners;

public class OutputView {

    public void getRaceResult(List<RacingCar> racingCars) {
        for (RacingCar racingCar : racingCars) {
            System.out.println(racingCar.getUsername() + " : " + racingCar.getCurrentLocation());
        }
        System.out.println();
    }

    public void printWinners(List<String> finalWinners) {
        String winners = String.join(", ", finalWinners);
        if(finalWinners.size() > FINAL_WINNER_COUNT) {
            winners = validatePrintWinners(winners);
        }
        System.out.println(FINAL_WINNERS + " : " + winners);
    }
}
