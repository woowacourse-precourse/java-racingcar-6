package racingcar;

import java.util.HashMap;
import camp.nextstep.edu.missionutils.Console;

public class SetRacing{
	protected HashMap<String,Integer> carName = new HashMap<>();
	protected String[] arr;
	protected int number;
	
	public String[] inputArr() {
		this.arr = Console.readLine().split(",");
		return arr;
	}
	
	public HashMap<String,Integer> carRegister() {
		for(int i=0;i<this.arr.length;i++) {
        	if(this.arr[i].length() > 5)
        		System.exit(0);
        	this.carName.put(this.arr[i], 0);
        }
		return this.carName;
	}
	
	public int tryNumber() {
		this.number = Integer.parseInt(Console.readLine());
		return this.number;
	}
	
}
