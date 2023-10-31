package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

/**
 * 사용자의 입력하는 화면을 처리하는 View
 */
public class InputView {
    static String STRING_INPUT_CARNAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    static String STRING_INPUT_ATTEMPCOUNT = "시도할 회수는 몇회인가요?";

    /**
     * 경기를 진행할 자동차 이름들을 입력 ,를 기준으로 구분
     *
     * @return List<String> 입력한 이름들
     */
    public List<String> inputNames() {
        System.out.println(STRING_INPUT_CARNAMES);
        String input = Console.readLine();
        input = inputStringException(input);
        List<String> names = Arrays.asList(input.split("[,]"));
        inputNamesException(names);
        return names;
    }

    /**
     * 경기를 진행하는 회차를 입력
     *
     * @return int 입력한 회차수
     */
    public int inputAttempCount() {
        System.out.println(STRING_INPUT_ATTEMPCOUNT);
        int input = Integer.parseInt(Console.readLine());
        return input;
    }


    /**
     * 사용자가 입력한 이름들을 ","로 나눈뒤 5자이하인지 확인
     *
     * @param names 입력한 이름 배열
     */
    public void inputNamesException(List<String> names) {
        names.stream().forEach(name -> {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자리 이하만 가능합니다.");
            }
        });
    }

    /**
     * 사용자가 입력한 이름을 나누기전에 확인하는 메서드
     *
     * @param input 사용자가 입력했던 문자열
     * @return 만약 하나만 입력했다면 ,를 붙여서 반환, 그렇지 않다면 그냥 그대로 반환
     */
    public String inputStringException(String input) {
        if (input.isEmpty()) { //입력없이 엔터만 쳤을때
            throw new IllegalArgumentException("이름을 입력하세요");
        }
        if (!input.contains(",")) { //하나만 입력했을때
            return input + ",";
        }
        return input;
    }
}
