package racingcar.view;

public class Output {
    public static void printResultMsg () {
        System.out.println("실행 결과");
    }

    public static void printProgressing (String name, String progress) {
        System.out.println(name + " : " + progress);
    }

    public static void printWinner (String winners) {
        System.out.println("최종 우승자 : " + winners);
    }

}
