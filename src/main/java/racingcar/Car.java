package racingcar;

import java.util.ArrayList;
import java.util.Arrays;

public class Car {

    // Class Variable
    public static final String MOVEMENT = "-";
    public static final int ZERO = 0;
    private ArrayList<String> userName;
    private ArrayList<Integer> userScore;
    private ArrayList<String> winner;
    private int roundNumber;


    // Constructor
    public Car() {
        this.userName = new ArrayList<>();
        this.userScore = new ArrayList<>();
        this.winner = new ArrayList<>();
        this.roundNumber = 0;
    }

    // Method
    public void insertUserName(String userInput) {
        String[] userNameInput = userInput.split(",");
        userName.addAll(Arrays.asList(userNameInput));
    }

    public void insertRoundNumber(String userInput) {
        int roundNumberInput = Integer.parseInt(userInput);
        if (roundNumberInput != ZERO) {
            roundNumber = roundNumberInput;
        }
    }
}
