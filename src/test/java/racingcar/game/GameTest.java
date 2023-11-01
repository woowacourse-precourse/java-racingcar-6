package racingcar.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.car.Car;
import racingcar.player.Player;
import racingcar.util.Validator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class GameTest {
    @Test
    @DisplayName("사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다")
    void 이동횟수_입력() throws Exception {
        // given
        Game game = new Game();
        String expectValue = "3";

        // when
        game.setMoveCnt("3");

        // then
        assertThat(game.getMoveCnt()).isEqualTo(Integer.parseInt(expectValue));
    }

    @Test
    @DisplayName("자동차 이름은 쉼표(,)를 기준으로 구분")
    void 자동차이름_쉼표로_구분() throws Exception {
        //given
        Player player = new Player();
        String[] expectValue = {"pobi", "woni", "jun"};

        //when
        String carNames = "pobi,woni,jun";

        //then
        assertThat(player.parseCarNamesFromInput(carNames)).isEqualTo(expectValue);
    }

    @Test
    @DisplayName("자동차 이름은 5자 초과시 IllegalArgumentException 발생")
    void 자동차_이름_5자_초과시_예외발생() throws Exception {
        //given
        Player player = new Player();

        //when
        String carNames = "pobiiii,woni,junnnn";

        //then
        assertThatThrownBy(() -> {
            if (Validator.validateCarNames(player.parseCarNamesFromInput(carNames)) == false) {
                throw new IllegalArgumentException();
            }
        }).isInstanceOf(IllegalArgumentException.class);

    }



    @Test
    @DisplayName("자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다")
    void 경주_우승자_확인() throws Exception {
        //given
        Game game = new Game();
        Car pobiCar = new Car("pobi");
        Car woniCar = new Car("woni");
        Car junCar = new Car("jun");

        // when
        pobiCar.move();
        pobiCar.move();
        woniCar.move();
        junCar.move();

        game.getCarList().add(pobiCar);
        game.getCarList().add(woniCar);
        game.getCarList().add(junCar);

        //then
        assertThat(game.getWinner(2)).isEqualTo("pobi");
    }


    @Test
    @DisplayName("우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다")
    void d() throws Exception {
        //given
        Game game = new Game();
        Car pobiCar = new Car("pobi");
        Car woniCar = new Car("woni");
        Car junCar = new Car("jun");

        // when
        pobiCar.move();
        pobiCar.move();
        woniCar.move();
        woniCar.move();
        junCar.move();

        game.getCarList().add(pobiCar);
        game.getCarList().add(woniCar);
        game.getCarList().add(junCar);

        //then
        assertThat(game.getWinner(2)).isEqualTo("pobi, woni");
    }
}
