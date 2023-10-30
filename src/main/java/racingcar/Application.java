package racingcar;

import static racingcar.util.MessageFormatter.*;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.IntStream;
import racingcar.domain.Car;
import racingcar.domain.Racing;
import racingcar.domain.Referee;
import racingcar.util.Cars;

public class Application {

    public static void main(String[] args) {
        List<String> carList = askCarName();
        List<Car> racingCars = Cars.createCars(carList);
        int playRound = askPlayRound();

        Racing racing = new Racing(racingCars);
        System.out.println(PLAY_RESULT);
        IntStream.range(0, playRound).forEach(i -> racing.run());

        Referee referee = new Referee();
        referee.announcementWinners(racingCars);
    }

    public static List<String> askCarName() {
        System.out.println(ASK_CAR_NAME);
        String getCar = Console.readLine();
        List<String> splitAnswerName = List.of(getCar.split(COMMA_DELIMITER));
        if (!nameLengthCheck(splitAnswerName)) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
        return splitAnswerName;
    }

    public static int askPlayRound() {
        System.out.println(ASK_PLAY_ROUND);
        String getTurn = Console.readLine();
        if (getTurn.equals("0") || !isValidData(getTurn)) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
        return Integer.parseInt(getTurn);
    }

    private static boolean isValidData(final String getTurn) {
        return getTurn.matches(NUMBER_PATTERN);
    }

    private static boolean nameLengthCheck(List<String> name) {
        return name.stream().allMatch(n -> n.length() <= 5);
    }
}
