package racingcar;

import racingcar.domain.*;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    private final static String ASK_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final static String ASK_ROUND_MESSAGE = "시도할 회수는 몇회인가요?";

    public static void main(String[] args) {
        List<Car> cars = CarFactory.makeCars(askCarNames());
        Round round = new Round(askRound());

        Participants participants = new Participants(cars);
        Race race = new Race(participants, round);
        race.run();
    }

    public static String askCarNames() {
        System.out.println(ASK_CAR_NAME_MESSAGE);
        return readLine();
    }

    public static String askRound() {
        System.out.println(ASK_ROUND_MESSAGE);
        return readLine();
    }
}
