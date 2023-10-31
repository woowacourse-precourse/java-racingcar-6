package racingcar.view;

public class OutputView {

    public static void responseExecution() {
        System.out.println("실행 결과");
    }

    public static void outputOfExecution(int[] carPresentPoint, String[] carName) {
        for (int i = 0; i < carName.length; i++) {
            System.out.println(carName[i] + " : " + "-".repeat(carPresentPoint[i]));
        }
        System.out.println("");
    }

    public static void responseWinner(String answer) {
        System.out.println("최종 우승자 : " + answer);
    }

}
