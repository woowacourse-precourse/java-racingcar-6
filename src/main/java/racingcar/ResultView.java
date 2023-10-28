package racingcar;

import java.util.List;

public class ResultView {
    public static void printCarPosition(Car car) {
        System.out.println(car.nameAndPosition());
    }

    public static void printLineBreak() {
        System.out.println();
    }

    public static void printWinners(List<Car> cars) {
        String winners = Race.findWinners(cars);
        System.out.print("최종 우승자 : " + winners);
    }

    public static void printResultNotification() {
        System.out.println("실행 결과");
    }

    public static void printEnterNameGuide() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void printRoundQuestion() {
        System.out.println("시도할 회수는 몇회인가요?");
    }
}
