package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String playerInput = Console.readLine();

        Player player = new Player();
        ArrayList<String> playerList = player.createPlayerCarList(playerInput);
        Validators validator = new Validators();
        validator.isListElementOverFive(playerList);

        System.out.println("시도할 회수는 몇회인가요?");
        String numberOfLaps = Console.readLine();

        int lapOfRace = player.setLapsOfRace(numberOfLaps);
        ArrayList<Integer> gameResult = new ArrayList<>(playerList.size());
        for (int i = 0; i < playerList.size(); i++) {
            gameResult.add(0);
        }
        for (int lap = 0; lap < lapOfRace; lap++) {
            gameResult = Game.startRace(playerList, gameResult);
        }
        ArrayList<Integer> lastRaceResult = gameResult;

        Referee referee = new Referee();
        ArrayList<String> raceWinners = referee.compare(lastRaceResult, playerList);
        referee.printWinners(raceWinners);
    }
}
