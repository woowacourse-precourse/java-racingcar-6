package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.*;
import org.mockito.MockedStatic;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

public class CarsTest {

    private static MockedStatic<Randoms> randoms;
    private Cars cars;

    @BeforeAll
    static void beforeSetUp() {
        randoms = mockStatic(Randoms.class);
    }

    @AfterAll
    static void afterAll() {
        randoms.close();
    }

    @BeforeEach
    void init(){
        List<String> carNames = new ArrayList<>();
        carNames.add("car1");
        carNames.add("car2");
        carNames.add("car3");

        cars = new Cars(carNames);
    }

    @Test
    @DisplayName("입력한 자동차 이름으로 자동차 생성에 성공한다.")
    void TestCreateCar(){
        assertThat(cars.getCars().size()).isEqualTo(3);
        assertThat(cars.getCars().get(0).getName()).isEqualTo("car1");
    }

    @Test
    @DisplayName("자동차의 위치를 비교하여 우승자를 결정한다.(우승자가 한 명인 경우)")
    void TestDetermineSingleWinner(){
        randoms.when(()-> Randoms.pickNumberInRange(anyInt(), anyInt())).thenReturn(1,1,5);
        cars.playOneRound();
        cars.playOneRound();

        List<String> winners = cars.findWinners();
        assertThat(winners.size()).isEqualTo(1);
        assertThat(winners.get(0)).isEqualTo("car3");
    }

    @Test
    @DisplayName("자동차의 위치를 비교하여 우승자를 결정한다.(우승자가 여러 명인 경우) ")
    void TestDetermineGetWinners(){

        randoms.when(()-> Randoms.pickNumberInRange(anyInt(), anyInt())).thenReturn(1,5,5);
        cars.playOneRound();
        cars.playOneRound();

        List<String> winners = cars.findWinners();
        assertThat(winners.size()).isEqualTo(2);
        assertThat(winners.get(0)).isEqualTo("car2");
        assertThat(winners.get(1)).isEqualTo("car3");
    }
}
