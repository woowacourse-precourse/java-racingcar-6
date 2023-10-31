package racingcar;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Controller controller = new Controller();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] names = controller.nameInput();
        controller.createRacingCars(names);

        System.out.println("시도할 회수는 몇회인가요?");
        int tryCount = controller.tryCountInput();

        for (int i = 0; i < tryCount; i++) {
            controller.executeTrial();
            controller.displayResult();
        }

        System.out.println("최종 우승자 : " + controller.getWinners());
    }
}
