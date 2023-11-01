package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.StringTokenizer;

public class Application {
    static StringTokenizer st;
    static String name[];
    static String count[];
    static int n;
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        st = new StringTokenizer(Console.readLine(),",");
        name =new String[st.countTokens()];
        count=new String[st.countTokens()];

        for(int i=0;i<st.countTokens();i++){
            String str=st.nextToken();
            if(str.length()>4)
                throw new IllegalArgumentException();
            name[i]= str;
        }
        
        System.out.println("시도할 횟수는 몇회인가요?");
        n=Randoms.pickNumberInRange(0,9);
        System.out.println("실행 결과");

        for(int i=0;i<n;i++){

        }

    }
    public static void tryRace(){
        for(int i = 0; i< name.length; i++){
            for(int j=0;j<Randoms.pickNumberInRange(1,n);j++){
                count[i]+="-";
            }
        }
    }
}
