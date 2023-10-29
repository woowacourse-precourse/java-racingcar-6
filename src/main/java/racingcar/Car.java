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


    // Constructor
    public Car() {
        this.userName = new ArrayList<>();
        this.userScore = new ArrayList<>();
        this.winner = new ArrayList<>();
    }

    // Method
    public void insertUserName(String userInput) {
        String[] userNameInput = userInput.split(",");
        userName.addAll(Arrays.asList(userNameInput));
    }
}
