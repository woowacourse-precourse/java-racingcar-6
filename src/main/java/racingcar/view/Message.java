package racingcar.view;

public class Message {

    public static String noCarsStarted = "자동차가 전진하지 않아 우승자가 없습니다.";
    public static void insertSpace() {
        System.out.println();
    }

    public static void result() {
        insertSpace();
        System.out.println("실행결과");
    }

    public static void printNoWinner(){
        System.out.println(noCarsStarted);
    }
}
