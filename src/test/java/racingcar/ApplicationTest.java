package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.controller.GameController;
import racingcar.exception.GameException;
import racingcar.model.Car;
import racingcar.model.Game;
import racingcar.view.GameView;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 전진_정지() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
        );
    }

    @Test
    void 이름에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차_전진_확인(){
        Car car = new Car("carName");

        car.move(4,4);
        assertThat(car.getDistance()).isEqualTo(1);
    }

    @Test
    void 자동차_전진_예외(){
        Car car = new Car("carName");

        car.move(3,4);
        assertThat(car.getDistance()).isEqualTo(0);
    }

    @Test
    void 자동차_생성(){
        Game game = new Game();

        game.addCarList("carName1");
        assertThat(game.getCarList().size()).isEqualTo(1);
        assertThat(game.getCarList().get(0).getName()).isEqualTo("carName1");
        assertThat(game.getCarList().get(0).getDistance()).isEqualTo(0);

        game.addCarList("carName2");
        assertThat(game.getCarList().size()).isEqualTo(2);
        assertThat(game.getCarList().get(1).getName()).isEqualTo("carName2");
        assertThat(game.getCarList().get(1).getDistance()).isEqualTo(0);
    }

    @Test
    void 우승자_리스트_확인(){
        Game game = new Game();
        game.addCarList("carName1");
        game.addCarList("carName2");
        game.addCarList("carName3");
        List<Car> carList=game.getCarList();

        carList.get(0).move(5,4);
        carList.get(1).move(5,4);

        assertThat(game.getWinnerList()).contains("carName1","carName2");
    }

    @Test
    void 이름_5자_이상_예외_처리(){
        GameException gameException=new GameException();
        assertThatThrownBy(() -> gameException.checkNameLength("carName"));
    }

    @Test
    void 우승자_한명_출력(){
        Game game = new Game();
        game.addCarList("carName1");
        game.addCarList("carName2");
        game.addCarList("carName3");
        List<Car> carList=game.getCarList();

        carList.get(0).move(5,4);

        ByteArrayOutputStream output= new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        GameView gameView = new GameView();
        gameView.printWinner(game.getWinnerList());

        assertThat(output.toString()).isEqualTo("최종 우승자 : carName1");

    }

    @Test
    void 우승자_여러명_출력(){
        Game game = new Game();
        game.addCarList("carName1");
        game.addCarList("carName2");
        game.addCarList("carName3");
        List<Car> carList=game.getCarList();

        carList.get(0).move(5,4);
        carList.get(1).move(5,4);

        ByteArrayOutputStream output= new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        GameView gameView = new GameView();
        gameView.printWinner(game.getWinnerList());

        assertThat(output.toString()).isEqualTo("최종 우승자 : carName1, carName2");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
