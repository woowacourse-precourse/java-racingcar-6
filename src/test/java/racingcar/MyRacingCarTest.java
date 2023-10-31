package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import racingcar.Controller.GameController;
import racingcar.Model.CarModel;
import racingcar.Model.GameModel;
import racingcar.View.GameView;

public class MyRacingCarTest {



    @Test
    void 자동차_전진(){

        //given
        CarModel car = new CarModel("pobi");
        //when
        int beforeDistance = car.getForwardDistance();
        car.goForwardDistance();
        int afterDistance = car.getForwardDistance();
        //then
        assertThat(beforeDistance).isEqualTo(0);
        assertThat(afterDistance).isEqualTo(1);

    }
    @Test
    void 조건에_따라_전진(){

        //given
        CarModel car1 = new CarModel("pobi");
        CarModel car2 = new CarModel("woni");
        CarModel car3 = new CarModel("twinson");
        ArrayList<CarModel> carList = new ArrayList<>();
        carList.add(car1);
        GameController gameController = new GameController(new GameModel(), carList, new GameView());


        //when
        gameController.goForward(car1, 3);
        gameController.goForward(car2, 5);
        gameController.goForward(car3, 7);
        gameController.goForward(car3, 9);

        int car1Distance = car1.getForwardDistance();
        int car2Distance = car2.getForwardDistance();
        int car3Distance = car3.getForwardDistance();

        //then
        assertThat(car1Distance).isEqualTo(0);
        assertThat(car2Distance).isEqualTo(1);
        assertThat(car3Distance).isEqualTo(2);

    }

    @Test
    void 한명의_우승자_찾기(){

        GameModel gameModel =  new GameModel();
        CarModel car1 = new CarModel("pobi");
        CarModel car2 = new CarModel("woni");
        CarModel car3 = new CarModel("twinson");
        ArrayList<CarModel> carList = new ArrayList<>();
        carList.add(car1);
        carList.add(car2);
        carList.add(car3);

        GameController gameController = new GameController(gameModel, carList, new GameView());
        gameController.goForward(car1, 3);
        gameController.goForward(car2, 5);
        gameController.goForward(car3, 7);
        gameController.goForward(car3, 9);

        gameController.findWinner();
        ArrayList<CarModel> winner =  gameModel.getWinnerCar();

        assertThat(winner.get(0).getName()).isEqualTo("twinson");
    }

    @Test
    void 두명의_우승자_찾기(){

        GameModel gameModel =  new GameModel();
        CarModel car1 = new CarModel("pobi");
        CarModel car2 = new CarModel("woni");
        CarModel car3 = new CarModel("twinson");
        ArrayList<CarModel> carList = new ArrayList<>();
        carList.add(car1);
        carList.add(car2);
        carList.add(car3);

        GameController gameController = new GameController(gameModel, carList, new GameView());
        gameController.goForward(car1, 3);
        gameController.goForward(car2, 5);
        gameController.goForward(car2, 7);
        gameController.goForward(car3, 7);
        gameController.goForward(car3, 9);

        gameController.findWinner();
        ArrayList<CarModel> winner =  gameModel.getWinnerCar();

        assertThat(winner.get(0).getName()).isEqualTo("woni");
        assertThat(winner.get(1).getName()).isEqualTo("twinson");
    }
}
