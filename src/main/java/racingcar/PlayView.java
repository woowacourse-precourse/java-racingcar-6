package racingcar;

import java.util.List;

public class PlayView {
    public PlayView() {
    }
    public void PlayResultView(List<Integer> UserRace, List <String> inputDataList, int NumberOfTime, int now) {
        if(now == 0)
            System.out.println("실행 결과");
        for(int i = 0; i < inputDataList.size(); i++) {
            System.out.print(inputDataList.get(i) + " : ");
            for(int j = 0; j < UserRace.get(i); j++){
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
        if(NumberOfTime - 1 == now){
            System.out.print("최종 우승자 : ");
            int max = 0;
            for(int i = 0; i < inputDataList.size(); i++) {
                if(max < UserRace.get(i)){
                    max = UserRace.get(i);
                }
            }
            StringBuilder winners = new StringBuilder();
            for(int i = 0; i < inputDataList.size(); i++) {
                if(max == UserRace.get(i)){
                    if (!winners.isEmpty()) {
                        winners.append(", "); // 여러 우승자를 ,로 구분
                    }
                    winners.append(inputDataList.get(i));
                }
            }
            System.out.println(winners);
        }
    }
}
