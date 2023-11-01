package data;

import controller.InputValues;
import controller.RoundDriver;
import controller.Winners;
import exceptions.EncounterExceptions;

public class Constants {
	
	private Constants() {}

	public static final exceptions.EncounterExceptions VERIFICATION=new EncounterExceptions();
	public static final controller.InputValues INPUT=new InputValues();
	//public static final controller.RoundDriver ROUNDING=new RoundDriver();
	//public static final controller.Winners WINNERS=new Winners();
	
	public static final int SMALLEST_RANGE=0;
	public static final int GREATEST_RANGE=9;
	
	public static final String HYPHEN_NOTHING_YET="";
	
	public static final int ADVANCE=1;
	public static final int STOP=0;
	
	public static final int SMALLINT=Integer.MIN_VALUE;
	public static final int STUB=2;
	
	public static final int INIT_SCORE=0;
	
	public static final int longest_name_length=5;
}
