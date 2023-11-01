package exceptions;

import static data.Constants.longest_name_length;

public class EncounterExceptions {
	
	//private static final int longest_name_length=5;private static final int longest_name_length=5;

	public String [] nameInspection(String names) {
		
		if(ifSplitProblem(names))
			throw new IllegalArgumentException("입력 정보를 확인해주세요");
		//else if(names.length()>5)
		//	throw new IllegalArgumentException("이름은 5자 이하만 가능합니다");
		
		String [] eachName=names.split(",");
		
		return eachName;
	}
	
	private boolean ifSplitProblem(String names) {
		
		if(names==null)
			return true;
		else if(nameIsProblem(names))
			return true;
		else if(upexpectedExceptions(names))
			return true;
			
		return false;
	}
	
	private boolean nameIsProblem(String names) {
		
		String [] eachName=names.split(",");
		
		if(commaOnly(eachName))
			return true;
		
		for(String name:eachName) {
			if(name.equals(""))
				return true;
			else if(name.length()>longest_name_length)
				return true;
		}
		return false;
	}
	
	private boolean commaOnly(String [] eachName) {
		
		if(eachName.length==0)
			return true;
		return false;
	}
	
	private boolean upexpectedExceptions(String names) {
		
		try {
			names.split(",");
		} catch(Exception e) {
			return true;
		}
		return false;
	}
	
	public int countInspection(String inputCount) {
		
		if(naN(inputCount))
			throw new IllegalArgumentException("공백 혹은 숫자가 아닌 값은 입력할 수 없습니다");
		
		return Integer.parseInt(inputCount);
	}
	
	private boolean naN(String inputCount) {
		
		try {
			Integer.parseInt(inputCount);
		} catch(Exception e) {
			return true;
		}
		return false;
	}
}
