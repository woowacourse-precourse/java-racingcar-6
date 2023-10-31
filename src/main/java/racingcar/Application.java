package racingcar;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
	public static String[] get_user() { // 사용자 이름 입력받기
		String input = Console.readLine();
		System.out.println(input);
		String[] user = input.split(",");
		for(int i=0; i<user.length;i++) {
			if(user[i].length()>5) {
				 throw new IllegalArgumentException();
			}
		}
		return user;
	}
	
    public static void main(String[] args) {
    	System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

		// 사용자 이름 입력받기
		String[] user = get_user();
		int usernum = user.length; // 사용자 인원
    }
}
