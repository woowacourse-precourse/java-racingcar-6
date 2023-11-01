package racingcar.model;

import static racingcar.util.Constants.ATTEMPTS_SIZE;

public class Game {
    int attempts;


    public void createAttempts(String input){
        validateSize(input);
        validateIsDigit(input);
        validateRange(input);
        this.attempts = Integer.parseInt(input);
    }

    private void validateSize(String input){
        if(input.length() != ATTEMPTS_SIZE){
            throw new IllegalArgumentException("한 자리의 숫자만 입력 가능합니다.");
        }
    }

    private void validateIsDigit(String input){
        char chrInput = input.charAt(0);
        if(!Character.isDigit(chrInput)){
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
    }

    private void validateRange(String input){
        int intInput = Integer.parseInt(input);
        if(intInput < 1){
            throw new IllegalArgumentException("1이상의 숫자만 입력 가능합니다.");
        }
    }

    public int getAttempts(){
        return attempts;
    }
}
