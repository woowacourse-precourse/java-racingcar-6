package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.*;
import racingcar.domain.Car;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewTest extends InputSetting{
    private static InputView inputView;
    @BeforeAll
    public static void initializer(){
        inputView = new InputView();
    }

    @AfterEach
    public void closeScanner(){
        Console.close();
    }
    @Test
    @DisplayName("자동차_이름_입력_테스트")
    public void inputNameTest() {
        // given
        List<Car> cars = new ArrayList<>();
        List<String> names = new ArrayList<>();
        systemIn("pobie,woni,jun");
        // when
        inputView.inputName(cars);
        Integer carsSize = cars.size();
        for(Car car : cars){
            names.add(car.getName());
        }
        // then
        assertThat(carsSize).isEqualTo(3);
        assertThat(names).containsExactly("pobie","woni","jun");
    }

    @Test
    @DisplayName("자동차_이름_입력_Null_입력_테스트")
    public void null_inputNameExceptionTest(){
        // given
        List<Car> cars = new ArrayList<>();
        systemIn("\n");
        // when,then
        assertThatThrownBy(() -> inputView.inputName(cars))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Input Error: Car Name is Null");
    }

    @Test
    @DisplayName("자동차_이름_입력_공백_포함_테스트")
    public void space_inputNameExceptionTest(){
        // given
        List<Car> cars = new ArrayList<>();
        systemIn("pobie, woni,jun");
        // when,then
        assertThatThrownBy(() -> inputView.inputName(cars))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Input Error: Invalid space condition");
    }

    @Test
    @DisplayName("자동차_이름_입력_최대_길이_테스트")
    public void maxLength_inputNameExceptionTest(){
        // given
        List<Car> cars = new ArrayList<>();
        systemIn("pobie,seolhuigwan");
        // when,then
        assertThatThrownBy(() -> inputView.inputName(cars))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Input Error: Invalid name length");
    }

    @Test
    @DisplayName("자동차_이름_입력_최소_길이_테스트")
    public void minLength_inputNameExceptionTest(){
        // given
        List<Car> cars = new ArrayList<>();
        systemIn("pobie,,woni");
        // when,then
        assertThatThrownBy(() -> inputView.inputName(cars))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Input Error: Invalid name length");
    }

    @Test
    @DisplayName("자동차_이름_입력_최소_개수_테스트")
    public void minCount_inputNameExceptionTest(){
        // given
        List<Car> cars = new ArrayList<>();
        systemIn("pobie");
        // when,then
        assertThatThrownBy(() -> inputView.inputName(cars))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Input Error: Invalid the minimum number of cars");
    }
    @Test
    @DisplayName("이동_횟수_입력_테스트")
    void inputMoveCount() {
        // given
        systemIn("5");
        // when
        Integer moveCount = inputView.inputMoveCount();
        // then
        assertThat(moveCount).isEqualTo(5);
    }

    @Test
    @DisplayName("이동_횟수_입력_Null_테스트")
    void null_inputMoveCount() {
        // given
        systemIn("\n");
        // when,then
        assertThatThrownBy(() -> inputView.inputMoveCount())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Input Error: moveCount is Null");
    }

    @Test
    @DisplayName("이동_횟수_입력_숫자형_테스트")
    void numeric_inputMoveCount() {
        // given
        systemIn("\n");
        // when,then
        assertThatThrownBy(() -> inputView.inputMoveCount())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Input Error: moveCount is Null");
    }

    @Test
    @DisplayName("이동_횟수_입력_최솟값_테스트")
    void minCount_inputMoveCount() {
        // given
        systemIn("0");
        // when,then
        assertThatThrownBy(() -> inputView.inputMoveCount())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Input Error: Invalid the minimum number of moveCount");
    }
}