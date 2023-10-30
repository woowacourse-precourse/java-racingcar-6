package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.exception.UserInputException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.in;
import static org.junit.jupiter.api.Assertions.*;

class CarsTest {
    private UserInputException userInputException;
    private Cars cars;
    @BeforeEach
    void setUp(){
        userInputException = new UserInputException();
    }
    @Test
    void 리스트_잘_나오는지_확인(){
        String input = "pobi";
        List<String> answer = Arrays.asList(input.split(","));
        Cars cars = new Cars();
        List<String> result = cars.createCarName(input);
        assertThat(result).isEqualTo(answer);

    }
}