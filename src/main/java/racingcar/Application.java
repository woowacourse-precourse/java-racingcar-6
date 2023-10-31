package racingcar;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Vector;

import camp.nextstep.edu.missionutils.Console;

public class Application 
{
    public static void main(String[] args) 
    {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] name = readName();
        System.out.println("시도할 회수는 몇회인가요?");
        int tri = readTry();
        Vector<String> winner = runningRace(tri, name);
        printWinner(winner);
    }
    
    private static void printWinner(Vector<String> winner)
    {
    	for(int i = 0; i < winner.size(); i++)
    	{
    		System.out.print(winner.get(i));
    		if(i != winner.size()-1)
    		{
    			System.out.print(", ");
    		}
    	}
    }
    
	private static Vector<String> runningRace(int tri, String[] name)
    {
    	Vector<String> winner = new Vector<String>();
    	int[] value = new int[name.length];
    	for(int i = 0; i < tri; i++)
    	{
    		value = carsRun(name, value);
    		printState(name, value);
    	}
    	int maxNum = findMax(value);
    	for(int i = 0; i < name.length; i++)
    	{
    		if(maxNum == value[i])
    		{
    			winner.add(name[i]);
    		}
    	}
		return winner;
    }
    
    private static int findMax(int[] value)
    {
    	int maxNum = 0;
    	for(int i = 0; i < value.length; i++)
    	{
    		if(maxNum < value[i])
    		{
    			maxNum = value[i];
    		}
    	}
    	return maxNum;
    }
    
    private static void printState(String[] name, int[] value)
    {
    	for(int i = 0; i < name.length; i++)
    	{
    		System.out.print(name[i] + " : ");
    		printRunState(value[i]);
    		System.out.println();
    	}
    	System.out.println();
    }
    
    private static void printRunState(int value)
    {
    	for(int i = 0; i < value; i++)
    	{
    		System.out.print('-');
    	}
    }
    
    private static int[] carsRun(String[] name, int[] value)
    {
    	for(int i = 0; i <name.length; i++)
    	{
    		if(runCar())
    		{
    			value[i]++;
    		}
    	}
		return value;
    }
    
    private static Boolean runCar()
    {
    	if(Randoms.pickNumberInRange(0, 9) >= 4)
    	{
    		return true;
    	}
    	return false;
    }
    
    private static int readTry()
    {
    	String triS = Console.readLine();
    	int tri = Integer.parseInt(triS);
    	return tri;
    }
    
    private static String[] readName()
    {
    	String names = Console.readLine();
    	String[] name = names.split(",");
    	checkName(name);
    	return name;
    	
    }
    
    private static void checkName(String[] name)
    {
    	for(int i = 0; i < name.length; i++)
    	{
    		if(name[i].length() > 5)
    		{
    			throw new IllegalArgumentException();
    		}
    	}
    }
}
