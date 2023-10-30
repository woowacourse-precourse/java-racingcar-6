package racingcar;


public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        CarNameInput carNameInput = new CarNameInput();
        carNameInput.carNameException();
        MoveInput moveInput = new MoveInput();
        moveInput.moveException();

        PlayGame playGame = new PlayGame(carNameInput.getNameList());
       for (int i = 0; i < moveInput.getMove(); i++) {
            playGame.simulation();
            playGame.printResult();
        }
       playGame.printWinnerList();
    }
}
