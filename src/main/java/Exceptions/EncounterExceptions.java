package Exceptions;

public class EncounterExceptions {
	
	private final int longest_name=5;

	public String [] nameInspection(String names) {
		
		if(ifSplitProblem(names))
			throw new IllegalArgumentException("입력 정보를 확인해주세요");
		//else if(names.length()>5)
		//	throw new IllegalArgumentException("이름은 5자 이하만 가능합니다");
		
		String [] eachName=names.split(",");
		
		return eachName;
	}
	
	public boolean ifSplitProblem(String names) {
		
		if(names==null)
			return true;
		else if(nameIsProblem(names))
			return true;
		else if(upexpectedExceptions(names))
			return true;
			
		return false;
	}
	
	public boolean nameIsProblem(String names) {
		
		String [] eachName=names.split(",");
		
		for(String name:eachName) {
			if(name.equals(""))
				return true;
			else if(name.length()>longest_name)
				return true;
		}
		return false;
	}
	
	public boolean upexpectedExceptions(String names) {
		
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
	
	public boolean naN(String inputCount) {
		
		try {
			Integer.parseInt(inputCount);
		} catch(Exception e) {
			return true;
		}
		return false;
	}
}
