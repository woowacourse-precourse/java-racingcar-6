package racingcar.commponent;

public class PrintGameState {

    public static void inputUserInfo() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void inputExecuteTime() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void printExecuteInfo() {
        System.out.println("실행 결과");
    }

    public static void executeResult(String[] users, StringBuilder[] sb) {
        for (int i = 0; i < users.length; i++) {
            System.out.println(users[i] + " : " + sb[i].toString());
        }
        System.out.println();
    }

    public static void printRacingResult(String result) {
        if (result.isEmpty()) {
            System.out.println("우승자가 발생하지 않았습니다 !");
            return;
        }
        System.out.println("최종 우승자 : " + result);
    }
}
