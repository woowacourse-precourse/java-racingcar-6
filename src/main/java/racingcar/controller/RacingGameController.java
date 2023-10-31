package racingcar.controller;

import racingcar.application.racing.dto.RacingDto;
import racingcar.util.RacingUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class RacingGameController {

    RacingUtils racingUtils = new RacingUtils();

    private String inputCarListMsg = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private String inputGameCntMsg = "시도할 회수는 몇회인가요?";
    private int checkLen = 5;
    private RacingDto racingDto;


    public void game() {
        ready();
        System.out.println();

        System.out.println("실행 결과");
        for(int i = 0; i < racingDto.getGameCnt(); i++) {
            start();
        }

        System.out.println();
        finish();
    }

    public void ready() {
        List<String> carList = getInputCarListAndCheckName();
        int gameCnt = getInputGameCntAndCheckGameCnt();
        racingDto = convertRacingDto(carList, gameCnt);
    }

    public void start() {
        Map<String, String> racingMap = racingDto.getCarMap();
        racingMap.keySet().forEach(car -> {
            boolean isForward = racingUtils.isRandomNumberOverFour();
            String forwardVal = racingMap.get(car);
            updateForwardCar(car, isForward, forwardVal);
            System.out.println(car.substring(0, car.length() - 1) + " : " + racingDto.getCarMap().get(car));
        });
        System.out.println();
    }

    public void finish() {
        List<String> winnerList = new ArrayList<>();
        int winnerLength = -1;
        Map<String, String> racingMap = racingDto.getCarMap();

        for (String car : racingMap.keySet()) {
            int nowLength = racingMap.get(car).length();
            if (nowLength > winnerLength) {
                winnerList = new ArrayList<>();
                winnerList.add(car.substring(0, car.length() - 1));
                winnerLength = nowLength;
            } else if (nowLength == winnerLength) {
                winnerList.add(car);
            }
        }
        System.out.println("최종 우승자 : " + winnerList.stream().collect(Collectors.joining(", ")));
    }

    public List<String> getInputCarListAndCheckName() {
        String cars = racingUtils.getInputAnswerAndShowMessage(inputCarListMsg);
        List<String> carList = racingUtils.splitStringToList(cars);
        boolean isOverLen = racingUtils.isCheckStringLength(carList, checkLen);
        if(isOverLen) {
            throw new IllegalArgumentException();
        }
        return carList;
    }

    public int getInputGameCntAndCheckGameCnt() {
        String gameCnt = racingUtils.getInputAnswerAndShowMessage(inputGameCntMsg);
        boolean isGameCountValid = racingUtils.isNumericOrNonNegative(gameCnt);
        if(isGameCountValid) {
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(gameCnt);
    }

    public RacingDto convertRacingDto(List<String> carList, int gameCnt) {
        RacingDto racingDto = new RacingDto();
        Map<String, String> carMap = new HashMap<>();
        AtomicInteger dupleIndex = new AtomicInteger(1);

        carList.forEach(car -> {
            carMap.put(car + dupleIndex.getAndIncrement(), "");
        });

        racingDto.setRacingCar(carMap);
        racingDto.setGameCnt(gameCnt);

        return racingDto;
    }

    public void updateForwardCar(String carName, boolean isForward, String forwardVal) {
        if(isForward) {
            forwardVal += "-";
            racingDto.getCarMap().put(carName, forwardVal);
        }
    }
}
