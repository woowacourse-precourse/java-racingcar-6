package racingcar;


public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        CarNameInput carNameInput = new CarNameInput();
        carNameInput.print();
        carNameInput.exceptionHandling();
        MoveInput moveInput = new MoveInput();
        String move = moveInput.getMove();
        if (move.isEmpty()) System.out.print("error");
    }
}
