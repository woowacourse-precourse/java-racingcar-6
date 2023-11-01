package racingcar;

public class Application {
    public static void main(String[] args) {
        raceCarsInput inputManager = new raceCarsInput();

        int times = inputManager.getTimes();

        System.out.println(times);
    };
}
