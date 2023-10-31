package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Car {

    // Class Variable
    public static final int ZERO = 0;
    private ArrayList<String> userName;
    private ArrayList<Integer> userMovement;
    private ArrayList<String> winnerName;
    private int winnerMovement;
    private int roundNumber;


    // Constructor
    public Car() {
        this.userName = new ArrayList<>();
        this.userMovement = new ArrayList<>();
        this.winnerName = new ArrayList<>();
        this.winnerMovement = 0;
        this.roundNumber = 0;
    }

    // Method
    public void insertUserName(String userInput) {
        String[] userNameInput = userInput.split(",");
        userName.addAll(Arrays.asList(userNameInput));
    }

    public void checkUserNameLengthError() throws IllegalArgumentException {
        for (String carName : userName) {
            checkUserNameLength(carName);
        }
    }

    public void checkUserNameDuplicate() throws IllegalArgumentException {
        Set<String> carNameList = new HashSet<>(userName);
        if (carNameList.size() != userName.size()) {
            throw new IllegalArgumentException();
        }
    }

    public void checkUserNameLength(String carName) throws IllegalArgumentException {
        if (carName.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    public void insertRoundNumber(String userInput) {
        try {
            roundNumber = Integer.parseInt(userInput);
        } catch (NumberFormatException | NullPointerException e) {
            throw new IllegalArgumentException();
        }
    }

    public void checkRoundNumberError() throws IllegalArgumentException {
        if (roundNumber == ZERO) {
            throw new IllegalArgumentException();
        }
    }

    public int howManyUser() {
        return userName.size();
    }

    public int howManyRound() {
        return roundNumber;
    }

    public void resetUserMovementArraylist() {
        int numOfUser = howManyUser();
        for (int index = 0; index < numOfUser; index++) {
            userMovement.add(0);
        }

    }

    public Boolean checkMoveOrSkip() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        return randomNumber >= 4;
    }

    public void plusMovement(int index) {
        if (checkMoveOrSkip()) {
            int movement = userMovement.get(index) + 1;
            userMovement.set(index, movement);
        }
    }

    public void print() {
        System.out.println(userName);
        System.out.println(userMovement);
    }

    public void searchWinner() {
        int numberOfUser = howManyUser();
        for (int index = 0; index < numberOfUser; index++) {
            int indexUserMovement = userMovement.get(index);
            compareMovement(index, indexUserMovement);
        }
        System.out.println(winnerName);
    }

    public void compareMovement(int index, int indexUserMovement) {
        String indexUserName = userName.get(index);
        if (indexUserMovement == winnerMovement) {
            winnerName.add(indexUserName);
        }
        if (indexUserMovement > winnerMovement) {
            winnerName.clear();
            winnerName.add(indexUserName);
            winnerMovement = indexUserMovement;
        }
    }

    public String returnIndexUserName(int index) {
        return userName.get(index);
    }

    public int returnIndexUserMovement(int index) {
        return userMovement.get(index);
    }

    public String whoIsWinner() {
        return String.join(",", winnerName);
    }
}
