package racingcar.view;

import racingcar.constant.GameViewMessage;
import racingcar.validation.InputCountValidation;
import racingcar.validation.InputNamesValidation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class TerminalView implements View {

    /**
     * 이름 입력 메소드
     * @return 이름이 담긴 리스트 반환
     */
    @Override
    public List<String> inputNames() {
        System.out.println(GameViewMessage.MESSAGE_INPUT_NAME);
        String validatedNames = InputNamesValidation.inputNamesValidation(readLine());
        String[] names = validatedNames.split(",");
        return new ArrayList<>(Arrays.stream(names).toList());
    }

    /**
     * 회수 입력 메소드
     * @return 입력 값을 int 형변환 후 리턴
     */
    @Override
    public int inputCountNumber() {
        System.out.println(GameViewMessage.MESSAGE_INPUT_COUNT);
        return Integer.parseInt(InputCountValidation.inputCountValidation(readLine()));
    }

    @Override
    public void printResultStart() {
        System.out.println(GameViewMessage.MESSAGE_RESULT);
    }

    @Override
    public void printProgressResult(String result) {
        System.out.println(result);
    }

    @Override
    public void printChampions(String champions) {
        System.out.println(champions);
    }
}
