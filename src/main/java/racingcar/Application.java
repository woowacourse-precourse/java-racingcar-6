package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.SplittableRandom;

public class Application {
    public static void main(String[] args) {

    playeGame();

    }
    public static void playeGame(){
        while (true){
            playerName();
            getplayTime();

            break;
        }
    }
    public static List<String> playerName(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String > player = new ArrayList<>();
        String input = Console.readLine();
        String[] names = input.split(",");
        for (String name : names) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("5자 이내로 입력해주세요");
            }
            player.add(name);
        }
        return player;
    }
    public static int getplayTime(){
        System.out.println("시도할 횟수는 몇회인가요?");
        int playTimes;
        try{
            playTimes = Integer.parseInt(Console.readLine());
            if(playTimes <=0){
                throw new IllegalArgumentException("0보다 큰 숫자를 입력해주세요");
            }
        }catch (Exception e){
            throw new IllegalArgumentException("시도횟수가 숫자가 아닙니다");
        }
        return playTimes;
    }

}
