package racingcar;

public class Print {
    public static void start() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void repetitions() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void carStatus(Car car) {
        System.out.print(car.getName() + " : ");
        System.out.println("-".repeat(car.getPosition()));
    }
}
