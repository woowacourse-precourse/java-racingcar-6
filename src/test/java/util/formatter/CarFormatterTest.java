package util.formatter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static resource.TestData.CAR_NAME_1;
import static resource.TestData.CAR_NAME_2;
import static resource.TestData.CAR_NAME_3;
import static resource.TestData.COMMA_WITH_SPACE;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.model.CarPlayerModel;

public class CarFormatterTest {
    @Test
    public void formatPlayerToString_메서드_정상적인_입력() {
        CarPlayerModel player = new CarPlayerModel(CAR_NAME_1);
        CarFormatter formatter = new CarFormatter();
        String result = formatter.formatPlayerToString(player);
        assertEquals(CAR_NAME_1, result);
    }

    @Test
    public void formatPlayerToString_메서드_null_입력() {
        CarPlayerModel player = null;
        CarFormatter formatter = new CarFormatter();
        assertThrows(NullPointerException.class, () -> formatter.formatPlayerToString(player));
    }

    @Test
    public void formatStringToPlayer_메서드_정상적인_입력() {
        String string = CAR_NAME_1;
        CarFormatter formatter = new CarFormatter();
        CarPlayerModel result = formatter.formatStringToPlayer(string);
        assertEquals(string, result.getCarName());
    }

    @Test
    public void formatListPlayersToListString_메서드_정상적인_입력() {
        CarPlayerModel player1 = new CarPlayerModel(CAR_NAME_1);
        CarPlayerModel player2 = new CarPlayerModel(CAR_NAME_2);
        CarPlayerModel player3 = new CarPlayerModel(CAR_NAME_3);
        CarFormatter formatter = new CarFormatter();
        String expectedResult = Arrays.asList(CAR_NAME_1, CAR_NAME_2, CAR_NAME_3).toString();
        String result = formatter.formatListPlayersToListString(Arrays.asList(player1, player2, player3)).toString();
        assertEquals(expectedResult, result);
    }

    @Test
    public void formatListPlayersToListString_null_입력() {
        List<CarPlayerModel> players = null;
        CarFormatter formatter = new CarFormatter();
        assertThrows(NullPointerException.class, () -> formatter.formatListPlayersToListString(players));
    }

    @Test
    public void formatListPlayersToString_메서드_정상적인_입력() {
        CarPlayerModel player1 = new CarPlayerModel(CAR_NAME_1);
        CarPlayerModel player2 = new CarPlayerModel(CAR_NAME_2);
        CarPlayerModel player3 = new CarPlayerModel(CAR_NAME_3);
        CarFormatter formatter = new CarFormatter();
        String expectedResult = CAR_NAME_1+COMMA_WITH_SPACE+CAR_NAME_2+COMMA_WITH_SPACE+CAR_NAME_3;
        String result = formatter.formatListPlayersToString(Arrays.asList(player1, player2, player3));
        assertEquals(expectedResult, result);
    }

    @Test
    public void formatListPlayersToString_null_입력() {
        List<CarPlayerModel> players = null;
        CarFormatter formatter = new CarFormatter();
        assertThrows(NullPointerException.class, () -> formatter.formatListPlayersToString(players));
    }

    @Test
    public void formatListStringToListPlayers_메서드_정상적인_입력() {
        CarFormatter formatter = new CarFormatter();
        List<String> carNameList = Arrays.asList(CAR_NAME_1, CAR_NAME_2, CAR_NAME_3);
        List<CarPlayerModel> cars = formatter.formatListStringToListPlayers(carNameList);
        List<String> result = cars.stream().map(CarPlayerModel::getCarName).toList();
        assertEquals(carNameList.toString(), result.toString());
    }

    @Test
    public void formatListStringToListPlayers_null_입력() {
        List<String> strings = null;
        CarFormatter formatter = new CarFormatter();
        assertThrows(NullPointerException.class, () -> formatter.formatListStringToListPlayers(strings));
    }
}
