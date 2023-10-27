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
            CarRegistration.input(names);

            System.out.println(MOVE_COUNT_MESSAGE);
            String line = Console.readLine();
            MoveCount moveCount = new MoveCount(line);

            System.out.println(RESULT_MESSAGE);
            // TODO move count 만큼 움직임 실행
            // TODO 결과 출력

        } catch (IllegalArgumentException e) {
            Console.close();
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
