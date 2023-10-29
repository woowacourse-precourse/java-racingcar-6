package racingcar;

public class UserInput {
    Verification verification = new Verification();
    public void labelNameOfCar() {
        verification.verifyArg();
    }

    public void setupNumberOfTry() {
        verification.verifyNumberOfTry();
    }


}
