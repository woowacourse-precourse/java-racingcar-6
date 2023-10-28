package racingcar.verifier;

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
                throw new IllegalArgumentException("자동차 이름이 5자 이하여야 합니다.");
        }
    }
}
