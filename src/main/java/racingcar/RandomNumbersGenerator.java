package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomNumbersGenerator {
    private Integer minimumOfRange;
    private Integer maximumOfRange;
    private Integer numberOfNumbers;

    public RandomNumbersGenerator(Integer minimumOfRange, Integer maximumOfRange, Integer numberOfNumbers) {
        this.minimumOfRange = minimumOfRange;
        this.maximumOfRange = maximumOfRange;
        this.numberOfNumbers = numberOfNumbers;
    }

    public List<Integer> generate() {
        List<Integer> randomNums = new ArrayList<>();
        while (randomNums.size() < numberOfNumbers) {
            int randomNum = Randoms.pickNumberInRange(minimumOfRange, maximumOfRange);
            if (!randomNums.contains(randomNum)) {
                randomNums.add(randomNum);
            }
        }
        return randomNums;
    }


}
