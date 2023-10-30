package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

public class Output {

    public static void printInputCarNameInstruction() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void printExecutionCountQuestion() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void printIntroductionOfResult() {
        System.out.println("실행 결과");
    }

    public static void printResultOfEachExecution(List<Car> carList) {

        for (Car car : carList) {
            String driveTrace = "";
            for (int i = 0; i < car.getLocation(); i++) {
                driveTrace += "-";
            }
            System.out.printf("%s : %s\n", car.getName(), driveTrace);
        }
        System.out.println();
    }

    public static void printWinners(List<Car> winners) {
        System.out.print("최종 우승자 : ");
        for (int i = 0; i < winners.size(); i++) {
            // 마지막 요소인 경우 콤마(,)생략
            if (i == winners.size() - 1) {
                System.out.print(winners.get(i).getName());
            } else {
                System.out.printf("%s, ", winners.get(i).getName());
            }
        }
    }
}
