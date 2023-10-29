package racingcar;

import racingcar.domain.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        //디버깅 용 코드 , 구현 후 삭제할것
        //NumberGenerator numberGenerator = new NumberGenerator();
        //int a = numberGenerator.createRandomNumber();
        //System.out.println(a);
        User user = new User();
        //System.out.println(user.decideMove(a));
        List<String> list = user.initCarList();
        System.out.println(list);
        Map<String,String> users = user.initUser(list);
        Car car = new Car();
        for(int i = 0 ; i < 3;i++){
            car.moveForward(list.get(2),users);
            System.out.println(users.get(list.get(2)));
        }
        for(int i = 0 ; i < 2;i++){
            car.moveForward(list.get(0),users);
            System.out.println(users.get(list.get(0)));
        }
        List<String> str = new ArrayList<>();
        Judgement judgement = new Judgement();
        str = judgement.compareDistance(users,list);
        System.out.println(str);
        Referee referee = new Referee();
        referee.printWinner(str);
    }
}
