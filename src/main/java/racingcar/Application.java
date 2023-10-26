package racingcar;

public class Application {
    public static void main(String[] args) {

        User user = new User();

        // TODO: 프로그램 구현

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        user.getCarNamesFromUser();

        System.out.println("시도할 회수는 몇회인가요?");
        user.getNumberOfMovesFromUser();
    }
}
