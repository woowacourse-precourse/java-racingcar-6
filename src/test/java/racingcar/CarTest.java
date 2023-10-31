package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.*;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    @Test
    @DisplayName("move 메소드에서 randomNumber가 4일 경우 distance 1 추가")
    void move_메소드에서_randomNumber가_4일_경우_distance_1_추가() {
        try (MockedStatic<Randoms> mock = Mockito.mockStatic(Randoms.class)) {
            //given
            Car car = new Car("pobi");
            mock.when(() -> Randoms.pickNumberInRange(0, 9)).thenReturn(4);
            //when
            car.move();
            //then
            assertThat(car.getDistance()).isEqualTo(1);
        }
    }

    @Test
    @DisplayName("move 메소드에서 randomNumber가 9일 경우 distance 1 추가")
    void move_메소드에서_randomNumber가_9일_경우_distance_1_추가() {
        try (MockedStatic<Randoms> mock = Mockito.mockStatic(Randoms.class)) {
            //given
            Car car = new Car("pobi");
            mock.when(() -> Randoms.pickNumberInRange(0, 9)).thenReturn(9);
            //when
            car.move();
            //then
            assertThat(car.getDistance()).isEqualTo(1);
        }
    }

    @Test
    @DisplayName("move 메소드에서 randomNumber가 3일 경우 distance 추가하지 않음")
    void move_메소드에서_randomNumber가_3일_경우_distance_미추가() {
        try (MockedStatic<Randoms> mock = Mockito.mockStatic(Randoms.class)) {
            //given
            Car car = new Car("pobi");
            mock.when(() -> Randoms.pickNumberInRange(0, 9)).thenReturn(3);
            //when
            car.move();
            //then
            assertThat(car.getDistance()).isEqualTo(0);
        }
    }

    @Test
    @DisplayName("move 메소드에서 randomNumber가 0일 경우 distance 추가하지 않음")
    void move_메소드에서_randomNumber가_0일_경우_distance_미추가() {
        try (MockedStatic<Randoms> mock = Mockito.mockStatic(Randoms.class)) {
            //given
            Car car = new Car("pobi");
            mock.when(() -> Randoms.pickNumberInRange(0, 9)).thenReturn(0);
            //when
            car.move();
            //then
            assertThat(car.getDistance()).isEqualTo(0);
        }
    }

    @Nested
    class ForTestprintDistanceStatus {
        private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        private final PrintStream originalOut = System.out;

        @BeforeEach
        public void setUpStreams() {
            System.setOut(new PrintStream(outContent));
        }

        @AfterEach
        public void restoreStreams() {
            System.setOut(originalOut);
        }

        @Test
        @DisplayName("printDistanceStatus메소드에서 carName과 distance 정상 출력되는지 확인")
        void printDistanceStatus_메소드에서_carName과_distance_정상_출력_확인() {
            //given
            Car car = new Car("pobi");
            car.move();
            car.move();
            car.move();
            //when
            car.printDistanceStatus();
            //then
            assertThat(outContent.toString())
                    .isEqualTo(car.getName() + " : " + "-".repeat(car.getDistance()) + "\n");
        }
    }


}