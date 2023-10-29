package racingcar.message;

public class Console {

    public static void requestCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void requestCount() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void resultWinner(String name) {
        System.out.print("최종 우승자 : " + name);
    }

    public static void move(String name, String movement){
        System.out.println(name + " : " + movement);
    }
}
