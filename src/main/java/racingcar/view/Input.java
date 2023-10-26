package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Input {
    public String[] getPlayerName(){
        String playersName = Console.readLine();
        return playersName.split(",");
    }

    public int getNumberOfRepetitions(){
        try{
            return Integer.parseInt(Console.readLine());
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("제대로 된 숫자를 입력해 주세요");
        }
    }
}
