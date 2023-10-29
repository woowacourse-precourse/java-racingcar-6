package racingcar;

public class Application {
    public static void main(String[] args) {
        UserInput userInput = new UserInput();
        userInput.labelNameOfCar();
        System.out.println("carNames = " + userInput.getCarNames().toString());

        userInput.setupNumberOfTry();
        System.out.println("userInput.getNumberOfTry() = " + userInput.getNumberOfTry());
    }

}
