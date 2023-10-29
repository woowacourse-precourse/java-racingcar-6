package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ApplicationTest_function_list extends NsTest {

    @Test
    void 기능목록_테스트_시작_문자열_출력() {
        Print.startString();
        assertThat(output()).isEqualTo("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    @Test
    void 기능목록_테스트_자동차_이름_입력() {
        List<String> testInputs = List.of(
                "pobi,woni,jun,0,1,2,3,4,5,6,7,8,9",
                "pobi,0,1,2,3,4,5,6,7,8,9,woni,jun",
                "0,1,2,3,4,5,6,7,8,9,pobi,woni,jun");

        for (int i = 0; i < testInputs.size(); i++) {
            final byte[] buf = String.join("\n", testInputs).getBytes();
            System.setIn(new ByteArrayInputStream(buf));
            assertThat(Input.inputCarName())
                    .containsAll(List.of("pobi", "woni", "jun", "0", "5", "9"));
        }
    }

    @Test
    void 기능목록_테스트_입력_문자열_분할() {
        // private method reflection 사용
        List<Object> returnValue = new ArrayList<>();
        try {
            // reflection
            Method rawToListMethod = Input.class.getDeclaredMethod("rawToList", String.class);
            rawToListMethod.setAccessible(true);

            String parameterString = "a,bb,ccc";// 메소드 입력값
            Object tmp = rawToListMethod.invoke(Input.class, parameterString);// 실행
            if (tmp instanceof ArrayList) {
                returnValue =  Arrays.asList(tmp);
            }

        } catch (Exception e) { // 메소드명 오류시 예외처리
            e.printStackTrace();
        }
        assertThat(returnValue).containsExactly(Arrays.asList("a", "bb", "ccc"));

    }

    @Test
    void 기능목록_테스트_자동차_이름_입력_오류_처리() {

    }

    @Test
    void 기능목록_테스트_null_검사() {

    }

    @Test
    void 기능목록_테스트_빈_문자열_검사() {

    }

    @Test
    void 기능목록_테스트_1_5자_검사() {

    }

    @Test
    void 기능목록_테스트_자동차_이름_저장() {

    }

    @Test
    void 기능목록_테스트_경주() {

    }

    @Test
    void 기능목록_테스트_시도_횟수_입력() {

    }

    @Test
    void 기능목록_테스트_시도_횟수_질문_문자열_출력() {

    }

    @Test
    void 기능목록_테스트_시도_횟수_입력_오류_처리() {

    }

    @Test
    void 기능목록_테스트_숫자_자연수() {

    }

    @Test
    void 기능목록_테스트_시도_횟수만큼_전체_순환() {

    }

    @Test
    void 기능목록_테스트_전체_자동차_순환() {

    }

    @Test
    void 기능목록_테스트_한_자동차_진행() {

    }

    @Test
    void 기능목록_테스트_0_9_무작위_값_생성() {

    }

    @Test
    void 기능목록_테스트_4이상_인지_검사() {

    }

    @Test
    void 기능목록_테스트_값에_따라_자동차_전진_정지() {

    }

    @Test
    void 기능목록_테스트_현재_상태_출력() {

    }

    @Test
    void 기능목록_테스트_경기_상황_출력() {

    }

    @Test
    void 기능목록_테스트_우승자_목록을_형식에_맞춰_출력() {

    }

    @Test
    void 기능목록_테스트_우승자_계산() {

    }

    @Override
    public void runMain() {
        Application.main(new String[] {});
    }
}
