package racingcar.domain;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Application;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class CarTest extends NsTest {

    Car car1 = new Car("car1");
    Car car2 = new Car("car2");
    @AfterEach
    void setClear(){
        car1.clear();;
        car2.clear();
    }

    @Test
    @DisplayName("자동차는 한칸씩 전진해야 한다.")
    void 전진_테스트() {
        //given
        Car car1 = new Car("car1");
        String locate = "";

        //when
        for (int i = 0; i < 5; i++) {
            locate = car1.moveForward();
        }

        //then
        Assertions.assertThat(locate).isEqualTo("-----");
    }

    @Test
    @DisplayName("차가 두대 이상일 때, 전진 테스트")
    void 전진_테스트_2() {
        //given

        String locate1 = "";
        String locate2 = "";

        //when
        for (int i = 0; i < 3; i++) {
            locate1 = car1.moveForward();
        }
        for (int j = 0; j < 5; j++) {
            locate2 = car2.moveForward();
        }

        //then
        Assertions.assertThat(locate1.equals("---")).isEqualTo(true);
        Assertions.assertThat(locate2.equals("-----")).isEqualTo(true);

    }

    @Test
    @DisplayName("자동차가 정지하면 이동거리는 증가하지 않는다.")
    void 정지_테스트(){
        //given
        String locate1="";
        for(int i=0;i<2;i++){
            locate1=car1.moveForward();
        }

        //when
        locate1=car1.moveStop();

        //then
        Assertions.assertThat(locate1).isEqualTo("--");
    }

    @Test
    @DisplayName("자동차가 현재 위치를 알려줄 수 있다.")
    void 자동차_위치(){
        //given
        String distance="---";

        //when
        car1.moveForward();
        car1.moveForward();
        car1.moveForward();

        //then
        Assertions.assertThat(car1.located()).isEqualTo(distance.length());
    }

    @Test
    @DisplayName("자동차의 위치를 초기화한다.")
    void 자동차_초기화(){
        //given
        car1.moveForward();
        car1.moveForward();

        //when
        car1.clear();

        //then
        Assertions.assertThat(car1.located()).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차의 이름이 공백이면 예외를 발생한다.")
    void 이름_예외_처리(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,  ,hello ", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

}