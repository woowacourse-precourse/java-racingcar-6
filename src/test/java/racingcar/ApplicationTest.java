package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayInputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 전진_정지() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
        );
    }

    @Test
    void 이름에_대한_예외_처리() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 전진_정지_예제_동일_조건() {
        List<String> exampleOutput = List.of(
                "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)",
                "시도할 회수는 몇회인가요?",
                "실행 결과",
                "pobi : -",
                "woni : ",
                "jun : -",
                "",
                "pobi : --",
                "woni : -",
                "jun : --",
                "",
                "pobi : ---",
                "woni : --",
                "jun : ---",
                "",
                "pobi : ----",
                "woni : ---",
                "jun : ----",
                "",
                "pobi : -----",
                "woni : ----",
                "jun : -----",
                "",
                "최종 우승자 : pobi, jun");

        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,jun", "5");
                    assertThat(output()).containsSubsequence(exampleOutput);
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD);
    }

    @Test
    void 이름에_대한_예외_처리_길이초과_시작() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException("javaji,pobi", "1"))
                .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 이름에_대한_예외_처리_길이초과_중간() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException("pobi,javaji,woni", "1"))
                .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 이름에_대한_예외_처리_길이초과_끝() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 이름에_대한_예외_처리_빈문자열() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException("", "1"))
                .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 이름에_대한_예외_처리_빈이름_시작() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException(",javaj", "1"))
                .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 이름에_대한_예외_처리_빈이름_중간() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException("javaj,,wonni", "1"))
                .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 이름에_대한_예외_처리_빈이름_끝() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException("javaj,", "1"))
                .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 이름에_대한_예외_처리_쉼표() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException(",", "1"))
                .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 이름에_대한_예외_처리_쉼표_연속() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException("pobi,,javaji", "1"))
                .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 실행_횟수에_대한_예외_처리_0() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException("pobi,woni,jun", "0"))
                .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 실행_횟수에_대한_예외_처리_음수() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException("pobi,woni,jun", "-1"))
                .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 실행_횟수에_대한_예외_처리_소수() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException("pobi,woni,jun", "1.1"))
                .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 실행_횟수에_대한_예외_처리_문자열() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException("pobi,woni,jun", "a"))
                .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 실행_횟수에_대한_예외_처리_빈문자열() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException("pobi,woni,jun", null))
                .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 실행_횟수에_대한_예외_처리_긴문자열() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException("pobi,woni,jun", "abcdefghijklmnopqrstuvwxyz"))
                .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 실행_횟수에_대한_예외_처리_Long_최대값_초과() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException("pobi,woni,jun", "9223372036854775808"))
                .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 실행_횟수에_대한_예외_처리_Long_최소값_미만() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException("pobi,woni,jun", "-9223372036854775809"))
                .isInstanceOf(IllegalArgumentException.class));
    }

    void testPrivateMethod(Class<?> testClass, String testMethodName, List<List<Object>> testCase) {
        for (List<Object> input : testCase) {
            // private method reflection 사용
            Object returnValue = new Object();
            try {
                // reflection
                Class<?> parameterClasses[] = Arrays.asList(testClass.getDeclaredMethods())
                        .stream()
                        .filter(x -> x.getName().equals(testMethodName))
                        .toList()
                        .get(0)
                        .getParameterTypes();
                Method testMethod = testClass.getDeclaredMethod(testMethodName, parameterClasses);
                testMethod.setAccessible(true);

                Object[] parameter = input.subList(0, input.size() - 1).toArray();// 메소드 입력값
                returnValue = testMethod.invoke(testClass, parameter);// 실행
            } catch (Exception e) { // 메소드명 오류시 예외처리
                assertThatExceptionOfType(IllegalArgumentException.class);
                continue;
            }
            Object expectResult = input.get(input.size() - 1);
            assertThat(returnValue).isEqualTo(expectResult);
        }
    }

    @Test
    void 기능목록_테스트_시작_문자열_출력() {
        Print.startString();
        assertThat(output()).isEqualTo("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    @Test
    void 기능목록_테스트_자동차_이름_입력() {
        List<String> testCase = Arrays.asList(
                "pobi,woni,jun,0,1,2,3,4,5,6,7,8,9",
                "pobi,0,1,2,3,4,5,6,7,9,woni,jun",
                "0,1,2,3,4,5,6,9,pobi,woni,jun");

        for (int i = 0; i < testCase.size(); i++) {
            final byte[] buf = String.join(System.lineSeparator(), testCase).getBytes();
            System.setIn(new ByteArrayInputStream(buf));
            assertThat(Input.inputCarName())
                    .containsAll(Arrays.asList("pobi", "woni", "jun", "0", "5", "9"));
            Console.close();
        }
    }

    @Test
    void 기능목록_테스트_입력_문자열_분할() {
        Class<?> testClass = Input.class;
        String testMethodName = "rawToList";
        List<List<Object>> testCase = Arrays.asList(
                Arrays.asList("a,bb,ccc", Arrays.asList("a", "bb", "ccc")),
                Arrays.asList("pobi", Arrays.asList("pobi")));
        testPrivateMethod(testClass, testMethodName, testCase);
    }

    @Test
    void 기능목록_테스트_자동차_이름_입력_오류_처리() {
        Class<?> testClass = Input.class;
        String testMethodName = "checkCarNameError";
        List<List<Object>> testCase = Arrays.asList(
                Arrays.asList(Arrays.asList("pobi", "woni", "jun"), null),
                Arrays.asList(Arrays.asList("1"), null),
                Arrays.asList(Arrays.asList("pobi", "woni", "123456"), new IllegalArgumentException()));
        testPrivateMethod(testClass, testMethodName, testCase);
    }

    @Test
    void 기능목록_테스트_빈_문자열_검사() {
        Class<?> testClass = Input.class;
        String testMethodName = "isBlank";
        List<List<Object>> testCase = Arrays.asList(
                Arrays.asList("pobi", false),
                Arrays.asList("", true));
        testPrivateMethod(testClass, testMethodName, testCase);
    }

    @Test
    void 기능목록_테스트_1_5자_검사() {
        Class<?> testClass = Input.class;
        String testMethodName = "isLengthOutOf1To";
        List<List<Object>> testCase = Arrays.asList(
                Arrays.asList("pobi", 5, false),
                Arrays.asList("", 5, true),
                Arrays.asList("123456", 5, true),
                Arrays.asList("1234", 3, true));
        testPrivateMethod(testClass, testMethodName, testCase);
    }

    @Test
    void 기능목록_테스트_자동차_이름_저장() {
        try {
            List<List<String>> testCase = Arrays.asList(
                    Arrays.asList("pobi", "pobi"),
                    Arrays.asList("woni", "woni"),
                    Arrays.asList("jun", "jun"));

            for (List<String> input : testCase) {
                Car car = new Car();
                car.setName(input.get(0));
                Field privateField = car.getClass().getDeclaredField("name");
                privateField.setAccessible(true);
                assertThat(privateField.get(car)).isEqualTo(input.get(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void 기능목록_테스트_시도_횟수_입력() {
        List<String> testCaseGood = Arrays.asList(
                "1",
                "1234567890",
                "9223372036854775807");

        List<String> testCaseException = Arrays.asList(
                "0",
                "-1",
                "-9223372036854775809",
                "9223372036854775808");
        List<String> testCase = new ArrayList<>();
        testCase.addAll(testCaseGood);
        testCase.addAll(testCaseException);

        for (int i = 0; i < testCaseGood.size(); i++) {
            final byte[] bufTestCase = testCaseGood.get(i).getBytes();
            System.out.println(testCaseGood.get(i));
            System.setIn(new ByteArrayInputStream(bufTestCase));
            String actual = Input.inputRepetitions().toString();
            assertThat(actual).isEqualTo(testCaseGood.get(i));
            Console.close();
        }

        for (int i = 0; i < testCaseException.size(); i++) {
            final byte[] bufTestCase = testCaseException.get(i).getBytes();
            System.out.println(testCaseException.get(i));
            System.setIn(new ByteArrayInputStream(bufTestCase));
            assertThrows(IllegalArgumentException.class, () -> {
                Input.inputRepetitions();
            });
            Console.close();
        }
    }

    @Test
    void 기능목록_테스트_시도_횟수_질문_문자열_출력() {
        Print.repetitionsString();
        assertThat(output()).isEqualTo("시도할 회수는 몇회인가요?");
    }

    @Test
    void 기능목록_테스트_시도_횟수_입력_오류_처리() {

        Class<?> testClass = Input.class;
        String testMethodName = "checkRepetitionsError";
        List<List<Object>> testCase = Arrays.asList(
                Arrays.asList("", new IllegalArgumentException()),
                Arrays.asList("0", new IllegalArgumentException()),
                Arrays.asList("-1", new IllegalArgumentException()),
                Arrays.asList("9223372036854775808", new IllegalArgumentException()));
        testPrivateMethod(testClass, testMethodName, testCase);
    }

    @Test
    void 기능목록_테스트_숫자_자연수() {
        Class<?> testClass = Input.class;
        String testMethodName = "isNotNaturalNumber";
        List<List<Object>> testCase = Arrays.asList(
                Arrays.asList("0", true),
                Arrays.asList("1", false),
                Arrays.asList("-1", true),
                Arrays.asList("2147483647", false));
        testPrivateMethod(testClass, testMethodName, testCase);
    }

    @Test
    void 기능목록_테스트_4이상_인지_검사() {

        Object testObject = new Car();
        String testMethodName = "runningDistance";
        List<List<Object>> testCase = Arrays.asList(
                Arrays.asList(MOVING_FORWARD, 1),
                Arrays.asList(STOP, 0));

        for (List<Object> input : testCase) {
            // private method reflection 사용
            try {
                // reflection
                Method testMethod = testObject.getClass().getDeclaredMethod(testMethodName);
                testMethod.setAccessible(true);
                assertRandomNumberInRangeTest(
                        () -> {
                            Object returnValue = testMethod.invoke(testObject);
                            assertThat(returnValue).isEqualTo(input.get(input.size() - 1));
                        },
                        (Integer) input.get(0));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    void 기능목록_테스트_값에_따라_자동차_전진_정지() {
        try {
            List<List<Object>> testCase = Arrays.asList(
                    Arrays.asList(MOVING_FORWARD, 1),
                    Arrays.asList(STOP, 0));

            for (List<Object> input : testCase) {
                Car car = new Car();
                assertRandomNumberInRangeTest(
                        () -> {
                            car.run();
                            Field privateField = car.getClass().getDeclaredField("position");
                            privateField.setAccessible(true);
                            assertThat(privateField.get(car)).isEqualTo(input.get(input.size() - 1));
                        },
                        (Integer) input.get(0));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void 기능목록_테스트_현재_상태_출력() {
        List<List<Object>> testCase = Arrays.asList(
                Arrays.asList(Arrays.asList("pobi", "woni", "jun"),
                        Arrays.asList(MOVING_FORWARD, STOP, MOVING_FORWARD),
                        String.join(System.lineSeparator(), "pobi : -", "woni : ", "jun : -")),
                Arrays.asList(Arrays.asList("pobi"),
                        Arrays.asList(MOVING_FORWARD, MOVING_FORWARD),
                        String.join(System.lineSeparator(), "pobi : --")),
                Arrays.asList(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "0"),
                        Arrays.asList(
                                MOVING_FORWARD, STOP, MOVING_FORWARD, STOP, MOVING_FORWARD,
                                STOP, MOVING_FORWARD, STOP, MOVING_FORWARD, STOP),
                        String.join(System.lineSeparator(),
                                "1 : -", "2 : ", "3 : -", "4 : ", "5 : -",
                                "6 : ", "7 : -", "8 : ", "9 : -", "0 : ")));

        for (List<Object> input : testCase) {
            Race race = new Race();
            List<String> names = ((List<?>) input.get(0)).stream()
                    .filter(x -> x instanceof String)
                    .map(Object::toString)
                    .toList();
            race.addCars(names);
            String expectString = ((String) input.get(input.size() - 1)).trim();
            List<Integer> inputRandom = ((List<?>) input.get(1)).stream().mapToInt(x -> (Integer) x).boxed().toList();
            Integer inputRandomFirst = inputRandom.get(0);
            Integer[] inputRandomElse = inputRandom.subList(1, inputRandom.size()).stream().toArray(Integer[]::new);

            init();
            assertRandomNumberInRangeTest(
                    () -> {
                        for (int i = 0; i < ((List<?>) input.get(1)).size()
                                / ((List<?>) input.get(0)).size(); i++) {
                            race.getCars().forEach(Car::run);
                        }
                        Print.raceSituation(race);
                        String result = output();
                        assertThat(result).isEqualTo(expectString);
                    },
                    inputRandomFirst, (Integer[]) inputRandomElse);
        }
    }

    @Test
    void 기능목록_테스트_우승자_목록을_형식에_맞춰_출력() {
        List<List<Object>> testCase = Arrays.asList(
                Arrays.asList("pobi", "woni", "jun"),
                Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "0"));

        for (List<Object> input : testCase) {
            init();
            Race race = new Race();
            List<String> names = input.stream().map(Object::toString).toList();
            race.addCars(names);

            assertSimpleTest(() -> {
                Print.winner(race.getCars());
                assertThat(output()).isEqualTo("최종 우승자 : " + String.join(", ", names));
            });
        }
    }

    @Test
    void 기능목록_테스트_우승자_계산() {
        List<List<Object>> testCase = Arrays.asList(
                Arrays.asList(Arrays.asList("pobi", "woni", "jun"),
                        Arrays.asList(MOVING_FORWARD, STOP, MOVING_FORWARD),
                        Arrays.asList("pobi", "jun")),
                Arrays.asList(Arrays.asList("pobi"),
                        Arrays.asList(MOVING_FORWARD, MOVING_FORWARD),
                        Arrays.asList("pobi")),
                Arrays.asList(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "0"),
                        Arrays.asList(
                                MOVING_FORWARD, STOP, MOVING_FORWARD, STOP, MOVING_FORWARD,
                                STOP, MOVING_FORWARD, STOP, MOVING_FORWARD, STOP),
                        Arrays.asList("1", "3", "5", "7", "9")));

        for (List<Object> input : testCase) {
            Race race = new Race();
            List<String> names = ((List<?>) input.get(0)).stream()
                    .filter(x -> x instanceof String)
                    .map(Object::toString)
                    .toList();
            race.addCars(names);
            List<String> expect = ((List<?>) input.get(input.size() - 1)).stream().map(Object::toString).toList();
            List<Integer> inputRandom = ((List<?>) input.get(1)).stream().mapToInt(x -> (Integer) x).boxed().toList();
            Integer inputRandomFirst = inputRandom.get(0);
            Integer[] inputRandomElse = inputRandom.subList(1, inputRandom.size()).stream().toArray(Integer[]::new);

            assertRandomNumberInRangeTest(
                    () -> {
                        for (int i = 0; i < ((List<?>) input.get(1)).size()
                                / ((List<?>) input.get(0)).size(); i++) {
                            race.getCars().forEach(Car::run);
                        }
                        List<String> result = race.getWinner().stream().map(Car::getName).toList();
                        assertThat(result).isEqualTo(expect);
                    },
                    inputRandomFirst, (Integer[]) inputRandomElse);
        }
    }
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
