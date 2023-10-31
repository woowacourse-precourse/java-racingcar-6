package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;


public class RacingGame {

    private List<String> resultList = new ArrayList<>();
    private List<String> winner = new ArrayList<>();
    private InputDesk inputDesk = new InputDesk();
    private Announcer outputs = new Announcer();

    public RacingGame() {

    }

    public void initResultList(List resultList) {
        List<String> cars = inputDesk.getCars();
        for (int i = 0 ; i < cars.size() ; i++) {
            resultList.add("");
        }
    }

    public void move(List cars) {
        int randNum;
        for (int i=0; i<cars.size(); i++) {
            randNum = Randoms.pickNumberInRange(0,9);
            if(randNum >= 4) {
                resultList.set(i, resultList.get(i)+"-");
            }
        }

    }

    public void chooseWinners(List<String> resultList) {

        List<String> cars = inputDesk.getCars();
        int maxLen = 0;
        for (int i=0; i<resultList.size(); i++) {
            if( resultList.get(i).length() > maxLen) {
                maxLen = resultList.get(i).length();
                winner.clear();
                winner.add(cars.get(i));
                continue;
            }
            if(resultList.get(i).length() == maxLen) {
                winner.add(cars.get(i));
                continue;
            }
        }

    }

    public void start() {

        try {
            inputDesk.inputCars();
            inputDesk.inputCounts();
            initResultList(resultList);
            for (int i = 0; i< inputDesk.getCount(); i++) {
                move(inputDesk.getCars());
                outputs.resultMessage();
                outputs.result(resultList,inputDesk.getCars());
            }
            chooseWinners(resultList);
            outputs.winner(winner);
        } catch (IllegalArgumentException e) {
            throw e;
        }

    }

}
