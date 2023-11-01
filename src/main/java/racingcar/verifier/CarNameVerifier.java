package racingcar.verifier;

import racingcar.exception.ExceptionMsg;

import java.util.List;
import java.util.regex.Pattern;

public class CarNameVerifier {
    private final List<String> carNames;

    public CarNameVerifier(String input){
        this.carNames = List.of(input.trim().split(","));   //배열을 만든 후 리스트 생성
        verifyNull();
    }

    private void verifyNull(){
        if(this.carNames.isEmpty()){
            throw new IllegalArgumentException(ExceptionMsg.NULL_INPUT.getMessage());
        }
    }

    private void verifyRangeOut(){
        this.carNames.forEach(carName ->{
            if(carName.length() > 5) {
                throw new IllegalArgumentException(ExceptionMsg.OVER_FIVE_CAR_NAME.getMessage());
            }
        });
    }

}
