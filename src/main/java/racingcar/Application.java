package racingcar;
 
import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.CarController;
import racingcar.domain.RacingRuleMaker;
import racingcar.domain.ReadRacingResult;

public class Application {

    public static void main(String[] args) {


        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();
        System.out.println("시도할 회수는 몇회인가요?");
        String inputRacingRound = Console.readLine();
        RacingRuleMaker racingRuleMaker = new RacingRuleMaker(carNames, inputRacingRound);

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
