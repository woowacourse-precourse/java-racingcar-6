package racingcar.controller;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import racingcar.manager.controller.UserController;

public class UserControllerTest {

    private final UserController userController = new UserController();

    @AfterEach
    void closeConsole(){
        Console.close();
    }

    @Test
    void 유저_시도_횟수_반환_검증_테스트(){
        String tryCount = "5";

        InputStream in = new ByteArrayInputStream(tryCount.getBytes());
        System.setIn(in);

        Integer expectedCount = 5;
        assertThat(userController.getUserTryCount()).isEqualTo(expectedCount);
    }
}
