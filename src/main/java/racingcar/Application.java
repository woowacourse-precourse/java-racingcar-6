package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Dictionary;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String playerInput = Console.readLine();
        Player player = new Player();
        ArrayList<String> carList = player.createPlayerCarList(playerInput);
        Validators validator = new Validators();
        validator.isListElementOverFive(carList);

        System.out.println("시도할 회수는 몇회인가요?");
        String numberOfLaps = Console.readLine();
        int lapOfRace = player.setLapsOfRace(numberOfLaps);

        ArrayList<Integer> gameResult = new ArrayList<Integer>(carList.size());
        for (int i=0; i<carList.size(); i++) {
            gameResult.add(0);
        }
        for (int lap=0; lap<lapOfRace; lap++) {
            gameResult = Game.startRace(carList, gameResult);
        }
        ArrayList<Integer> lastRaceResult = gameResult;
        Referee referee = new Referee();
        ArrayList<String> raceWinners = referee.compare(lastRaceResult, carList);
        referee.printWinners(raceWinners);
    }
}
