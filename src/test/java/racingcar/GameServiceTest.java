package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Cars;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class GameServiceTest extends NsTest {

    private GameService gameService;
    private int forward = 5;
    private int stop = 3;

    @BeforeEach()
    void initGameService(){
        gameService = new GameService();
    }

    @Test
    @DisplayName("차 N개 생성 테스트")
    void 차_n개_생성_개수_테스트(){
        String carNames = "habi,son,kim,judy,teddy";
        Cars cars = gameService.makeCars(carNames);
        int num = cars.carListSize();
        assertThat(num).isEqualTo(5);
    }

    @Test
    @DisplayName("정상 로직 수행 - 단독 우승자")
    public void 정상_로직_수행(){
        assertRandomNumberInRangeTest(
                () -> {
                    run("tobi, judy, candy", "4");
                    assertThat(output()).contains("tobi : ----", "judy : -", "candy : --", "최종 우승자 : tobi");
                },
                9,8,7,5,0,3,6,2,4,9,1,1
        );
    }

    @Test
    @DisplayName("정상 로직 수행 - 공동 우승자")
    public void 공동_우승자_확인(){
        assertRandomNumberInRangeTest(
                () -> {
                    run("toto, hodu, dudu", "2");
                    assertThat(output()).contains("toto : --", "hodu : --", "dudu : ", "최종 우승자 : toto, hodu");
                },
                forward,forward,stop,forward,forward,stop
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
