package org.He.W.CChEngine.Event;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
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
	
	public TreeMap<Integer, String[]> eventList = new TreeMap<Integer, String[]>();
	
	public CheckHelper() throws ParseException{
		try{
			BufferedReader br = new BufferedReader(new FileReader(enumFile));
			TreeMap<String, TreeMap<String, String>> tempContent = CCSParser.parseCCS(br);
			br.close();
			
			tempContent.get("Event").forEach((k,v) -> {
				event.add(v);
			});
			
			tempContent.get("User").forEach((k, v) -> {
				user.add(v);
			});
			
			tempContent = null;
			System.gc();
			
			br = new BufferedReader(new FileReader(listFile));
			tempContent = CCSParser.parseCCS(br);
			tempContent.forEach((k, v) -> {
				
					
					/*Index of items
					 * 0 = id
					 * 1 = user identification
					 * 1 = event enum
					 * 2 = date
					 * 3 = isFinished
					 * 4 = Assigned tag
					 * 5 = Assigned event
					 * 6 = specific event
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
			});
			
			
			
		}catch(FileNotFoundException e){
			throw new ParseException(ParseException.NO_FILE);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new ParseException(ParseException.UNKNOWN);
		}
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
	
}
