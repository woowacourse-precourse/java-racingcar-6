package racingcar;

import camp.nextstep.edu.missionutils.Console;
import org.junit.platform.commons.util.StringUtils;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Game {

    private List<Car> player = new ArrayList<>();
    private List<String> winner = new ArrayList<>();
    private static final int MAXLENGTH = 5;

    public void startGame(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        getPlayers();

        race();
        checkWinner();
    }

    public void getPlayers(){
        String input = Console.readLine();
        if(!isContainComma(input)){
            throw new IllegalArgumentException();
        }
        String[] carNames = input.split(",");

        for(int i =0;i<carNames.length;i++){
            if(!isUnderFiveCharters(carNames[i])){
                throw new IllegalArgumentException();
            }
            player.add(new Car(carNames[i]));
        }
    }

    public void race(){
        System.out.println("시도할 회수는 몇회인가요?");
        String input = Console.readLine();

        if(!isNumeric(input)){
            throw new IllegalArgumentException();
        }

        int round = Integer.parseInt(input);

        System.out.println();
        System.out.println("실행결과");

        for(int i =0;i<round;i++){
            for(int j=0;j<player.size();j++){
                player.get(j).checkProgress();
                player.get(j).printProgress();
            }
        }

    }

    private boolean isContainComma(String str){
        return str.contains(",");
    }

    private boolean isUnderFiveCharters(String str){
        return str.length() <= MAXLENGTH;
    }

    private boolean isNumeric(String str){
        String pattern = "^[0-9]*$";

        return Pattern.matches(pattern, str);
    }

    private void checkWinner(){
        int max=0;
        for(int i=0;i<player.size();i++){
            if(max<player.get(i).getProgress()){
                max=player.get(i).getProgress();
            }
        }

        for(int j=0;j<player.size();j++){
            if(max==player.get(j).getProgress()){
                winner.add(player.get(j).getName());
            }
        }
        System.out.println("최종 우승자 : "+ String.join(" , ", winner));
    }

}
