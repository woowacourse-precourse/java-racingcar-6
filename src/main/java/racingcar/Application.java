package racingcar;

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
        List<Car> racingList = Cars.createCars(carList);
        int playRound = askPlayTurn();

        Racing racing = new Racing(racingList);
        System.out.println("실행 결과");
        IntStream.range(0, playRound).forEach(i -> racing.run());

        Referee referee = new Referee();
        referee.announcementWinners(racingList);
    }

    public static List<String> askCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String getCar = Console.readLine();
        List<String> splitAnswerName = List.of(getCar.split(","));
        if (!nameLengthCheck(splitAnswerName)) {
            throw new IllegalArgumentException("유효하지않은 입력입니다.");
        }
        return splitAnswerName;
    }

    public static int askPlayTurn() {
        System.out.println("시도할 회수는 몇회인가요?");
        String getTurn = Console.readLine();
        if (getTurn.equals("0") || !isValidData(getTurn)){
            throw new IllegalArgumentException("유효하지않은 입력입니다.");
        }
        return Integer.parseInt(getTurn);
    }

    private static boolean isValidData(final String getTurn) {
        return getTurn.matches("[0-9]+");
    }

    private static boolean nameLengthCheck(List<String> name) {
        return name.stream().allMatch(n -> n.length() <= 5);
    }
}
