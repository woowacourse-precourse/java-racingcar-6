package racingcar.verifier;

import racingcar.exception.ExceptionMsg;

import java.util.List;
import java.util.regex.Pattern;

public class CarNameVerifier {
    private final Pattern validPattern = Pattern.compile("^[a-zA-Z0-9]+$"); // 영문자와 숫자만 허용
    private final List<String> carNames;

    public CarNameVerifier(String input){
        this.carNames = List.of(input.trim().split(","));   //배열을 만든 후 리스트 생성
        verifyNull();
        verifyRangeOut();
        verifyMinimumTwoCars();
        verifyNoWhitespace();
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
    private void verifyMinimumTwoCars() {
        if (this.carNames.size() < 2) {
            throw new IllegalArgumentException(ExceptionMsg.MINIMUM_TWO_CARS_REQUIRED.getMessage());
        }
    }
    private void verifyNoWhitespace() {
        this.carNames.forEach(carName -> {
            if (carName.contains(" ")) {
                throw new IllegalArgumentException(ExceptionMsg.DUPLICATE_CAR_NAME.getMessage());
            }
        });
    }


}
