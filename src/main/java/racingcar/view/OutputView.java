package racingcar.view;


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
}
