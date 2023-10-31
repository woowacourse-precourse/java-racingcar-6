package racingcar;


import camp.nextstep.edu.missionutils.Console;

public class Application {

    private static final String START_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String MOVE_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String RESULT_MESSAGE = "실행 결과";

    public static void main(String[] args) throws IllegalArgumentException {
        try {
            System.out.println(START_MESSAGE);
            String names = Console.readLine();
            CarRegistration carRegistration = new CarRegistration(names);

            System.out.println(MOVE_COUNT_MESSAGE);
            String line = Console.readLine();
            MoveCount moveCount = new MoveCount(line);

            Race race = new Race(carRegistration, moveCount);
            System.out.println(RESULT_MESSAGE);
            race.start();

        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        } finally {
            Console.close();
        }
    }
}
