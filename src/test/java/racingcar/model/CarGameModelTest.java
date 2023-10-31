package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static resource.TestData.CAR_NAME_1;
import static resource.TestData.CAR_NAME_2;
import static resource.TestData.ONE;
import static resource.TestData.ZERO;

import java.util.List;
import org.junit.jupiter.api.Test;

public class CarGameModelTest {
    @Test
    void getWinners_가장_멀리_간_자동자_우승여부(){
        CarPlayerModel player1 = new CarPlayerModel(CAR_NAME_1);
        CarPlayerModel player2 = new CarPlayerModel(CAR_NAME_2);
        while(player1.getCurrentPosition() > ZERO){
            player1.move();
        }
        CarGameModel game = new CarGameModel(List.of(player1, player2), ONE);
        assertEquals(game.getWinners().get(ZERO).getCarName(), CAR_NAME_1);
    }
}
