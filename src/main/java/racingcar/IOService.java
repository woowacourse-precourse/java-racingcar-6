package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class IOService {
    public List<String> scanCarNames(){
        String input = Console.readLine();
        List<String> carNames = Arrays.stream(input.split(",")).toList();

        validateCarNames(carNames);

        return carNames;
    }

    private void validateCarNames(List<String> carNames) {
        //공백을 입력한 경우
        if (carNames.size() == 1 && carNames.get(0).equals(""))
            throw new IllegalArgumentException("공백을 입력하였습니다.");

        //자동차 이름이 5글자를 초과한 경우
        for (String carName : carNames) {
            if (carName.length() > 5)
                throw new IllegalArgumentException(carName + "은 5글자를 초과하였습니다.");
        }
    }

    public void printCarState(Car car){
        StringBuilder stringBuilder = new StringBuilder(car.getName() + " : ");
        final String symbol = "-";
        stringBuilder.append(symbol.repeat(car.getPos()));

        System.out.println(stringBuilder.toString());
    }

    public void printWinners(List<String> winnerNames){
        StringBuilder stringBuilder = new StringBuilder("최종 우승자 : " + winnerNames.get(0));

        for(int i = 1; i < winnerNames.size(); ++i){
            stringBuilder.append(", " + winnerNames.get(i));
        }

        System.out.println(stringBuilder.toString());
    }

    public int scanCnt(){
        int cnt = 0;
        String input = Console.readLine();

        try{
            cnt = Integer.parseInt(input);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("숫자를 입력해야합니다.");
        }


        return cnt;
    }
}
