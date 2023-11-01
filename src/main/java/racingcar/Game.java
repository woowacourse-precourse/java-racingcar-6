package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Game {
    private final static String INPUT_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final static String INPUT_TIME_MESSAGE = "시도할 회수는 몇회인가요?";

    public void run() {
        Cars cars = new Cars();
        Time time = new Time();

        System.out.println(INPUT_NAME_MESSAGE);
        cars.inputCarName(readLine());
        System.out.println(INPUT_TIME_MESSAGE);
        time.inputTime(readLine());
        time.moveCarsByTime(cars);
        cars.printWinner();
    }
}