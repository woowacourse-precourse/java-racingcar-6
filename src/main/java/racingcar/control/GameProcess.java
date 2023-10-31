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
    private List<RaceCar> raceCarOfWinnerList;
    private GameHost gameHost;
    private CreateRandomNum createRandomNum;

    public GameProcess() {
        raceCarList = new ArrayList<>();
        nameLineOfRaceCar = "";
        nameSplitList = new ArrayList<>();
        cntTryRace = 0;
        raceCarOfWinnerList = new ArrayList<>();
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

        makeNameOfCurrentCarListFromStringLine();

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

    /**
     * nameLineOfRaceCar을 배열로 split을 하여 nameSplitList을 만든다.
     */
    private void makeNameOfCurrentCarListFromStringLine() {
        String[] nameSplitArr = null;

        nameSplitArr = Utill.makeSplitArrFromString(nameLineOfRaceCar, ",");
        nameSplitList = Utill.makeListFromArr(nameSplitArr);
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
        String nameOfWinnerRaceCar = null;
        String[] raceCarOfWinnerArr = null;
        int sizeOfWinnerList = 0;

        // 레이싱게임의 최종 승자를 알려준다.
        raceCarOfWinnerList = gameHost.knowWinRaceCars(raceCarList);
        sizeOfWinnerList = raceCarOfWinnerList.size();

        if (Utill.valueGreaterThanEqualOne(sizeOfWinnerList)) {
            raceCarOfWinnerArr = makeNameArrFromWinnerCarList();
            nameOfWinnerRaceCar = getNameOfWinnerRaceCarFromArr(raceCarOfWinnerArr);
        }

        return nameOfWinnerRaceCar;
    }


    /**
     * 승자들만있는 배열들을 중간에 ", "을 넣어서 문자열을 만든다.
     *
     * @param raceCarOfWinnerArr
     * @return
     */
    private String getNameOfWinnerRaceCarFromArr(String[] raceCarOfWinnerArr) {
        return String.join(", ", raceCarOfWinnerArr);
    }

    /**
     * CarList에 있는 각각의 Car 이름을 Arr으로 만들어 반환한다.
     *
     * @return
     */
    private String[] makeNameArrFromWinnerCarList() {
        Integer sizeOfRaceCarList = raceCarOfWinnerList.size();
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
        return raceCarOfWinnerList.get(indexOfWinCarList);
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
