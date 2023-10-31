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
    private Stadium stadium;
    private int gameCount;

    @Test
    void 경주_진행_테스트() {
        gameCount = 5;
        List<String> names = List.of("김희겸","엄성준","김현진");
        stadium = Stadium.of(gameCount, names);
        try (MockedStatic<Randoms> randoms = mockStatic(Randoms.class)) {
            given(Randoms.pickNumberInRange(0, 9)).willReturn(5);
            stadium.startRace();
            stadium.getUsers()
                    .forEach(user -> {
                        assertThat(user.getProceedCount()).isEqualTo(gameCount);
                        assertThat(user.getOutputMessage()).contains(user.getName() + " : ");
                    });
        }
    }

    @Test
    void 우승자_출력_테스트() {
        List<String> names = List.of("김희겸","엄성준","김현진");
        gameCount = 5;

        stadium = spy(Stadium.of(gameCount, names));

        ByteArrayOutputStream outputMessage = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputMessage));

        when(stadium.getWinner()).thenReturn(List.of(User.of("엄성준")));
        Stadium.displayResult(List.of(User.of("엄성준")));
        assertThat("최종 우승자 : 엄성준\r\n").isEqualTo(outputMessage.toString());
    }

}