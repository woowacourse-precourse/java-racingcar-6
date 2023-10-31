package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Judgment;

public class Application {
    public static void main(String[] args) {
        List<Car> entry = registerEntry();
        int lapCount = askRaceLaps();

        Judgment judgment = new Judgment();
        System.out.println("실행 결과");
        for (int i = 0; i < lapCount; i++) {
            judgment.decideMovement(entry);
            printLapDetails(entry);
        }

        List<String> winnerList = announceWinner(entry);
        System.out.println("최종 우승자 : " + String.join(", ", winnerList));
    }

    public static List<Car> registerEntry() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String nameString = Console.readLine();
        String[] nameArray = nameString.split(",");
        List<Car> entry = new ArrayList<>();
        for (String name : nameArray) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
            }
            entry.add(new Car(name));
        }
        return entry;
    }

    public static int askRaceLaps() {
        System.out.println("시도할 회수는 몇회인가요?");
        try {
            int laps = Integer.parseInt(Console.readLine());
            if (laps <= 0) {
                throw new IllegalArgumentException("0보다 큰 값을 입력하세요.");
            }
            return laps;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효한 입력값이 아닙니다.");
        }
    }

    public static void printLapDetails(List<Car> entry) {
        for (Car car : entry) {
            car.printDistance();
        }
        System.out.println(); // 공백
    }

    public static List<String> announceWinner(List<Car> entry) {
        List<String> winnerList = new ArrayList<>();
        int max = entry.get(0).distanceMoved;
        for (Car car : entry) {
            if (car.distanceMoved > max) {
                max = car.distanceMoved;
                winnerList.clear();
                winnerList.add(car.getName());
            } else if (car.distanceMoved == max) {
                winnerList.add(car.getName());
            }
        }
        return winnerList;
    }
}
