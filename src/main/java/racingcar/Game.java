package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Game {

    public static void playGame(List<User> users) {
        moveForward(users);
        for (User u : users) {
            printRacing(u);
        }
        System.out.println();
    }

    private static int findWinner(List<User> users) {
        int max = 0;
        for (User u : users) {
            max = Math.max(max, u.length);
        }
        return max;
    }

    private static int randomNumber() {
        int randomNum = Randoms.pickNumberInRange(0, 9);
        return randomNum;
    }

    private static void moveForward(List<User> users) {
        for (User u : users) {
            int randomNum = randomNumber();
            if (randomNum < 4) {
                continue;
            }
            u.length += 1;
        }
    }

    private static void printRacing(User u) {
        System.out.print(u.name + " : ");
        for (int i = 0; i < u.length; i++) {
            System.out.print("-");
        }
        System.out.println();

    }
}
