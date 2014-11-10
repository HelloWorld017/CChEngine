package org.He.W.CChEngine.Event;

import java.time.LocalDate;

public class Event {
	public int eventId = 0;
	public String userIdentification = "";
	public String eventEnum = "";
	public String eventSpec = "";
	public LocalDate date = null;
	public boolean isFinished = true;
	public String assignedTag = "";
	public Event assignedEvent = null;
	
	public Event(int eventId, String userIdentification, String eventEnum, String eventSpec, LocalDate date, boolean isFinished, String assignedTag, Event assignedEvent){
		
		this.eventId = eventId;
		this.userIdentification = userIdentification;
		this.eventEnum = eventEnum;
		this.eventSpec = eventSpec;
		this.date = date;
		this.isFinished = isFinished;
		this.assignedTag = assignedTag;
		this.assignedEvent = assignedEvent;
		
	}
	
	public int getId(){
		return eventId;
	}
	
	public String getEventType(){
		return eventEnum;
	}
	
	public String getEventSpecification(){
		return eventSpec;
	}
	
	public String getDate(){
		return date.toString();
	}
	
	public LocalDate getLocalDate(){
		return date;
	}
	
	public boolean isFinished(){
		return isFinished;
	}
	
	public String getAssignedTag(){
		return assignedTag;
	}
	
	public Event getAssignedEvent(){
		return assignedEvent;
	}
}
