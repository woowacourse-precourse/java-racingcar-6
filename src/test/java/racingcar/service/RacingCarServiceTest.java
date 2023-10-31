package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.CarList;
import racingcar.validation.RacingCarValidation;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.List;

import static java.lang.System.setIn;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingCarServiceTest {

    public RacingCarService racingCarService;

    public RacingCarServiceTest() {
        this.racingCarService = new RacingCarService(new CarList(), new RacingCarValidation());
    }

    @AfterEach
    public void consoleClose(){
        Console.close();
    }

    @Test
    @DisplayName("경기 횟수 입력(숫자) - 성공")
    public void read_count_success() {
        //given
        String inputCount = "5";
        setIn(new ByteArrayInputStream(inputCount.getBytes()));

        //when
        int count = racingCarService.readCount();

        //then
        assertThat(count).isEqualTo(Integer.parseInt(inputCount));

        Console.close();
    }

    @Test
    @DisplayName("경기 횟수 입력(숫자x) - 실패")
    public void read_count_no_digit_fail() {
        //given
        String inputCount = "noDigit";
        setIn(new ByteArrayInputStream(inputCount.getBytes()));

        //when&then
        assertThatThrownBy(() -> racingCarService.readCount())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("해당 값은 숫자여야 합니다.");

    }

    @Test
    @DisplayName("경기 횟수 입력(범위 밖) - 실패")
    public void read_count_out_range_fail() {
        //given
        String inputCount = "10001";
        setIn(new ByteArrayInputStream(inputCount.getBytes()));

        //when&then
        assertThatThrownBy(() -> racingCarService.readCount())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("해당 값은 범위 내에서 실행할 수 없는 값입니다. (1 ~ 10000)");

    }

    @Test
    @DisplayName("Car 이름 입력 - 성공")
    public void create_car_list_success() {
        //given
        String inputNameList = "L,K,H";
        setIn(new ByteArrayInputStream(inputNameList.getBytes()));

        //when
        CarList carList = racingCarService.createCarList();

        //then
        List<String> nameList = Arrays.stream(inputNameList.split(",")).toList();

        for (int i = 0; i < nameList.size(); i++)
            assertThat(nameList.get(i)).isEqualTo(carList.getCarList().get(i).getName());

    }


    @Test
    @DisplayName("Car 이름 입력(길이 초과) - 실패")
    public void create_car_list_out_range_fail() {
        //given
        String inputNameList = "L,Korea,HH2kk1";
        setIn(new ByteArrayInputStream(inputNameList.getBytes()));

        //when&then
        assertThatThrownBy(() -> racingCarService.createCarList())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("해당 이름은 크키가 5 초과입니다.");

    }


    @Test
    @DisplayName("Car 이름 입력(이름 중복) - 실패")
    public void create_car_list_duplicate_name_fail() {
        //given
        String inputNameList = "Lee,Korea,K,Lee,Hun";
        String duplicateName = "Lee";
        setIn(new ByteArrayInputStream(inputNameList.getBytes()));

        //when&then
        assertThatThrownBy(() -> racingCarService.createCarList())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 이름입니다. : " + duplicateName);

    }


    @Test
    @DisplayName("Car 이름 입력(공백) - 실패")
    public void create_car_list_blank_name_fail() {
        //given
        String inputNameList = "Lee, ";
        setIn(new ByteArrayInputStream(inputNameList.getBytes()));

        //when&then
        assertThatThrownBy(() -> racingCarService.createCarList())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 공백이 될 수 없습니다.");

    }

}