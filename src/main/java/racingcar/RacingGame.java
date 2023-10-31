package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import racingcar.ValidInput;
import racingcar.SimpleCar;
import static racingcar.Constants.ENTER_PLAYER_NAMES_MESSAGE;
import static racingcar.Constants.ENTER_NUMBER_OF_MOVES_MESSAGE;
import static racingcar.Constants.GAME_RESULT_MESSAGE;
import static racingcar.Constants.WINNER_MESSAGE;
import static racingcar.Constants.COLON;



public class RacingGame {
    public void startGame() {
        List<String> playerNamesList = new ArrayList<>();
        promptForPlayerNames(playerNamesList);

        List<SimpleCar> players = new ArrayList<>();
        SimpleCar.createCar(playerNamesList, players);

        int moves = promptNumberOfMoves();
        System.out.println(GAME_RESULT_MESSAGE);
        for(int i = 0; i < moves; i++) {
            for(SimpleCar car : players) {
                car.goFoward();
            }
            printCarMovement(players);
        }
        printWinner();
    }
    public void promptForPlayerNames(List<String> playerNamesList) {
        System.out.println(ENTER_PLAYER_NAMES_MESSAGE);
        String playerNameString = camp.nextstep.edu.missionutils.Console.readLine();
        if(ValidInput.isValidInput(playerNameString));
        // else throw new  IllegalArgumentException();
        String[] playerNamesArray = playerNameString.split(",");
        playerNamesList.addAll(Arrays.asList(playerNamesArray));
        System.out.println(playerNamesList.size());
    }
    public int promptNumberOfMoves() {
        String movesString;
        int moves;
        System.out.println(ENTER_NUMBER_OF_MOVES_MESSAGE);
        movesString = camp.nextstep.edu.missionutils.Console.readLine();
        //  throw IllegalArgumentException
        moves = Integer.parseInt(movesString);
        System.out.println();
        return moves;
    }
    public void printCarMovement(List<SimpleCar> players) {
        for(SimpleCar car : players) {
            System.out.println(car.getCarName()+COLON+car.getCarMovement());
        }
        System.out.println();
    }
    public void printWinner() {
        System.out.println(WINNER_MESSAGE+COLON);
    }
}
