package racingcar;

import java.util.List;

public class OutputView {

    static void printRoundSet() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    static void printInitCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    static void printCarField(Car car) {
        System.out.println(car.myCurrentStatus());
    }

    static void newLinePrint() {
        System.out.println();
    }

    static void gameStartPrint() {
        System.out.println("\n실행 결과");
    }

    static void winnersPrint(List<String> winners) {
        StringBuilder winnersStringBuilder = new StringBuilder();
        winnersStringBuilder.append("최종 우승자 : ");
        winners.stream()
                .forEach((String winner) -> winnersStringBuilder.append(winner).append(", "));
        winnersStringBuilder.setLength(winnersStringBuilder.length() - 2);
        System.out.println(winnersStringBuilder);
    }


}
