package racingcar.control;

import racingcar.domain.CreateRandomNum;
import racingcar.domain.GameHost;
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
    private List<RaceCar> raceCarOfWinnerList;
    private GameHost gameHost;
    private CreateRandomNum createRandomNum;

    public GameProcess() {
        raceCarOfCurrentList = new ArrayList<>();
        nameLineOfRaceCar = "";
        nameSplitList = new ArrayList<>();
        cntTryRace = 0;
        raceCarOfWinnerList = new ArrayList<>();
        gameHost = new GameHost();
        createRandomNum = new CreateRandomNum();
    }

    /**
     * 경주할 자동차 이름을 입력하는 메서드
     */
    public void inputNameOfRaceCar() {
        String inputStr = Utill.inputString();

        // 각각 자동차의 이름은 5자 이하 검사
        // 한글 포함 검사
        // 문자열 이름 "woo," 이렇게 ,다음은 문자열이 꼭나와야된다.
        // 자동차 하나만 입력 금지.
        ValidException.isValidCarEachNameFIveLessString(inputStr);
        ValidException.isValidIncludeKorean(inputStr);
        ValidException.isValidCommaNextBlankCheck(inputStr);
        ValidException.isValidOneNameOfRaceCarCheck(inputStr);
        nameLineOfRaceCar = inputStr;
        createRaceCars();
    }

    /**
     * 입력받은 이름 문자열리스트로 자동차를 만들어준다.
     */
    private void createRaceCars() {
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

    /**
     * 레이싱게임의 최종 승자를 알려준다.
     *
     * @return
     */
    public String knowFinalWinner() {
        RaceCar raceCar = null;
        String nameOfRaceCar = null;
        String[] raceCarOfWinnerArr = null;

        // 레이싱게임의 최종 승자를 알려준다.
        raceCarOfWinnerList = gameHost.winRaceCar(raceCarOfCurrentList, cntTryRace);
        int sizeOfWinnerList = raceCarOfWinnerList.size();

        if (sizeOfWinnerList == 1) {
            raceCar = raceCarOfWinnerList.get(0);
            nameOfRaceCar = raceCar.toString();
        }
        if (sizeOfWinnerList >= 1) {
            raceCarOfWinnerArr = makeNameArrFromCarList(raceCarOfCurrentList);
            nameOfRaceCar = String.join(" ,", raceCarOfWinnerArr);
        }
        return nameOfRaceCar;
    }

    /**
     * CarList에 있는 각각의 Car 이름을 Arr으로 만들어 반환한다.
     *
     * @param raceCarList
     * @return
     */
    private String[] makeNameArrFromCarList(List<RaceCar> raceCarList) {
        Integer sizeOfRaceCarList = raceCarList.size();
        String[] arrOfStr = new String[sizeOfRaceCarList];
        RaceCar raceCar = null;
        String name = "";

        for (int index = 0; index < sizeOfRaceCarList; index++) {
            raceCar = raceCarList.get(index);
            name = raceCar.toString();
            arrOfStr[index] = name;
        }

        return arrOfStr;
    }

    public void moveOfRaceCar() {
        for (RaceCar raceCar : raceCarOfCurrentList) {
            raceCar.movementControlCar(createRandomNum.createRanOneNum());
        }
    }

    public Integer sizeCurrentRaceCarList() {
        return raceCarOfCurrentList.size();
    }

    public String makeMsgOfCurrentRace() {
        String result = "";

        for (RaceCar raceCar : raceCarOfCurrentList) {
            result.concat(raceCar + " : " + raceCar.toStringMoveState() + "\0");
        }

        return result;
    }
}
