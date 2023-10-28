package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.entity.User;

public class GameService {

    public int getCount(){
        return Integer.parseInt(Console.readLine());
    }

    public int gameCount(int count){
        return count--;
    }

    public int randomScore(){
        int randInt = Randoms.pickNumberInRange(0,9);
        if(randInt >= 4){
            return 1;
        }
        return 0;
    }

    public void gameStart(List<User> users){
        users.forEach(user -> {
            int score = user.getScore();
            user.setScore(score + randomScore());
        });
    }

}
