package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import racingcar.model.Car;
import racingcar.model.Race;
import racingcar.service.PlayService;

import java.util.Arrays;


public class PlayServiceTest extends NsTest {
    PlayService playService = new PlayService();

    @Test
    public void 올바른_1이상의_숫자_입력(){
        //given
        String test1 = "5";
        String test2 = "30";
        String test3 = "0";
        String test4 = "-5";
        String test5 = "5번";
        String test6 = "다섯번";
        String test7 = "1000000000000000";

        //when & then
        Assertions.assertDoesNotThrow(() -> playService.transFromTryNumForInt(test1));
        Assertions.assertDoesNotThrow(() -> playService.transFromTryNumForInt(test2));
        Assertions.assertThrows(IllegalArgumentException.class, () -> playService.transFromTryNumForInt(test3));
        Assertions.assertThrows(IllegalArgumentException.class, () -> playService.transFromTryNumForInt(test4));
        Assertions.assertThrows(IllegalArgumentException.class, () -> playService.transFromTryNumForInt(test5));
        Assertions.assertThrows(IllegalArgumentException.class, () -> playService.transFromTryNumForInt(test6));
        Assertions.assertThrows(IllegalArgumentException.class, () -> playService.transFromTryNumForInt(test7));
    }

    @Test
    public void 한턴_진행() {
        // given
        Race race = new Race();
        race.setCars(Arrays.asList(new Car("tom"), new Car("lucy")));
        race.setTryNum(1);
        try (final MockedStatic<Randoms> mockRandoms = Mockito.mockStatic(Randoms.class)) {
            mockRandoms.when(() -> Randoms.pickNumberInRange(0, 9)).thenReturn(3,4);

            // when
            playService.playTurn(race);

            // then
            Assertions.assertEquals(0,race.getCars().get(0).getPoint());
            Assertions.assertEquals(1,race.getCars().get(1).getPoint());
        }
    }

    @Test
    public void 랜덤_값이_4이상_시_TRUE(){
        //given
        int test1 = 3;
        int test2 = 4;

        //when & then
        Assertions.assertEquals(false, playService.isFourOrMore(test1));
        Assertions.assertEquals(true, playService.isFourOrMore(test2));
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
