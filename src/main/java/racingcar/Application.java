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
    static SystemMessage systemMessage = new SystemMessage();
    static List<String> carList;
    static List<String> winners;
    static int gameCount;
    static Map<String,String> userInfomation;
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        systemMessage.printStartMessage();
        carList =  user.initCarList();
        userInfomation = user.initUser(carList);
        systemMessage.printUserInputMessage();
        gameCount = user.inputGameCount();
        systemMessage.printResultMessage();
        gameStart(gameCount);
        winners = judgement.compareDistance(userInfomation,carList);
        referee.printWinner(winners);
    }
    static void gameStart(int gameCount){
        while (gameCount > 0){
            roundStart();
            gameCount--;
        }
    }
    static void roundStart(){
        for (int index = 0; index < carList.size();index++){
            int randomNumber = numberGenerator.createRandomNumber();
            if(user.decideMove(randomNumber)){
                car.moveForward(carList.get(index),userInfomation);
            }
            System.out.println(carList.get(index) + " : "+ userInfomation.get(carList.get(index)));
        }
        System.out.println("");

    }
}
