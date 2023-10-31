package racingcar.control;

import racingcar.domain.CreateRandomNum;
import racingcar.domain.GameHost;
import racingcar.utill.Utill;
import racingcar.domain.RaceCar;
import racingcar.utill.ValidException;

import java.util.*;

public class GameProcess {
    Map<RaceCar, String> raceCarMap;
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
        raceCarMap = new LinkedHashMap<>();
    }

    public void inputNameOfRaceCar() {
        String inputStr = Utill.inputString();

        ValidNameOfRaceCar(inputStr);

        nameLineOfRaceCar = inputStr;
    }

    private void ValidNameOfRaceCar(String inputStr) {
        ValidException.NameOfEachFIveLessString(inputStr);
        ValidException.includeKorean(inputStr);
        ValidException.commaNextBlank(inputStr);
        ValidException.onlyOneNameOfRaceCar(inputStr);
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

        winnerList = gameHost.giveWinnerList(raceCarList);
        sizeOfWinnerList = winnerList.size();

        if (Utill.isGreaterThanAndEqualOne(sizeOfWinnerList)) {
            winnerArr = makeNameArrFromWinnerList();
            nameOfWinner = getNameOfWinnerFromWinnerArr(winnerArr);
        }

        return nameOfWinner;
    }


    private String getNameOfWinnerFromWinnerArr(String[] raceCarOfWinnerArr) {
        return String.join(", ", raceCarOfWinnerArr);
    }

    private String[] makeNameArrFromWinnerList() {
        Integer sizeOfWinnerList = winnerList.size();
        String[] nameOfWinnerArr = new String[sizeOfWinnerList];
        RaceCar raceCarOfWinner = null;
        String nameOfWinnerCar = "";

        for (int indexOfWinCarList = 0; indexOfWinCarList < sizeOfWinnerList; indexOfWinCarList++) {
            raceCarOfWinner = getRaceCarFromWinnerList(indexOfWinCarList);
            nameOfWinnerCar = raceCarOfWinner.toString();
            nameOfWinnerArr[indexOfWinCarList] = nameOfWinnerCar;
        }

        return nameOfWinnerArr;
    }

    private RaceCar getRaceCarFromWinnerList(int index) {
        return winnerList.get(index);
    }

    public void moveAllRaceCar() {
        for (RaceCar raceCar : raceCarList) {
            raceCar.movementControl(createRandomNum.createRanOneNum());
        }
    }

    /**
     * 자동차들의 진행상황에 대한 MAP을 만든다(순서O)( name, "---" )
     *
     * @return
     */
    public Map<RaceCar, String> makeMapOfCurrentRace() {
        for (RaceCar raceCar : raceCarList) {
            raceCarMap.put(raceCar, raceCar.toStringMoveState());
        }

        return raceCarMap;
    }

    public Integer getCntTryRace() {
        return cntTryRace;
    }
}
