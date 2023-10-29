package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

class StadiumTest {
    private static ByteArrayOutputStream outputMessage;
    private Stadium stadium;
    private List<User> users;
    private int gameCount;


    @Test
    void 경주_진행_테스트() {
        gameCount = 5;
        users = List.of(User.of("김희겸"), User.of("엄성준"), User.of("김현진"));
        stadium = new Stadium(gameCount, users);
        try (MockedStatic<Randoms> randoms = mockStatic(Randoms.class)) {
            given(Randoms.pickNumberInRange(0, 9)).willReturn(5);
            stadium.startRace();
            users.forEach(user -> {
                assertThat(user.getProceedCount()).isEqualTo(gameCount);
                assertThat(user.visualizeProgress()).contains(user.getName() + " : ");
            });
        }
    }

    @Test
    void 우승자_출력_테스트() {
        User user1 = User.of("김현진");
        User user2 = User.of("김희겸");
        User user3 = User.of("엄성준");

        user1.setProceedCount(2);
        user2.setProceedCount(2);
        user3.setProceedCount(3);

        gameCount = 5;
        stadium = spy(new Stadium(gameCount, List.of(user1,user2,user3)));

        outputMessage = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputMessage));

        when(stadium.chooseWinner()).thenReturn(List.of(user3));
        Stadium.displayResult(List.of(user3));
        assertThat("최종 우승자 : 엄성준\r\n").isEqualTo(outputMessage.toString());
    }

}