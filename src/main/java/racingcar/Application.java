package racingcar;

public class Application {
    public static void main(String[] args) {
        RaceCarsInput inputManager = new RaceCarsInput();

        int times = inputManager.getTimes();

        System.out.println(times);
    };
}
