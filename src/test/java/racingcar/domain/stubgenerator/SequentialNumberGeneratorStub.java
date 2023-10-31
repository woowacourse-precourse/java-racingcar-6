package racingcar.domain.stubgenerator;

import java.util.List;
import racingcar.domain.generator.NumberGenerator;

public class SequentialNumberGeneratorStub implements NumberGenerator {


    private final List<Integer> nums;

    private int index = 0;

    public SequentialNumberGeneratorStub(List<Integer> nums) {
        this.nums = nums;
    }

    @Override
    public int createInRange() {
        int num = nums.get(index);
        index++;
        if(index >= nums.size()) {
            index = 0;
        }
        return num;
    }
}
