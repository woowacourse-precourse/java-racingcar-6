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
    static final String MATCH_RECORD_AND_NAME = " : ";
    static final String TAB = "";
    public static void main(String[] args) {
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
            System.out.println(carList.get(index) + MATCH_RECORD_AND_NAME+ userInfomation.get(carList.get(index)));
        }
        System.out.println(TAB);

    }
}
