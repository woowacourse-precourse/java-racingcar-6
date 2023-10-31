package racingcar.target;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

class UserTest {

    /*
     * 사용자가 "pobi,woni"를 입력했다고 가정했을때 잘 입력됐는지 입력값을 출력해서 확인
     */
    @Test
    @DisplayName("사용자로부터 값이 잘 가져와지는지 확인")
    void getUserInputTest() {
        systemIn("pobi,woni");
        test();
    }

    void test() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(scanner.nextLine());
    }

    protected void systemIn(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }
}