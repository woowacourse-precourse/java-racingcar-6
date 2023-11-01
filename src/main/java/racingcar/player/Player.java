package racingcar.player;

import camp.nextstep.edu.missionutils.Console;

import java.util.NoSuchElementException;

public class Player{
    public static String inputErrorMessage = "입력을 해주세요!";
    public String getPlayerInput(){

        try {
            String playerInput = Console.readLine();
            return playerInput;
        }catch (NoSuchElementException e){
            throw new IllegalArgumentException(inputErrorMessage);
        }
    }
}