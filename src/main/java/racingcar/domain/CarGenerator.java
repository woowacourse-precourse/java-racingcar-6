package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.RacingGame;

public class CarGenerator {
    
    RacingGame racinggame = new RacingGame();
    
    public void inputCarNames(){
        List<String> carNames = new ArrayList<String>();
        String input = Console.readLine();
        carNames = Arrays.asList(input.split(","));

        int lengthCarNames = input.length();

        validateCarNameNull(input);

        if(input.charAt(0) == ',' || 
                input.charAt(lengthCarNames-1) == ','){
            validateCarNameBlank(input, ",");
        }

        for(int i = 0 ; i < carNames.size(); i++){
            String checkCarNameLength = (String) carNames.get(i);
            validateCarNameLength(checkCarNameLength);
        }

        validateCarNameDistint(carNames);

        racinggame.setCarNames(carNames);
    }

    private void validateCarNameNull(String input){
        if (input == null){
            throw new IllegalArgumentException("NULL을 입력 하였습니다.");
        }
    }

    private void validateCarNameBlank(String input, String checkblank){
        if (input.isBlank() || checkblank.equals(",")){
            throw new IllegalArgumentException("공백을 입력 하였습니다.");
        }
    }

    private void validateCarNameLength(String input){
        if(input.length() > 5){
            throw new IllegalArgumentException("길이를 초과하였습니다.");
        }
    }

    private void validateCarNameDistint(List<String> input){
        long inputCarName= input.stream().distinct().count();
        if(input.size()!= inputCarName){
            throw new IllegalArgumentException("중복값 입력");
        }
    }
}
