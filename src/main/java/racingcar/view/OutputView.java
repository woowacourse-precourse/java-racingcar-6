package racingcar.view;

import java.util.List;

public class OutputView {

    public static StringBuilder sb;
    public static void printGameResultByOrder(String name, int forward){
        sb  = new StringBuilder();
        sb.append(name).append(" : ");

        sb.append("-".repeat(Math.max(0, forward)));
        System.out.println(sb);
    }

    public static void println(){
        System.out.println();
    }

    public static void printSoloWinner(String winner){
        sb = new StringBuilder();
        sb.append("최종 우승자 : ").append(winner);
        System.out.println(sb);
    }

    public static void printJointWinner(List<String> winner){
        sb = new StringBuilder();
        sb.append("최종 우승자 : ");

        for (int i = 0; i < winner.size(); i++) {
            sb.append(winner.get(i));
            if (i < winner.size() - 1) {
                sb.append(", ");
            }
        }
        System.out.println(sb);
    }
}
