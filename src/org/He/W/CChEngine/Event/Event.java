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
	public String identification = "";
	
	public Event(int eventId, String userIdentification, String eventEnum, String eventSpec, LocalDate date, boolean isFinished, String assignedTag, Event assignedEvent, String identification){
		
		this.eventId = eventId;
		this.userIdentification = userIdentification;
		this.eventEnum = eventEnum;
		this.eventSpec = eventSpec;
		this.date = date;
		this.isFinished = isFinished;
		this.assignedTag = assignedTag;
		this.assignedEvent = assignedEvent;
		this.identification = identification;
	}
	
	public Event(){
		
	}
	
	public void setId(int id){
		eventId = id;
	}
	
	public void setEventType(String eventEnum){
		this.eventEnum = eventEnum;
	}
	
	public void setEventSpecification(String eventSpec){
		this.eventSpec = eventSpec;
	}
	
	public void setDate(String date){
		this.date = LocalDate.parse(date);
	}
	
	public void setLocalDate(LocalDate date){
		this.date = date;
	}
	
	public void setFinished(boolean isFinished){
		this.isFinished = isFinished;
	}
	
	public void setAssignedTag(String tag){
		this.assignedTag = tag;
	}
	
	public void setAssignedEvent(Event e){
		this.assignedEvent = e;
	}
	
	public void setUserIdentification(String s){
		identification = s;
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
	
	public boolean compareIdentification(String indentificationHash){
		return identification.equals(indentificationHash);
	}
}
