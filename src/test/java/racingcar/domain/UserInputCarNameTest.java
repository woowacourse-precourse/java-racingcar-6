//package racingcar.domain;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import racingcar.exception.UserCarNameInputException;
//
//import java.util.Arrays;
//import java.util.List;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//
//class UserInputCarNameTest {
//    private UserInputCarName userInputCarName;
//    @BeforeEach
//    void setUp(){
//        userInputCarName = new UserInputCarName();
//    }
//    @Test
//    void 리스트_잘_나오는지_확인(){
//        String input = "pobi,jun,may";
//        List<String> answer = Arrays.asList(input.split(","));
//        List<String> result = userInputCarName.createCarName(input);
//        assertThat(result).isEqualTo(answer);
//    }
//}