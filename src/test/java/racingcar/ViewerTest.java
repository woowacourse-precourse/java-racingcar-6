package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.util.Car;
import racingcar.util.Round;
import racingcar.viewer.*;

public class ViewerTest {
    private PrintStream standardOut; // 표준 스트림

    protected void systemIn(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    @BeforeEach
    void setUp() {
        standardOut = System.out; // 표준 스트림 초기화
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    protected void printResult() {
        System.setOut(standardOut); // 표준 스트림 할당
    }

    @Test
    void Name_Request_정상범위_중복입력_테스트(){
        String normal_duplication_name = "pobi,minsu,jin,woni,pobi,pobi,jin,minsu,POBI";
        systemIn(normal_duplication_name);
        List<String> predicted_value_2 = new ArrayList<String>();
        predicted_value_2.add("pobi");
        predicted_value_2.add("minsu");
        predicted_value_2.add("jin");
        predicted_value_2.add("woni");
        predicted_value_2.add("POBI");
        List<String> result_2 = racingcar.viewer.Input_Viewer.Name_Request();
        assertEquals(result_2,predicted_value_2);
    }
    @Test
    void Name_Request_ERROR_테스트(){
        String error_name_1 = "";
        String error_name_2 = "asdfadasdff";
        assertSimpleTest(() ->
                assertThatThrownBy(() -> Error_Check.Name(error_name_1))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertSimpleTest(() ->
                assertThatThrownBy(() -> Error_Check.Name(error_name_2))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void Number_of_Play_Request_ERROR_테스트(){
        String error_num_1 = "";
        String error_num_2 = "asdfadasdff";
        String error_num_3 = "123511241241241224125";
        String error_num_4 = "-12352";
        String error_num_5 = "-123452352352355125125";
        assertSimpleTest(() ->
                assertThatThrownBy(() -> Error_Check.Number(error_num_1))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertSimpleTest(() ->
                assertThatThrownBy(() -> Error_Check.Number(error_num_2))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertSimpleTest(() ->
                assertThatThrownBy(() -> Error_Check.Number(error_num_3))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertSimpleTest(() ->
                assertThatThrownBy(() -> Error_Check.Number(error_num_4))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertSimpleTest(() ->
                assertThatThrownBy(() -> Error_Check.Number(error_num_5))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void Error_Round_테스트(){
        Round round= new Round(5,0);
        int current_round = round.Increase();
        assertEquals(current_round,1);
        current_round = round.Increase();
        assertEquals(current_round,2);
        current_round = round.Increase();
        assertEquals(current_round,3);
        current_round = round.Increase();
        assertEquals(current_round,4);
        current_round = round.Increase();
        assertEquals(current_round,5);
        assertSimpleTest(() -> {
                    assertThatThrownBy(round::Increase)
                            .isInstanceOf(IllegalArgumentException.class);
                }
        );
    }

    @Test
    void Status_테스트(){
        ByteArrayOutputStream outputMessage;
        outputMessage = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputMessage));

        Car car1 = new Car("pobi",1);
        Car car2 = new Car("min",2);
        List<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        Output_Viewer.Status(cars);
        assertEquals("pobi : -\r\n" +
                "min : --\r\n\r" +
                "\n", outputMessage.toString());
        System.setOut(System.out);
    }
    @Test
    void Winners_2명_승리_테스트(){
        ByteArrayOutputStream outputMessage;
        outputMessage = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputMessage));
        Car car1 = new Car("pobi",5);
        Car car2 = new Car("min",5);
        List<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        Output_Viewer.Winners(cars);
        assertEquals("최종 우승자 : pobi, min\r\n"
                , outputMessage.toString());
    }
}
