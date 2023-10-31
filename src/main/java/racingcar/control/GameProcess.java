package racingcar.control;

import racingcar.domain.CreateRandomNum;
import racingcar.domain.GameHost;
import racingcar.utill.Utill;
import racingcar.domain.RaceCar;
import racingcar.utill.ValidException;

import java.util.*;

public class GameProcess {
    Map<RaceCar, String> raceCarStringMap;
    private List<RaceCar> raceCarList;
    private String nameLineOfRaceCar;
    private List<String> nameSplitList;
    private Integer cntTryRace;
    private List<RaceCar> winnerList;
    private GameHost gameHost;
    private CreateRandomNum createRandomNum;

    public GameProcess() {
        raceCarList = new ArrayList<>();
        nameLineOfRaceCar = "";
        nameSplitList = new ArrayList<>();
        cntTryRace = 0;
        winnerList = new ArrayList<>();
        gameHost = new GameHost();
        createRandomNum = new CreateRandomNum();
        raceCarStringMap = new LinkedHashMap<>();
    }

    public void inputNameOfRaceCar() {
        String inputStr = Utill.inputString();

        ValidNameOfRaceCar(inputStr);

        nameLineOfRaceCar = inputStr;
    }

    private void ValidNameOfRaceCar(String inputStr) {
        ValidException.isValidCarEachNameFIveLessStringCheck(inputStr); // 각각 자동차의 이름은 5자 이하 검사
        ValidException.isValidIncludeKoreanCheck(inputStr); // 한글 포함 검사
        ValidException.isValidCommaNextBlankCheck(inputStr); // 문자열 이름 "woo," 이렇게 ,다음은 문자열이 꼭나와야된다.
        ValidException.isValidOneNameOfRaceCarCheck(inputStr); // 자동차 하나만 입력 금지.
    }

    public void createRaceCars() {
        RaceCar newRaceCar = null;

        makeCarNameListFromStrLine();

        for (String nameOfRaceCar : nameSplitList) {
            newRaceCar = generateRaceCar(nameOfRaceCar);
            addRaceCarList(newRaceCar);
        }
    }

    private RaceCar generateRaceCar(String name) {
        return new RaceCar(name);
    }

    private void addRaceCarList(RaceCar raceCar) {
        raceCarList.add(raceCar);
    }

    private void makeCarNameListFromStrLine() {
        String[] nameSplitArr = null;

        nameSplitArr = Utill.makeArrFromString(nameLineOfRaceCar, ",");
        nameSplitList = Utill.makeListFromArr(nameSplitArr);
    }

    public void inputNumOfGameAttempts() {
        cntTryRace = Utill.inputNum();
    }

    public String knowFinalWinner() {
        String nameOfWinner = "";
        String[] winnerArr = null;
        int sizeOfWinnerList = 0;

        winnerList = gameHost.giveWinnerRaceCarList(raceCarList);
        sizeOfWinnerList = winnerList.size();

        if (Utill.valueGreaterThanAndEqualOne(sizeOfWinnerList)) {
            winnerArr = makeNameArrFromWinnerList();
            nameOfWinner = getNameOfWinnerFromWinnerArr(winnerArr);
        }

        return nameOfWinner;
    }


    private String getNameOfWinnerFromWinnerArr(String[] raceCarOfWinnerArr) {
        return String.join(", ", raceCarOfWinnerArr);
    }

    private String[] makeNameArrFromWinnerList() {
        Integer sizeOfRaceCarList = winnerList.size();
        String[] nameOfWinnerArr = new String[sizeOfRaceCarList];
        RaceCar raceCarOfWinner = null;
        String nameOfWinnerCar = "";

        for (int indexOfWinCarList = 0; indexOfWinCarList < sizeOfRaceCarList; indexOfWinCarList++) {
            raceCarOfWinner = getRaceCarOfWinnerList(indexOfWinCarList);
            nameOfWinnerCar = raceCarOfWinner.toString();
            nameOfWinnerArr[indexOfWinCarList] = nameOfWinnerCar;
        }

        return nameOfWinnerArr;
    }

    /**
     * 승자 모임 리스트에서 해당하는 index의 값을 반환한다.
     *
     * @param indexOfWinCarList
     * @return
     */
    private RaceCar getRaceCarOfWinnerList(int indexOfWinCarList) {
        return winnerList.get(indexOfWinCarList);
    }

    /**
     * 현재 자동차들의 이동을 한다.
     */
    public void moveOfCurrentRaceCar() {
        for (RaceCar raceCar : raceCarList) {
            raceCar.movementControlCar(createRandomNum.createRanOneNum());
        }
    }

    /**
     * 현제 진행중인 자동차들의 진행상황을 MAP으로 만든다(순서O)
     * ( nameOfCar, "---" )
     *
     * @return
     */
    public Map<RaceCar, String> makeMapOfCurrentRace() {
        for (RaceCar raceCar : raceCarList) {
            raceCarStringMap.put(raceCar, raceCar.toStringMoveState());
        }

        return raceCarStringMap;
    }

    public Integer getCntTryRace() {
        return cntTryRace;
    }
}
