package racingcar;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Game game = new Game();
        String[] members = game.inputCars();
        game.correctLength(members);
        game.carMembersConstructor(members);

        int count = game.inputMoveNum();
        game.operate(count);
    }
}
