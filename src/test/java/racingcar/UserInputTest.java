package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class UserInputTest {
    private static Verification verification;
    private static UserInput userInput;

    @BeforeEach
    void initEach() {
        verification = new Verification();
        userInput = new UserInput();

    }

    @Test
    void validateNameIllegalCase() {                //자동차 이름 입력에 관한 Exception 테스트

        //5자 이상의 값을 입력 하면 IllegalArgumentException 을 호출 한다.
        String illegalName = "하나,둘,셋,넷,다섯글자이상";
        List<String> illegalNames = List.of(illegalName.split(","));
        assertThrows(IllegalArgumentException.class, () -> verification.verifyArg(illegalNames));

        //정상적인 입력시 IllegalArgumentException 을 호출 하지 않는다.
        String legalName = "하나,둘,셋,넷,다섯";
        List<String> legalNames = List.of(legalName.split(","));
        Assertions.assertDoesNotThrow(()->verification.verifyArg(legalNames));
    }

    @Test
    void validateNumberOfTryIllegalCase() {         //시행 횟수 입력에 관한 Exception 테스트

        String illegalCase1 = "하나";                //입력값이 문자열인 경우.
        assertThrows(IllegalArgumentException.class, () -> verification.verifyNumberOfTry(illegalCase1));

        String illegalCase2 = "-1";                  //입력값이 음수인 경우.
        String illegalCase3 = "0";                   //입력값이 음수인 경우.
        assertThrows(IllegalArgumentException.class, () -> verification.verifyNumberOfTry(illegalCase2));
        assertThrows(IllegalArgumentException.class, () -> verification.verifyNumberOfTry(illegalCase3));
    }



        @Test
    void labelNameOfCar() {
        // 입력값을 ","로 나누어 배열로 받는지 확인.

        String carNameInput = "하나,둘,셋,넷";
        InputStream carName = new ByteArrayInputStream(carNameInput.getBytes());
        System.setIn(carName);
        userInput.labelNameOfCar();
        assertThat(userInput.getCarNames().size()).isEqualTo(4);
        Console.close();

        assertThat(userInput.getCarNames()).containsExactly("하나","둘","셋","넷");
    }

    @Test
    void setupNumberOfTry() {
        //입력된 정수를 시행 회수로 저장.

        int numberOfTry = Randoms.pickNumberInRange(1, 9);
        String tryNumberInput = String.valueOf(numberOfTry);
        InputStream tryNumber = new ByteArrayInputStream(tryNumberInput.getBytes());
        System.setIn(tryNumber);
        userInput.setupNumberOfTry();
        assertThat(userInput.getNumberOfTry()).isEqualTo(numberOfTry);
        Console.close();
    }


}