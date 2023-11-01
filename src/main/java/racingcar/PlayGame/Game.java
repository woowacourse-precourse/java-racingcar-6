package racingcar.PlayGame;

import java.util.List;
import racingcar.RandomNumberGenerator.GetRandomNumber;
import racingcar.RandomNumberGenerator.RandomGenerator;
import racingcar.View.Input;
import racingcar.View.Print.Print;
import racingcar.player.User;
import racingcar.player.UserList;

public class Game {

    public void startGame() {
        UserList user = new UserList();
        Print print = new Print();
        final List<User> UserList = user.inputUser();

        int RoundCount = inputRoundCount();
        int count = 0;

        System.out.println();
        System.out.println("실행 결과 ");

        while (count != RoundCount) {

            for (User user1 : UserList) {
                onlyOnePlayer(user1);
            }

            count++;
            print.Result(UserList);
            System.out.println();

        }

        print.FinalWinner(UserList);

    }

    private static void onlyOnePlayer(User user) {
        GetRandomNumber getRandomNumber = new RandomGenerator();
        int Number = getRandomNumber.GeneratorRandomNumber();
        if (Number >= 4) {
            user.forward();
        }
    }

    private int inputRoundCount() {
        Input input = new Input();
        System.out.println("시도할 회수는 몇회인가요?");
        int count = input.inputInteger();
        input.verifyRoundCount(count);
        return count;
    }

}


