package racingcar.control;

import racingcar.utill.Utill;
import racingcar.domain.RaceCar;
import racingcar.utill.ValidException;

import java.util.ArrayList;
import java.util.List;

public class GameProcess {
    private List<RaceCar> raceCarOfCurrentList;
    private String nameLineOfRaceCar;
    private List<String> nameSplitList;
    private Integer cntTryRace;

    public GameProcess() {
        raceCarOfCurrentList = new ArrayList<>();
        nameLineOfRaceCar = "";
        nameSplitList = new ArrayList<>();
        cntTryRace = 0;
    }

    /**
     * 경주할 자동차 이름을 입력하는 메서드
     */
    public void inputNameOfRaceCar() {
        String inputStr = Utill.inputString();

        // 이름은 5자 이하 검사
        // 한글 포함 검사
        // 문자열 이름 "woo," 이렇게 ,다음은 문자열이 꼭나와야된다.
        if (ValidException.isValidFIveLessString(inputStr)
                && ValidException.isValidIncludeKorean(inputStr)
                && ValidException.isValidCommaNextBlankCheck(inputStr)) {
            nameLineOfRaceCar = inputStr;
        }
    }

    /**
     * 입력받은 이름 문자열리스트로 자동차를 만들어준다.
     */
    public void createRaceCars() {
        makeNameOfCarListFromStringLine();
        // 입력받은 이름 문자열로 자동차를 만든다.
        // 문자열 공백 검사.
        for (String nameOfRaceCar : nameSplitList) {
            raceCarOfCurrentList.add(new RaceCar(nameOfRaceCar));
        }
    }

    /**
     * nameLineOfRaceCar을 배열로 split을 하여 nameSplitList을 만든다.
     */
    private void makeNameOfCarListFromStringLine() {
        String[] nameSplitArr = null;

        // 입력받은 이름 문자열로 자동차를 만든다.
        // 문자열 공백 검사.
        if (ValidException.isValidBlankCheck(nameLineOfRaceCar)) {
            // TODO: 10/28/23 Utill 클래스로 배열을 리스트로 변환
            nameSplitArr = nameLineOfRaceCar.split(",");
            nameSplitList = List.of(nameSplitArr);
        }
    }

    /**
     * 게임을 시도할 회수를 입력하는 메서드
     */
    public void inputNumberGameAttempts() {
        // 게임을 시도할 회수를 입력하는 메서드
        cntTryRace = Utill.inputNum();
    }

    // TODO: 10/27/23 레이싱게임의 최종 승자를 알려준다.
    public List<RaceCar> knowFinalWinner() {
        // 레이싱게임의 최종 승자를 알려준다.
        return null;
    }
}
