package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class NumberGeneratorTest {

    @Test
    void pickNumberFrom0To9_메서드로_0부터_9까지_정수_중에_무작위로_1개를_뽑아서_반환(){
        int[] numbers = {0, 1, 2, 3, 4 ,5 ,6 ,7 ,8 ,9};

        NumberGenerator numberGenerator = new NumberGenerator();
        int pickedNumber = numberGenerator.pickNumberFrom0To9();

        assertThat(numbers).contains(pickedNumber);
    }

}
