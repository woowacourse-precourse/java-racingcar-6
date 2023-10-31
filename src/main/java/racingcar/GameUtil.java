package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameUtil {

    public String getCarName(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        return Console.readLine();
    }

    public int getMoveCount(){
        System.out.println("시도할 회수는 몇회인가요?");
        int res;
        try{
            String input = Console.readLine();
            res = Integer.parseInt(input);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
        return res;
    }

    public void printWinner(List<Racer> winners) {
        System.out.print("최종 우승자 : ");
        List<String> winnerNames = winners.stream()
                .map(Racer::getName)
                .toList();
        System.out.println(String.join(", ", winnerNames));
    }

    public void printEachResult(List<Racer> racerList) {
        StringBuilder result = new StringBuilder();
        for (Racer racer : racerList) {
            result.append(racer.getName())
                    .append(" : ")
                    .append(racer.getScore())
                    .append("\n");
        }
        System.out.println(result.toString());
    }

    public List<String> inputToNameList(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .peek(name -> {
                    if (!isNameOK(name)) {
                        throw new IllegalArgumentException("이름은 한 글자 이상 다섯 글자 이하여야 합니다.");
                    }
                })
                .collect(Collectors.toList());
    }

    /**
     * 이름이 1자리 이상 5자리 이하인지 확인하는 함수
     *
     * @param nameCandidate 전달받은 이름
     * @return boolean true or false
     */
    private boolean isNameOK(String nameCandidate) {
        return !nameCandidate.isEmpty() && nameCandidate.length() <= 5;
    }


}
