package racingcar.verifier;

import racingcar.system.ExceptionMessage;

import java.util.Arrays;
import java.util.List;

public class CarNameVerifier implements Verifier {
    @Override
    public void check(String input) throws IllegalArgumentException {
        List<String> carNames = Arrays.asList(input.split(","));
        checkCarNameLength(carNames);
    }

    private void checkCarNameLength(List<String> carNames){
        for(String carName: carNames){
            if(carName.length()>5)
                throw new IllegalArgumentException(ExceptionMessage.INVALID_CAR_NAME);
        }
    }
}
