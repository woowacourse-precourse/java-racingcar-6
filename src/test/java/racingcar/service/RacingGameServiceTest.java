package racingcar.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.common.Message;
import racingcar.entity.Car;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingGameServiceTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    RacingGameServiceStub racingGameService = new RacingGameServiceStub();
    boolean correctInput;


    @BeforeEach
    void cleanUp() {
        System.setOut(new PrintStream(outContent));
        racingGameService.init();
        correctInput = true;
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void 메인_시퀸스_검증_동작0회종료() {
        // given
        racingGameService.remainChance = 0;
        String result = "";

        // when
        racingGameService.mainSequence();

        // then
        assertThat(outContent.toString()).isEqualTo(result);
    }

    @Test
    void 메인_시퀸스_검증_동작1회() {
        // given
        racingGameService.remainChance = 1;
        String result = "자동차목록_정상출력0\n";

        // when
        racingGameService.mainSequence();

        // then
        assertThat(outContent.toString()).isEqualTo(result);
    }

    @Test
    void 종료_시퀸스_검증_승자1명() {
        // given
        Car car = new Car("yujin");
        car.move();
        racingGameService.entry = List.of(car);
        racingGameService.maxDistance = 1;
        String result = Message.WINNER.getMessage() + "yujin" + "\n";

        // when
        racingGameService.endSequence();

        // then
        assertThat(outContent.toString()).isEqualTo(result);
    }

    @Test
    void 종료_시퀸스_검증_승자0명() {
        // given
        Car car = new Car("yujin");
        racingGameService.entry = List.of(car);
        racingGameService.maxDistance = 1;
        String result = Message.WINNER.getMessage() + "\n";

        // when
        racingGameService.endSequence();

        // then
        assertThat(outContent.toString()).isEqualTo(result);
    }

    @Test
    void 자동차_설정_정상_등록() {
        correctInput = true;
        String[] result = new String[]{"yujin", "rei"};

        assertThat(racingGameService.getCarsNameReplaced(correctInput))
                .containsExactly(result);
    }

    @Test
    void 자동차_설정_등록_실패_잘못된_이름() {
        correctInput = false;

        assertThatThrownBy(() -> racingGameService.getCarsNameReplaced(correctInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 게임_횟수_설정_성공() {
        correctInput = true;

        assertThat(racingGameService.getPlayCountReplaced(correctInput))
                .isEqualTo(1);
    }

    @Test
    void 게임_횟수_설정_실패_잘못된입력() {
        correctInput = false;

        assertThatThrownBy(() -> racingGameService.getPlayCountReplaced(correctInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 최대_이동거리_계산_성공_거리3() {
        Car car = new Car("test1");
        for (int i = 0; i < 3; i++) {
            car.move();
        }
        racingGameService.entry.add(car);
        racingGameService.entry.add(new Car("test2"));
        racingGameService.entry.add(new Car("test3"));

        assertThat(racingGameService.getMaxDistance())
                .isEqualTo(3);
    }

    @Test
    void 최대_이동거리_계산_빈엔트리() {
        assertThat(racingGameService.getMaxDistance())
                .isEqualTo(0);
    }

    private static class RacingGameServiceStub {
        private int remainChance;
        private List<Car> entry;
        private int maxDistance;

        private void init() {
            entry = new ArrayList<>();
            remainChance = 0;
            maxDistance = 1;
        }

        private void mainSequence() {
            while (remainChance > 0) {
//                movingSequence();
                remainChance--;
                System.out.println("자동차목록_정상출력" + remainChance);
            }
        }

        private void endSequence() {
            List<String> winners = entry.stream()
                    .filter(car -> car.getDistance() == maxDistance)
                    .map(Car::getName).toList();

            System.out.println(Message.WINNER.getMessage() + String.join(", ", winners));
        }

        private void setCars(boolean cond) {
//            outputView.printMessage(Message.START);
            getCarsNameReplaced(cond).forEach(name -> entry.add(new Car(name)));
        }

        private List<String> getCarsNameReplaced(boolean cond) {
            if (cond) {
                return List.of(new String[]{"yujin", "rei"});
            }
            throw new IllegalArgumentException();
        }

        private void setRemainChange(boolean cond) {
//            outputView.printMessage(Message.COUNT);
            remainChance = getPlayCountReplaced(cond);
        }

        private int getPlayCountReplaced(boolean cond) {
            if (cond) {
                return 1;
            }
            throw new IllegalArgumentException();
        }

        private int getMaxDistance() {
            int max = 0;

            for (Car car : entry) {
                max = Math.max(max, car.getDistance());
            }
            return max;
        }

    }

}