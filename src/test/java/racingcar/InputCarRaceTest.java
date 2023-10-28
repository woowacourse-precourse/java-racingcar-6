package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import org.junit.jupiter.api.Test;

public class InputCarRaceTest {
    private static final String 공백차이름 = "";
    private static String 차이름들;
    private static String 차이름;
    private static String 사용자_이동_횟수 = "";

    private static void 공백을_입력하라(){
        차이름 = "";
    }

    private static void 중복된_차이름을_입력하라() {
        InputCarRace.carNames = Arrays.asList("pobi1","pobi2","pobi2");
    }

    private static void 차이름을_6자리이상_입력하라() {
        차이름 = "pobido";
    }

    private static void 차이름_n개_입력하라(int count){
        차이름 = "";
        InputCarRace.carNames = new ArrayList<>();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < count; i++) {
            sb.append(i).append(",");
        }

        차이름들 = sb.toString();
    }

    public void 사용자_이동_횟수를_입력하라(){
        this.사용자_이동_횟수 = "1000000";
    }

    public void 사용자_이동_횟수_예외를_입력하라(){
        this.사용자_이동_횟수 = "ㄱ%12ㅍㄴ";
    }

    static class InputCarRace{
        private static List<String> carNames = new ArrayList<>();
        private static int moveCount = 0;

        public static InputCarRace inputMove(String stringMoveCount){
            validateOnlyNumber(stringMoveCount);
            moveCount = Integer.parseInt(stringMoveCount);

            return new InputCarRace();
        }

        private static void validateOnlyNumber(String stringMoveCount) {
            if (isOnlyNumber(stringMoveCount)) {
                throw new IllegalArgumentException("입력하신 내용엔 숫자외 값이 포함되었습니다.");
            }
        }

        private static boolean isOnlyNumber(String stringMoveCount){
            return !stringMoveCount.matches("[0-9]+");
        }

        public static InputCarRace inputCarNames(String stringCarNames){
            StringTokenizer st = new StringTokenizer(stringCarNames,",");

            while(st.hasMoreTokens()){
                String carName = st.nextToken();
                validateCarName(carName);
                carNames.add(carName);
            }

            validateDuplicateCarNames();
            return new InputCarRace();
        }

        private InputCarRace(){

        }

        private static void validateCarName(String carName){
            validateUnderFiveLength(carName);
            validateWhiteSpace(carName);
        }

        private static void validateUnderFiveLength(String carName) {
            if(isOverSixLength(carName)){
                throw new IllegalArgumentException("입력하신 차량 이름이 6자를 넘었습니다.");
            }
        }

        private static void validateWhiteSpace(String carName) {
            if(isWhiteSpace(carName)){
                throw new IllegalArgumentException("입력하신 차량은 공백입니다.");
            }
        }

        private static void validateDuplicateCarNames() {
            if(isDuplicateCarNames()){
                throw new IllegalArgumentException("입력하신 차량은 중복되었습니다.");
            }
        }

        private static boolean isOverSixLength(String carName){
            return carName.length() >= 6;
        }

        private static boolean isWhiteSpace(String carName) {
            return carName.isBlank();
        }

        private static boolean isDuplicateCarNames() {
            return carNames.size() != carNames.stream().distinct().count();
        }

    }

    @Test
    void 자동차이름_쉼표_구분_정상(){
        차이름_n개_입력하라(1000);

        InputCarRace.inputCarNames(차이름들);

        assertThat(InputCarRace.carNames.size()).isEqualTo(1000);
    }

    @Test
    void 자동차이름_6자리이상_입력_예외처리(){
        차이름을_6자리이상_입력하라();

        assertSimpleTest(() ->
                assertThatThrownBy(() -> InputCarRace.validateUnderFiveLength(차이름))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차이름_중복입력_예외처리(){
        중복된_차이름을_입력하라();

        assertSimpleTest(() ->
                assertThatThrownBy(() -> InputCarRace.validateDuplicateCarNames())
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차이름_공백입력_예외처리(){
        공백을_입력하라();

        assertSimpleTest(() ->
                assertThatThrownBy(() -> InputCarRace.validateWhiteSpace(차이름))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 사용자이름_입력_정상(){
        사용자_이동_횟수를_입력하라();

        InputCarRace.inputMove(사용자_이동_횟수);

        assertThat(InputCarRace.moveCount).isGreaterThan(0);
    }

    @Test
    void 사용자이름_입력_예외(){
        사용자_이동_횟수_예외를_입력하라();

        assertSimpleTest(() ->
                assertThatThrownBy(() -> InputCarRace.inputMove(사용자_이동_횟수))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
}
