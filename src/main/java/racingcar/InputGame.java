package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;

public class InputGame {
    private ArrayList<String> carName = new ArrayList<>();
    public void setCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] inputName = Console.readLine().split(",");

        for (int i = 0; i < inputName.length; i++){
            if(inputName[i].length() > 5){
                throw new IllegalArgumentException("5자 이하의 이름을 입력해주세요.");
            }
            else{
                carName.add(inputName[i]);
            }
        }
    }
    public ArrayList<String> getCarName(){
        return carName;
    }
    private int gameCount;
    public void setGameNumber() {
        System.out.println("시도할 회수는 몇회인가요?");
        gameCount = Integer.parseInt(Console.readLine());
    }

    public int getGameCount(){
        return gameCount;
    }
}
