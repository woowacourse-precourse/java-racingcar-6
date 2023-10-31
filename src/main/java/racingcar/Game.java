package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.common.Announcement;
import racingcar.common.Rule;

public class Game {

    public String[] carNameArray;
    public int[] carLocationArray;
    public int numberOfCar;
    public int moveCount;

    public Game() {
        init();
    }

    public void run() {
        Announcement.EXECUTION_RESULT.speak();
        for (int i = 0; i < this.moveCount; i++) {
            carRuns();
            System.out.println();
        }
        String[] winnerArray = getWinnerArray();
        printWinner(winnerArray);
    }

    private void printWinner(String[] winnerArray) {
        Announcement.WINNER.speak();
        int i = 0;
        for (; i < winnerArray.length - 1; i++) {
            System.out.print(winnerArray[i] + ", ");
        }
        System.out.println(winnerArray[i]);
    }

    private String[] getWinnerArray() {
        List<String> winnerList = new ArrayList<>();
        int maxLocation = Arrays.stream(this.carLocationArray).max().getAsInt();
        for (int i = 0; i < this.numberOfCar; i++) {
            if (this.carLocationArray[i] == maxLocation) {
                winnerList.add(carNameArray[i]);
            }
        }
        return winnerList.toArray(new String[0]);
    }

    private void carRuns() {
        for (int i = 0; i < this.numberOfCar; i++) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            if (randomNumber >= Rule.MOVING_FORWARD.getValue()) {
                this.carLocationArray[i]++;
            }
            int currentLocation = this.carLocationArray[i];
            System.out.println(this.carNameArray[i] + " : " + "-".repeat(currentLocation));
        }
    }

    private void init() {
        this.carNameArray = getCarNameArrayFromInput();
        this.numberOfCar = this.carNameArray.length;
        this.carLocationArray = new int[this.numberOfCar];
        this.moveCount = getMoveCountFromInput();
    }

    private String[] getCarNameArrayFromInput() {
        Announcement.INPUT_CAR_NAMES.speak();
        String[] inputCarNameArray = Console.readLine().split(",");
        Validator.validateCarNameArray(inputCarNameArray);
        return inputCarNameArray;
    }

    private int getMoveCountFromInput() {
        Announcement.INPUT_MOVE_COUNT.speak();
        String inputMoveCountString = Console.readLine();
        Validator.validateMoveCount(inputMoveCountString);
        return Integer.parseInt(inputMoveCountString);
    }

}
