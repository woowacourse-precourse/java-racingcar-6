package racingcar;

public class Application {
    public static void main(String[] args) {
        NumberGenerator Generator = new NumberGenerator();
        System.out.println(Generator.createRandomNumber());
    }
}
