package racingcar;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.util.User;

class UserInputTest {

    @Test
    void 자동차_이름_입력값_테스트() {
        User user = new User();

        String inputTest1 = "test1,test2,test3";
        String inputTest2 = "test1,test2,test3,";
        String inputTest3 = "test1,test222,test3";
        String inputTest4 = "test1,test2,,test3";
        String inputTest5 = ",test1,test2,test3";
        String inputTest6 = "test1, test,test3";

        List<String> carList1 = Arrays.asList(inputTest1.split(","));
        List<String> carList2 = Arrays.asList(inputTest2.split(","));
        List<String> carList3 = Arrays.asList(inputTest3.split(","));
        List<String> carList4 = Arrays.asList(inputTest4.split(","));
        List<String> carList5 = Arrays.asList(inputTest5.split(","));
        List<String> carList6 = Arrays.asList(inputTest6.split(","));

        assertDoesNotThrow(() -> user.checkInputCar(carList1));
        assertThrows(IllegalArgumentException.class, () -> user.checkInputCar(carList2));
        assertThrows(IllegalArgumentException.class, () -> user.checkInputCar(carList3));
        assertThrows(IllegalArgumentException.class, () -> user.checkInputCar(carList4));
        assertThrows(IllegalArgumentException.class, () -> user.checkInputCar(carList5));
        assertThrows(IllegalArgumentException.class, () -> user.checkInputCar(carList6));
    }

    @Test
    void 시도_횟수_입력값_테스트(){
        User user = new User();

        String input1 = "-1";
        String input2 = "123456";
        String input3 = "-1";
        String input4 = "2147483648";
        String input5 = "";
        String input6 = " 1";
        String input7 = "a";

        assertDoesNotThrow(() -> user.checkTryNumber(input1));
        assertDoesNotThrow(() -> user.checkTryNumber(input2));
        assertDoesNotThrow(() -> user.checkTryNumber(input3));
        assertThrows(IllegalArgumentException.class, () -> user.checkTryNumber(input4));
        assertThrows(IllegalArgumentException.class, () -> user.checkTryNumber(input5));
        assertThrows(IllegalArgumentException.class, () -> user.checkTryNumber(input6));
        assertThrows(IllegalArgumentException.class, () -> user.checkTryNumber(input7));
    }
}