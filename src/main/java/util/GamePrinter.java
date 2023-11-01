package util;

import car.Car;

import java.util.List;

public class GamePrinter {

    private static final String COLON = " : ";
    private static final String COMMA = ", ";


    public static void inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void inputCount() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void startMove() {
        System.out.println("실행 결과");
    }

    public static void printCarNamePosition(Car car) {
        StringBuilder sb = new StringBuilder();
        sb.append(car.getName());
        sb.append(COLON);
        for (int i = 0; i < car.getPosition(); i++) {
            sb.append("-");
        }
        System.out.println(sb.toString());
    }

    public static void determineWinner(List<String> winnerCarNames) {

        String winnerList = String.join(COMMA, winnerCarNames);
        System.out.println("최종 우승자 : " + winnerList);
    }

}
