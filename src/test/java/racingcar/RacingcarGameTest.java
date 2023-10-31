package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.target.Computer;
import racingcar.target.Moderator;
import racingcar.target.User;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class RacingcarGameTest extends NsTest {
    private final User user = new User();
    private final Computer computer = new Computer();
    private final Moderator moderator = new Moderator();

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    private int position = 0;
    private String race = "";
    private String name;
    private int tryNumber;
    private final ArrayList<RacingcarGame> carName = new ArrayList<>();

    @Test
    @DisplayName("게임이 잘 실행되는지 확인")
    void gameStartTest() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    @DisplayName("입력된 자동차 이름이 List안에 잘 들어가는지 확인")
    void makeCarNameListTest() {
        //given
        String userNameInput = "pobi,woni";

        //when
        String[] splitStr = userNameInput.split(",");
        for (int i = 0; i < splitStr.length; i++) {
            moderator.validateCarName(splitStr[i]);
            carName.add(new RacingcarGame(splitStr[i]));
        }
        List <String> testCarName = carName.stream()
                .map(i -> i.name).collect(Collectors.toList());

        //then
        Assertions.assertThat(testCarName).contains("pobi","woni");
    }

    @Test
    @DisplayName("시도회수를 잘 가져오는지 확인")
    void getTryNumberTest() {
        systemIn("5");
        test();
    }

    void test() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(scanner.nextLine());
    }

    protected void systemIn(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}