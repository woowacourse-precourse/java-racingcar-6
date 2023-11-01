package racingcar.view;

import racingcar.model.CarAndDistance;
import racingcar.model.CarRankingCalculator;

import static racingcar.utils.GameMessage.WINNER;

public class CarRaceResult {

    public void carRacingWinner(CarAndDistance carAndDistance) {
        CarRankingCalculator carRankingCalculator = new CarRankingCalculator();
        String result = carRankingCalculator.rankingCheck(carAndDistance.getCarAndDistance());
        System.out.println(WINNER + result);
    }
}
