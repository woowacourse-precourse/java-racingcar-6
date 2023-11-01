package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.IntStream;
import racingcar.domain.Car;
import racingcar.domain.Judgment;
import racingcar.domain.NumberGenerator;
import racingcar.domain.Racing;
import racingcar.domain.Referee;
import racingcar.util.CarNames;
import racingcar.util.Cars;
import racingcar.util.PlayRound;

public class Application {
    private static final String PLAY_RESULT = "실행 결과";
    private static final String ASK_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ASK_PLAY_ROUND = "시도할 회수는 몇회인가요?";

    public static void main(String[] args) {
        List<String> carList = askCarName();
        List<Car> racingCars = Cars.createCars(carList);
        Integer playRound = askPlayRound();

        Racing racing = new Racing(racingCars);
        Referee referee = new Referee();
        Judgment judgment = new Judgment();
        NumberGenerator numberGenerator = new NumberGenerator();

        System.out.println("\n" + PLAY_RESULT);
        IntStream.range(0, playRound).forEach(i -> racing.run(judgment, numberGenerator));

        referee.announcementWinners(racingCars);
    }

    private static List<String> askCarName() {
        System.out.println(ASK_CAR_NAME);
        CarNames carList = new CarNames(Console.readLine());
        return carList.extractCarNames();
    }

    private static Integer askPlayRound() {
        System.out.println(ASK_PLAY_ROUND);
        PlayRound playRounds = new PlayRound(Console.readLine());
        return playRounds.extractPlayRound();
    }
}