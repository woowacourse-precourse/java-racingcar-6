package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        int score[];

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");

        Scanner scanner = new Scanner(System.in);
        String inputValue = scanner.nextLine();

        String[] splitedValue = inputValue.split(",");  //자동차 이름 쉼표 기준으로 나누기

        int len = splitedValue.length;

        int n = scanner.nextInt();  //시행할 횟수

        int[] forward;
        forward = new int[100];
        int[] winner;
        winner = new int[100];

        for(int i=0;i<n;i++){
            for(int j=0;j<len;j++){
                int r = Randoms.pickNumberInRange(1, 9);
                forward[j]=0;
                if(r>=4){
                    ++forward[j];
                }
            }
        }

        int max=forward[0];
        winner[0] = 0;
        int winner_index=0;

        for(int j=1;j<len;j++){
            if(forward[j]>max){
                winner[winner_index]=j;
            }
            else if(forward[j]==max){
                winner_index+=1;
                max = forward[j];
                winner[winner_index]=j;
            }
        }
        for(int i=0;i<=winner_index;i++){
            if(i!=0){
                System.out.print(", ");
            }
            System.out.print(splitedValue[winner[i]]);
        }
    }
}
