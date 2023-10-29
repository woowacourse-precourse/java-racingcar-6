package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        GameSimulation game=new GameSimulation();
        System.out.println("이름들 입력:");
        String userInput = Console.readLine();
        game.userInit(userInput);



    }
}
