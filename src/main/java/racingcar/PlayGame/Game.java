package racingcar.PlayGame;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.RandomNumberGenerator.GetRandomNumber;
import racingcar.RandomNumberGenerator.RandomGenerator;
import racingcar.View.Input;
import racingcar.player.User;
import racingcar.player.UserList;

public class Game {



    public void startGame () {
        UserList user = new UserList();
        List<User> UserList =  user.inputUser();
        int multipleCount = inputMultipleCount();
        int count =0;

        while (count != multipleCount) {

            for (int i = 0; i < UserList.size(); i++) {
                playerOne(UserList.get(i));
                System.out.print(UserList.get(i).getUserName() + ":");
                System.out.println(UserList.get(i).getForwardDistance());
            }
            count++;
        }

    }

    private static void playerOne(User user) {
        GetRandomNumber getRandomNumber = new RandomGenerator();
        int Number = getRandomNumber.GeneratorRandomNumber();
        if(Number >= 4) {
            user.forward();
        }
    }

    private int inputMultipleCount(){
        Input input = new Input();
        System.out.println("시도할 회수는 몇회인가요?");
        int count =  input.inputInteger();
        return count;
    }

}


