package model;

import constants.GameConstant;
import constants.MessageType;
import java.util.Arrays;
import java.util.List;

public class Game {
    public static int tryCount;

    /**
     * 가장 많이 움직인 전진 수
     *
     * @param carList 경주한 자동차들의 결과를 담은 List
     * @return 경주한 자동차 중 가장 많이 움직인 전진 수 리턴
     */
    public int getMaxStepCount(List<Car> carList){
        int[] stepCountArray = carList.stream()
                .mapToInt(Car::getStepCount)
                .toArray();

        int maxStepCount = Arrays.stream(stepCountArray)
                .max()
                .orElse(0);
        return maxStepCount;
    }

    /**
     * 우승자 결과 데이터 가공하기
     *
     * @param carList 경주한 자동차들의 결과를 담은 List
     * @param maxStepCount 경주한 자동차 중 가장 많이 움직인 전진 수
     * @return 우승자를 선발하여 데이터를 가공한 후 리턴
     */
    public String getWinnerList(List<Car> carList, int maxStepCount){
        String winnerList = getCommaResult(carList, maxStepCount);

        winnerList = removeCommaResult(winnerList);

        winnerList = MessageType.GAME_RESULT.getMessage()
                .replace(GameConstant.WINNER_TEXT,winnerList);

        return winnerList;
    }

    private String getCommaResult(List<Car> carList, int maxStepCount){
        String winnerList = "";
        for(Car car : carList){
            if(car.getStepCount() == maxStepCount){
                winnerList += new StringBuilder(car.getName())
                        .append(", ");
            }
        }

        return winnerList;
    }

    private String removeCommaResult(String winnerList){
        if(winnerList.endsWith(", ")){
            winnerList = winnerList.substring(0, winnerList.length() - 2);
        }
        return winnerList;
    }

}

