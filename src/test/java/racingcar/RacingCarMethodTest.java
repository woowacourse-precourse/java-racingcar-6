package racingcar;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarMethodTest {

    @Test
    void isCarnameTooLong_메서드에_길이제한을_초과한_입력이_있을_시_true를_반환(){

        //Arrange
        List<String> inputList = List.of("pobi", "woni", "javajigi");
        int inputMaxLength = 5;

        //Act
        var result = Application.isCarnameTooLong(inputList, inputMaxLength);

        //Assert
        assertThat(result).isEqualTo(true);
    }

    @Test
    void determineGoOrStop_메서드에_4_이상의_값이_입력될_경우_key값의_value를_1만큼_증가(){

        //Arrange
        Map<String, Integer> carMap = new HashMap<>();
        String testCar = "testCar";
        carMap.put(testCar, 1);

        //Act
        Application.determineGoOrStop(carMap, testCar, 5);
        var result = carMap.get(testCar);

        //Assert
        assertThat(result).isEqualTo(2);
    }

    @Test
    void determineGoOrStop_메서드에_3_이하의_값이_입력될_경우_key값의_value를_유지(){

        //Arrange
        Map<String, Integer> carMap = new HashMap<>();
        String testCar = "testCar";
        carMap.put(testCar, 1);

        //Act
        Application.determineGoOrStop(carMap, testCar, 2);
        var result = carMap.get(testCar);

        //Assert
        assertThat(result).isEqualTo(1);
    }

    @Test
    void printRacingState_메서드는_전달받은_Map의_key값과_value만큼의_전진을_출력(){

        //Arrange
        Map<String, Integer> carMap = new HashMap<>();
        String testCar = "testCar";
        carMap.put(testCar, 4);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        //Act
        Application.printRacingState(carMap, testCar);

        String expectedOutput = "testCar : ----";
        String result = outContent.toString().trim();

        //Assert
        assertThat(result).isEqualTo(expectedOutput);
    }

    @Test
    void decideWinners_메서드는_전달받은_Map에서_최대값을_가진_key의_리스트를_String으로_변환하여_반환(){

        //Arrange
        Map<String, Integer> carMap = new HashMap<>();
        carMap.put("firstCar", 5);
        carMap.put("secondCar", 4);
        carMap.put("thirdCar", 3);
        carMap.put("fourthCar", 1);

        //Act
        String result = Application.decideWinners(carMap);

        //Assert
        assertThat(result).isEqualTo("firstCar");
    }

    @Test
    void decideWinners_메서드는_최대값을_가진_key가_여러개일_경우_알파벳_순서의_리스트를_String으로_변환하여_반환(){

        //Arrange
        Map<String, Integer> carMap = new HashMap<>();
        carMap.put("firstCar", 5);
        carMap.put("anotherFirstCar", 5);
        carMap.put("thirdCar", 3);
        carMap.put("fourthCar", 1);

        //Act
        String result = Application.decideWinners(carMap);

        //Assert
        assertThat(result).isEqualTo("anotherFirstCar, firstCar");
    }
}
