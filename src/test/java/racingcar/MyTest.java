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
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MyTest extends NsTest {
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
    void 전진_결과_출력_확인(){
        Game game = new Game();
        game.addCarList("carName1");
        game.addCarList("carName2");
        game.addCarList("carName3");
        List<Car> carList=game.getCarList();

        carList.get(0).move(5,4);
        carList.get(0).move(5,4);
        carList.get(1).move(5,4);

        ByteArrayOutputStream output= new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        GameView.printCarResult(game);

        assertThat(output.toString()).isEqualTo("carName1 : --\n" +
                "carName2 : -\n" +
                "carName3 : \n"+"\n");
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
    void 입력값이_정수인지_확인(){
        GameException gameException=new GameException();
        int input=gameException.checkInput("2");
        assertThat(input).isEqualTo(2);
    }

    @Test
    void 입력값이_정수인지_예외_처리(){
        GameException gameException=new GameException();
        assertThatThrownBy(() -> gameException.checkInput("a"));
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

        GameView.printWinner(game.getWinnerList());

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

        GameView.printWinner(game.getWinnerList());

        assertThat(output.toString()).isEqualTo("최종 우승자 : carName1, carName2");
    }

    @Test
    void 입력_자동차이름_구분(){
        GameController gameController = new GameController();

        String input = "carName1,carName2,carName3";
        String[] result=gameController.splitInput(input,",");

        assertThat(result).contains("carName1","carName2","carName3");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}