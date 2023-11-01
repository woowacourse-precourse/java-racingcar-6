package racingcar.business;

import java.util.List;

public class ExpectedNumberMaker implements NumberMaker {

    List<Integer> expectedNumbers;
    int currentIndex = 0;

    public void setExpectedNumbers(List<Integer> expectedNumbers) {
        this.expectedNumbers = expectedNumbers;
    }

    @Override
    public Integer getRandomNumber() {
        Integer returnValue = expectedNumbers.get(currentIndex);
        currentIndex ++;
        return returnValue;
    }


}
