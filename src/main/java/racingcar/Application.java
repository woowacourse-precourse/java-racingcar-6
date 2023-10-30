package racingcar;
 
import racingcar.domain.CarController;
import racingcar.domain.RacingRuleMaker;
import racingcar.domain.ReadRacingResult;

public class Application {

    public static void main(String[] args) {

        RacingRuleMaker racingRuleMaker = new RacingRuleMaker();
        CarController carController = new CarController(racingRuleMaker.getCars());
        ReadRacingResult readRacingResult = new ReadRacingResult();

        System.out.println("\n실행 결과");
        for (int roundCount = 0; roundCount < racingRuleMaker.getAllRoundCount(); roundCount++) {
            carController.gameStart();
            readRacingResult.readHashMap(carController.racingResult);

        }
        readRacingResult.judgmentWinner(carController.racingResult);
    }
}
