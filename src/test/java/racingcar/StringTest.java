package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


public class StringTest {
    @Test
    void split_valuesWithMethod() {
        // BUILD
       String input = "pobi,woni";
       // OPERATE
       String[] result = input.split(",");
        //CHECK
       assertThat(result).contains("woni", "pobi");
       assertThat(result).containsExactly("pobi", "woni");
   }

    @Test
    void split_valuesIfNoSeperator()
   {    // BUILD
       String input = "pobi";
       // OPERATE
       String[] result = input.split(",");
        //CHECK
       Assertions.assertThat(result).contains("pobi");
   }

   @Test
    void check_stringLengthInRange() {
        // BUILD
        String input = "pobi";
        // OPERATE
        int maxLength = 5;
        // CHECK
        assertThat(input.length()).isLessThanOrEqualTo(maxLength);
    }

    @Test
    void check_stringLengthExceedsMax() {
        // BUILD
        String input = "hyolim";
        // OPERATE
        int maxLength = 5;
        // CHECK
        assertThat(input.length()).isGreaterThan(maxLength);
    }

}
