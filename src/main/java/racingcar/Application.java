package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.domain.Car;
import racingcar.util.CarFactory;

public class Application {
    public static void main(String[] args) {
        List<String> carList = askCarName();
        List<Car> racingList = CarFactory.createCars(carList);
        int playRound = askPlayTurn();
    }

    public static List<String> askCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String getCar = Console.readLine();
        return List.of(getCar.split(","));
    }

    public static int askPlayTurn() {
        System.out.println("시도할 회수는 몇회인가요?");
        String getTurn = Console.readLine();
        if (!isValidData(getTurn)){
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
        return Integer.parseInt(getTurn);
    }

    private static boolean isValidData(final String getTurn) {
        return getTurn.matches("[1-9]+");
    }

    public static void announcementWinners() {

    }
}
