package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.domain.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.constant.ErrorMessage.CAR_NAME_BLANK_ERROR_MESSAGE;
import static racingcar.constant.ErrorMessage.CAR_NAME_LENGTH_ERROR_MESSAGE;

import racingcar.domain.car;
import racingcar.domain.cars;
import racingcar.io.OutputView;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

class ApplicationTest extends NsTest {

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @Test
    void 자동차_객체_생성_기능_단일() {
        car car = new car("john");
        assertThat("john").isEqualTo(car.getName());
        assertThat(0).isEqualTo(car.getPosition());
    }

    @Test
    void 자동차_정보_입력_기능_단체() {
        String carNames = "jamy,risa,jun";
        cars cars = racingcar.domain.cars.fromCarNames(carNames);
        List<car> currentStatus = cars.getCurrentStatus();

        Assertions.assertEquals(currentStatus.get(0).getName(), "jamy");
        Assertions.assertEquals(currentStatus.get(1).getName(), "risa");
        Assertions.assertEquals(currentStatus.get(2).getName(), "jun");
    }

    @Test
    void 자동차_이름_길이_5자_제한_기능_단일() {
        List<String> fiveLengthOverName = List.of("abcdef", "aifhiawkgha", "awhdfaighkwuhgakhgka", "asdfakhfkah",
                "adwlafla");
        for (String name : fiveLengthOverName) {
            assertThatThrownBy(() -> car.fromName(name))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(CAR_NAME_LENGTH_ERROR_MESSAGE);
            }
        }

        @Test
        void 자동차_이름_길이_5자_제한_기능_단체() {
            String carNames = "jamiiaa,risa,jun";
            assertThatThrownBy(() -> cars.fromCarNames(carNames))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(CAR_NAME_LENGTH_ERROR_MESSAGE);
        }

        @Test
        void 자동차_이름_예외_공백() {
            List<String> blankCarNames = List.of("", " ", " , ", ",", ", ", " ,");
            for (String blankCarName : blankCarNames) {
                assertThatThrownBy(() -> cars.fromCarNames(blankCarName))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(CAR_NAME_BLANK_ERROR_MESSAGE);
            }
        }

        @Test
        void 이동_시도_횟수_입력() {
            Racing racing = new Racing("1");
            assertThat(1).isEqualTo(racing.getCount());
        }

        @Test
        void 이동_시도_횟수_입력_실패_문자열_처리() {
            assertThatThrownBy(() -> new Racing("abc"))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void 이동_시도_횟수_입력_실패_공백_처리() {
            List<String> blanks = List.of(" ", "");
            for (String blank : blanks) {
                assertThatThrownBy(() -> new Racing(blank))
                        .isInstanceOf(IllegalArgumentException.class);
            }
        }

        @Test
        void 이동_시도_출력() {
            PrintStream originalOut = System.out;
            try {
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                System.setOut(new PrintStream(outputStream));

                String carNames = "jamy,risa,jun";
                cars cars = racingcar.domain.cars.fromCarNames(carNames);

                OutputView outputView = new OutputView();
                for (car car : cars.tryToMove()) {
                    outputView.printCarPosition(car.getName(), car.getPosition());
                }

                List<String> expectedOutputs = List.of("jamy : ", "risa : ", "jun : ");
                String actualOutput = outputStream.toString();

                assertThat(actualOutput).contains(expectedOutputs);


            } finally {
                System.setOut(originalOut);
            }
        }
        @Test
        void 우승자_도출() {

            car car1 = new car("car1");
            car car2 = new car("car2");
            car car3 = new car("car3");
            car2.move();
            car3.move();
            List<car> cars = new ArrayList<>(List.of(car1, car2, car3));

            Winner Winner = new Winner();

            assertThat(Winner.judgeWinner(cars)).containsOnly(car2.name, car3.name);
        }

    }

