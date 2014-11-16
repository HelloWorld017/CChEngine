package org.He.W.CChEngine.Event;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

import com.He.W.onebone.Circuit.Cu.exception.ParseException;
import com.He.W.onebone.Circuit.Cu.parser.CCSParser;

public class CheckHelper {
	public File listFile = new File("List.ccs");
	public File enumFile = new File("Enum.ccs");
	public File tagFile = new File("Tag.ccs");
	
	public ArrayList<String> user = new ArrayList<String>();
	public ArrayList<String> event = new ArrayList<String>();
	public ArrayList<String> tag = new ArrayList<String>();
	
	public HashMap<Integer, String[]> eventList = new HashMap<Integer, String[]>();
	
	public CheckHelper() throws ParseException{
			/*Index of items
				 * 0 = id
				 * 1 = user identification
				 * 2 = event enum
				 * 3 = date
				 * 4 = isFinished
				 * 5 = Assigned tag
				 * 6 = Assigned event
				 * 7 = specific event
				 */
				/* : List.ccs
				 *CChEngine CCS File v3
				 *[0]
				 *date=2014-10-26
				 *user=identifier
				 *name= event name
				 *finished=true
				 *tag=Assigned tag
				 *event=Assigned event
				 *spec=Description
				 */
	}
	
	public void getSelectedDate(LocalDate date){
		
	}
	
	public static Event findItem(int id) throws NoEventFoundException{
		return null;
		
	}
	
	public void addEvent(){
		
	}
	
	public void deleteEvent(){
		
	}
	
	public void editEvent(int eventId, LocalDate date, String eventEnum, String eventSpec, String eventUser){
		
	}
	
	public void assignEvent(){
		
	}
	
	public void loadEvents() throws ParseException{
		try{
			
			TreeMap<String, TreeMap<String, String>> tempContent = new TreeMap<String, TreeMap<String, String>>();
			BufferedReader br = new BufferedReader(new FileReader(listFile));
			tempContent = CCSParser.parseCCS(br);
			tempContent.forEach((k, v) -> {
				Event e = new Event();
				e.setId(Integer.parseInt(k));
				e.setUserIdentification(v.get("user"));
			});
		
		}catch(FileNotFoundException e){
			throw new ParseException(ParseException.NO_FILE);
		}
	}
	
	public void loadEnums() throws ParseException{
		try{
			TreeMap<String, TreeMap<String, String>> tempContent = new TreeMap<String, TreeMap<String, String>>();
			tempContent.get("Event").forEach((k,v) -> {
			event.add(v);
			});
			
			tempContent.get("User").forEach((k, v) -> {
				user.add(v);
			});
			BufferedReader br = new BufferedReader(new FileReader(enumFile));
			
			
			tempContent = null;
			System.gc();
			
		}catch(FileNotFoundException e){
			throw new ParseException(ParseException.NO_FILE);
		}
	}
	
}
