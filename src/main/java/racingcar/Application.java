package racingcar;

public class Application {
    public static void main(String[] args) {
        int carNameMaxLength = 5;
        Program program = new Program(carNameMaxLength);
        program.run();
    }
}
