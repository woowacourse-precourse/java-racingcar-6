package racingcar.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OutputView {
    private static String winnerMessage = "최종 우승자 : ";
    private static String startMessage = "경주할 자동차 이름을 입력하세요.(이름은 쉼포(,) 기준으로 구분)";
    private static String tryMessage = "시도할 회수는 몇회인가요?";
    public static void printStartMessage(){
        System.out.println(startMessage);
    }

    public static void printTryMessage() {
        System.out.println(tryMessage);
    }

    public static void printNameAndDashes(String name, int distance) {
        String distanceDash = "-".repeat(distance);
        System.out.println(name + " : " + distanceDash);
    }

    public static void printRoundFin(){
        System.out.println();
    }
    public static void printFinMessage(List<String> racerNames){
        System.out.print(winnerMessage);
        String winnerNames = racerNames.stream()
                .collect(Collectors.joining(", "));
        System.out.println(winnerNames);
    }
}
