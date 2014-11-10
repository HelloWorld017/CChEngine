package org.He.W.CChEngine.Event;

public class NoEventFoundException extends Exception{

	private static final long serialVersionUID = -5434241347514163645L;
	
	private String str = "";
	
	public NoEventFoundException(String s){
		str = "No Event Found! : " + s;
	}
	
	public NoEventFoundException(){
		str = "No Event Found!";
	}
	
	public String toString(){
		return str;
	}
}
