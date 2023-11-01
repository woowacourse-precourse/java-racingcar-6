package racingcar;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;
import java.util.Map;
public class Application {
	public void check1(String except)
	{
		if(!except.contains(","))
		{
			throw new IllegalArgumentException("String에 ','가 포함되어야합니다.");
		}
	}
	public void check2(String except) {
	    try {
	        int number = Integer.parseInt(except); // 예외가 발생하지 않으면 문자열이 숫자로 변환 가능
	       
	    } catch (NumberFormatException e) {
	    	
	        System.out.println(except + "는 숫자가 아닙니다.");
	        return;
	    }
	}
	public static void manipulateDictionary(Map<String, String> dictionary,String[] names, int number)
	{
		for (int j = 0; j < number; j++) {
            int temp = Randoms.pickNumberInRange(0,9); // 0부터 9 사이의 랜덤 숫자를 얻음
            if (temp >= 4) {
                String temp1 = dictionary.get(names[j]);
                temp1 = temp1 + "-";
                dictionary.put(names[j], temp1);
            }
        }
	}
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    	Application except=new Application();
    	System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    	Map<String,String> dictionary=new HashMap<>();
    	String cars=Console.readLine();
    	try {
			except.check1(cars);
		} catch (IllegalArgumentException e) {
			System.out.println("error: "+e.getMessage());
			return;
			// TODO: handle exception
		}
    	String[] names=cars.split(",");
    	System.out.println("시도할 회수는 몇회인가요?");
    	String n=Console.readLine();
    	except.check2(n);
    	int number=names.length;
    	for(int i=0; i<number; i++)
    	{
    		dictionary.put(names[i],"");
    	}
    	int N=Integer.parseInt(n);
    	System.out.println("\n실행 결과");
    	for(int i=0; i<N; i++)
    	{
    		/*for(int j=0; j<number; j++)
    		{
    			int temp=Randoms.pickNumberInRange(0, 9);
    			if(temp>=4)
    			{
    				String temp1=dictionary.get(names[j]);
    				temp1=temp1+"-";
    				dictionary.put(names[j], temp1);
    				
    				
    				
    			}
    		}//score 넣기*/
    		manipulateDictionary(dictionary, names, number);
    		
    			
    			for(int j=0; j<number; j++)
    			{
    				System.out.println(names[j]+ " : "+dictionary.get(names[j]));
    			}
    			
    			System.out.println("\n");
    			
    		
    	
    	}
    	String result="최종 우승자 : ";
    	int max=0;
    	for(int i=0; i<number; i++)
    	{
    		if(dictionary.get(names[i]).length()>=max)
    		{
    			max=dictionary.get(names[i]).length();
    		}
    	}
    	int cnt=0;
    	for(int i=0; i<number; i++)
    	{
    		if(dictionary.get(names[i]).length()!=max)
    		{
    			continue;
    		}
    		if(cnt>=1)
			{
				result+=", "+names[i];
				cnt++;
			
			}
			else {
				result+=names[i];	
				cnt++;
			}
			
			
    	}
    	System.out.println(result);
    	
    	
    }
}
