package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.player.User;
import static org.assertj.core.api.Assertions.*;

public class DomainFeatureTest extends NsTest {

    @Test
    void 정상적으로_유저_객체가_생성_되는지() {
        String Name = "홍용재";
        User user = new User(Name);
        assertThat(user).isNotNull(); // 객체가 null이 아닌지 확인
        assertThat(user.getUserName()).isEqualTo(Name); // 이름이 예상과 일치하는지 확인
    }
    @Test
    void 생성된_객체의_전진거리가_0_인지(){
        String Name = "홍용재";
        User user = new User(Name);
        assertThat(user.getForwardDistance()).isEqualTo(0);
    }

    @Test
    void 유저_이름이_정상적으로_삽입_되는지_확인() {
        String Name = "홍용재";
        User user = new User(Name);
        assertThat(user.getUserName()).isEqualTo(Name); // 이름이 예상과 일치하는지 확인
    }

    @Test
    void  전진거리가_정상적으로_객체에_삽입_되는지() {
        String Name = "홍용재";
        User user = new User(Name);
        user.forward();
        assertThat(user.getForwardDistance()).isEqualTo(1);
    }


    @Override
    protected void runMain() {
        Application.main( new String[] {});
    }
}
