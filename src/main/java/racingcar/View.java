package racingcar;

import java.util.List;

public class View {

    public static void inputMessageOfCar() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void inputMessageOfTries() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void printCarInformation(Car car) {
        String name = car.getName();
        String position = makePositionVisible(car.getPosition());

        System.out.println(name + " : " + position);
    }

    private static String makePositionVisible(int position) {
        String loopSymbol = "-";
        return loopSymbol.repeat(Math.max(0, position));
    }

    public static void printResultTitle() {
        System.out.println("실행결과");
    }

    public static void printBlank() {
        System.out.println();
    }

    public static void printWinner(List<String> nameOfWinners) {
        String result = String.join(",", nameOfWinners);
        System.out.println("최종 우승자 : " + result);
    }
}
