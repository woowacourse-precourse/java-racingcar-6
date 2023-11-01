package racingcar;


import camp.nextstep.edu.missionutils.Console;
import racingcar.car.CarRegistration;
import racingcar.race.RoundCount;
import racingcar.race.Race;
import racingcar.race.rule.RandomRaceRule;

public class Application {

    private static final String START_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String MOVE_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String RESULT_MESSAGE = "실행 결과";

    private static final int MOVABLE_LIMIT = 3;
    private static final int MIN_RANDOM_RANGE_NUMBER = 0;
    private static final int MAX_RANDOM_RANGE_NUMBER = 9;

    public static void main(String[] args) throws IllegalArgumentException {
        try {
            System.out.println(START_MESSAGE);
            String names = Console.readLine();
            CarRegistration carRegistration = new CarRegistration(names);

            System.out.println(MOVE_COUNT_MESSAGE);
            String line = Console.readLine();
            RoundCount roundCount = new RoundCount(line);

            Race race = new Race(carRegistration, roundCount,
                    new RandomRaceRule(MOVABLE_LIMIT, MIN_RANDOM_RANGE_NUMBER, MAX_RANDOM_RANGE_NUMBER));
            System.out.println(RESULT_MESSAGE);
            race.start();

        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        } finally {
            Console.close();
        }
    }
}
