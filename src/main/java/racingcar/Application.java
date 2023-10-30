package racingcar;


public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        CarNameInput carNameInput = new CarNameInput();
        carNameInput.print();
        carNameInput.carNameException();
        MoveInput moveInput = new MoveInput();
        moveInput.moveException();
    }
}
