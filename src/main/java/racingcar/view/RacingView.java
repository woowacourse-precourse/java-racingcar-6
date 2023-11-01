package racingcar.view;

import racingcar.view.errorHandler.ErrorHandler;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class RacingView {
    public final ErrorHandler errorHandler = new ErrorHandler();

    public List<String> gameStart() {
        List<String> resultList = new ArrayList<>();
        String nameLine = readLine();
        String[] userCar = nameLine.split(",");
        String tryNumber = readLine();

//            Error Handler
        errorHandler.initialHandler(userCar, tryNumber);

//            controller에 넘길 반환값 설정하기
        resultList.add(tryNumber);
        for (String carName : userCar) {
            resultList.add(carName);
        }

//            index-0: 플레이 횟수, index-1,2,...:자동차 이름
        return resultList;
    }

    public void showLoad(List<String> name, List<String> location) {
//        자동차 별 진척 상황 시각화
        int theNumOf = name.size();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < theNumOf; i++) {
            stringBuilder.setLength(0);
            stringBuilder.append(name.get(i)).append(" : ").append(location.get(i));
            System.out.println(stringBuilder);
        }
    }

    public void showResult(String winner) {
        if(!winner.equals("")){
            System.out.println("최종 우승자 : " + winner);
        }
        if(winner.equals("")){
            System.out.println("아무도 전진하지 않았습니다. 우승자는 없습니다.");
        }
    }
}
