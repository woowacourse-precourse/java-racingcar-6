package racingcar.control;

import racingcar.utill.Utill;
import racingcar.domain.RaceCar;
import racingcar.utill.ValidException;

import java.util.ArrayList;
import java.util.List;

// TODO: 10/27/23 레이싱 게임의 진행을 도와주는 게임진행 상항 클래스를 만든다.
public class GameProcess {
    List<RaceCar> raceCarOfCurrentList;
    String nameLineOfRaceCar;

    public GameProcess() {
        raceCarOfCurrentList = new ArrayList<>();
        nameLineOfRaceCar = "";
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

    // TODO: 10/27/23 입력받은 이름 문자열로 자동차를 만들어준다.
    public void createRaceCars() {
        // 입력받은 이름 문자열로 자동차를 만든다.
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
