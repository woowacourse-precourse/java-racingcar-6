package util;

public class Validate {
	private static final int NAME_LIMIT = 5; //5자 제한
	
	//사용자 입력값 유효성 검사
	public static void inputPlayerDateValidate(String inputDate) {
		String[] inputDate_arr = inputDate.split(",");
		
		//쉼표(,)가 없을경우
		if(!inputDate.contains(",")) throw new IllegalArgumentException("게임을 위해 쉼표를 넣어주세요!");
		//이름 5자이하로 제한.
		for(String s : inputDate_arr) if(s.length()>NAME_LIMIT) throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다!");
		//숫자 포함하면 안됨.
		for(String s : inputDate_arr) {
			char[] word = s.toCharArray();
			for(char c : word) if(Character.isDigit(c)) throw new IllegalArgumentException("이름에 숫자를 넣으면 안됩니다!");
		}
	}
	//입력값이 숫자가 맞는지 검사
	public static void inputPlayerDateIsNumValidate(String inputDate) {
		char[] word = inputDate.toCharArray();
		for(char c : word) if(!Character.isDigit(c)) throw new IllegalArgumentException("숫자만 입력해주세요!");
	}
	
}
