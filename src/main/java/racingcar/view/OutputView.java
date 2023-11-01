package racingcar.view;

import java.util.ArrayList;

public class OutputView {

    public static void printStartMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void printRoundNumMessage() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void printResultStartMessage() {
        System.out.println(" ");
        System.out.println("실행 결과");
    }

    public static void printPlayerRoundResult (String name, int location) {
        System.out.print(name+" : ");
        for (int i = 0; i < location; i++) {
            System.out.print('-');
        }
        System.out.println(" ");
    }
    public static void printWinnerResult(ArrayList<String> winnerNameList) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("최종 우승자 :");
        for (int i = 0; i < winnerNameList.size(); i++) { // 2개 담겨있으면
            if (i == winnerNameList.size() - 1) {
                stringBuilder.append(' '+winnerNameList.get(i));
                break;
            }
            stringBuilder.append(' '+winnerNameList.get(i)+',');
        }
        System.out.println(stringBuilder.toString());
    }
}
