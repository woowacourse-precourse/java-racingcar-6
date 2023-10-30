package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.StringJoiner;

public class Game {

    public void playGame(List<User> users) {
        for (User u : users) {
            int randomNum = randomNumber();
            moveForward(randomNum, u);
            printRacing(u);
        }
        System.out.println();
    }

    public void printWinner(List<User> users) {
        System.out.print("최종 우승자 : ");
        int max = findWinner(users);

        StringJoiner sj = new StringJoiner(", ");
        for (User u : users) {
            if (u.length == max) {
                sj.add(u.name);
            }
        }
        System.out.print(sj);
    }

    public int findWinner(List<User> users) {
        int max = 0;
        for (User u : users) {
            max = Math.max(max, u.length);
        }
        return max;
    }


    public int randomNumber() {
        int randomNum = Randoms.pickNumberInRange(0, 9);
        return randomNum;
    }

    public void moveForward(int randomNum, User user) {
        if (randomNum >= 4) {
            user.length += 1;
        }
    }

    public void printRacing(User u) {
        System.out.print(u.name + " : ");
        for (int i = 0; i < u.length; i++) {
            System.out.print("-");
        }
        System.out.println();

    }
}
