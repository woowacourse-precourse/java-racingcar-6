package racingcar;

import java.util.List;

public class Game {

    private CarRace carRace;
    private int tryCnt;

    public Game() {
        User user = new User();
        this.carRace = new CarRace(user.getCarNames());
        this.tryCnt = user.getTryCnt();
    }

    public void startGame() {
        System.out.println("\n실행 결과");
        for (int i = 0; i < tryCnt; i++) {
            carRace.race();
            System.out.println();
        }
        List<String> winners = carRace.findWinners();
        printWinners(winners);
    }

    private void printWinners(List<String> winners) {
        String winnersString = String.join(", ", winners);
        System.out.println("최종 우승자 : " + winnersString);
    }


}
