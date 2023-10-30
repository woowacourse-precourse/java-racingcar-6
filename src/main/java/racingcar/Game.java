package racingcar;

public class Game {

    private CarRace carRace;
    private int tryCnt;

    public Game() {
        User user = new User();
        this.carRace = new CarRace(user.getCarNames());
        this.tryCnt = user.getTryCnt();
    }

    public void startGame() {

    }


}
