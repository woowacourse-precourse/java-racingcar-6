package racingcar.control;

import racingcar.utill.Utill;
import racingcar.domain.RaceCar;
import racingcar.utill.ValidException;

import java.util.ArrayList;
import java.util.List;

// TODO: 10/27/23 레이싱 게임의 진행을 도와주는 게임진행 상항 클래스를 만든다.
public class GameProcess {
    private List<RaceCar> raceCarOfCurrentList;
    private String nameLineOfRaceCar;
    private List<String> nameSplitList;

    public GameProcess() {
        raceCarOfCurrentList = new ArrayList<>();
        nameLineOfRaceCar = "";
        nameSplitList = new ArrayList<>();
    }

    /**
     * 경주할 자동차 이름을 입력하는 메서드
     */
    public void inputNameOfRaceCar() {
        String inputStr = Utill.inputString();

        // 이름은 5자 이하 검사
        // 한글 포함 검사
        if (inputStr.length() > 0 && inputStr.length() <= 5 && ValidException.isValidIncludeKorean(inputStr)) {
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

    // TODO: 10/27/23 게임을 시도할 회수를 입력하는 메서드
    public void inputNumberGameAttempts() {
        // 게임을 시도할 회수를 입력하는 메서드
    }

    // TODO: 10/27/23 레이싱게임의 최종 승자를 알려준다.
    public List<RaceCar> knowFinalWinner() {
        // 레이싱게임의 최종 승자를 알려준다.
        return null;
    }
}
