package racingcar;

import racingcar.domain.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    static User user = new User();
    static NumberGenerator numberGenerator = new NumberGenerator();
    static Car car = new Car();
    static Referee referee = new Referee();
    static Judgement judgement = new Judgement();

    static List<String> carList;
    static List<String> winners;
    static int gameCount;
    static Map<String,String> userInfomation;
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        carList =  user.initCarList();
        userInfomation = user.initUser(carList);
        System.out.println("시도할 회수는 몇회인가요?");
        gameCount = user.inputGameCount();
        System.out.println("\n실행 결과");
        while (gameCount > 0){

            for (int index = 0; index < carList.size();index++){
                int randomNumber = numberGenerator.createRandomNumber();
                if(user.decideMove(randomNumber)){
                    car.moveForward(carList.get(index),userInfomation);
                }
                System.out.println(carList.get(index) + " : "+ userInfomation.get(carList.get(index)));
            }
            System.out.println("");
            gameCount--;
        }
        winners = judgement.compareDistance(userInfomation,carList);
        referee.printWinner(winners);
    }
}
