package com.He.W.onebone.Circuit.Cu.parser;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.TreeMap;

import com.He.W.onebone.Circuit.Cu.exception.ParseException;

public class CCSGenerator {
	@Deprecated
	public static BufferedWriter genCCS(BufferedWriter bw, TreeMap<String, TreeMap<String, String>> map, boolean closeBW) throws IOException{
		
		//-------------Declaration-------------
		Iterator<Entry<String, TreeMap<String, String>>> i = map.entrySet().iterator();
		Iterator<Entry<String, String>> tempIterator;
		Entry<String, TreeMap<String, String>> tempEntry;
		Entry<String, String> tempEntry2;
		
		//-------------Writing CCS-------------
		bw.write("CChEngine CCS File v" + CCSParser.MAX_FILE_VERSION);
	
		
		while(i.hasNext()){
			tempEntry = i.next();
			
			bw.newLine();
			bw.append("[" + tempEntry.getKey() + "]");
			//[Content]
			
			tempIterator = tempEntry.getValue().entrySet().iterator();
			
			while(tempIterator.hasNext()){
				tempEntry2 = tempIterator.next();
				bw.newLine();
				bw.append(tempEntry2.getKey() + "=" + tempEntry2.getValue());
				//Key=Value
			}
			
			bw.newLine();
			bw.append("[/]");
		}
		bw.flush();
		if(closeBW){
			bw.close();
		}
		
		return bw;
	}
	
	
	public static long counter;
	
	public static BufferedWriter generateCCS(BufferedWriter bw, TreeMap<String, TreeMap<String, String>> map, TreeMap<Integer, String> annotations, boolean closeBW) throws IOException{
		counter = 0;
		
		bw.write("CChEngine CCS File v" + CCSParser.MAX_FILE_VERSION);
		counter++;
		if((annotations != null) && annotations.containsKey(counter)){
			bw.newLine();
			bw.append(annotations.get(counter));
		}
		
		map.forEach((k, v)->{
			try{
				bw.newLine();
				bw.append("[" + k + "]");
				counter++;
				if((annotations != null) && annotations.containsKey(counter)){
					bw.newLine();
					bw.append(annotations.get(counter));
				}
				v.forEach((String key, String value)->{
					try{
						bw.newLine();
						bw.append(key + "=" + value);
						counter++;
						if((annotations != null) && annotations.containsKey(counter)){
							bw.newLine();
							bw.append(annotations.get(counter));
						}
					}catch(IOException e){
						throw new RuntimeException(e);
					}
				});
				bw.newLine();
				bw.append("[/]");
				counter++;
				if((annotations != null) && annotations.containsKey(counter)){
					bw.newLine();
					bw.append(annotations.get(counter));
				}
			}catch(IOException e){
				throw new RuntimeException(e);
			}
		});
		bw.flush();
		if(closeBW){
			bw.close();
		}
		
		return bw;
	}
	
	public static BufferedWriter appendCCS(File f, TreeMap<String, TreeMap<String, String>> map, TreeMap<Integer, String> annotations, boolean closeBW) throws IOException, ParseException{
		BufferedReader br = new BufferedReader(new FileReader(f));
		if(!br.readLine().startsWith("CChEngine CCS File v")){
			br.close();
			throw new ParseException(ParseException.WRONG_FILE);
		}
		counter = br.lines().count();
		br.close();
		BufferedWriter bw = new BufferedWriter(new FileWriter(f, true));
		map.forEach((k, v)->{
			try{
				bw.newLine();
				bw.append("[" + k + "]");
				counter++;
				if((annotations != null) && annotations.containsKey(counter)){
					bw.newLine();
					bw.append(annotations.get(counter));
				}
				v.forEach((String key, String value)->{
					try{
						bw.newLine();
						bw.append(key + "=" + value);
						counter++;
						if((annotations != null) && annotations.containsKey(counter)){
							bw.newLine();
							bw.append(annotations.get(counter));
						}
					}catch(IOException e){
						throw new RuntimeException(e);
					}
				});
				bw.newLine();
				bw.append("[/]");
				counter++;
				if((annotations != null) && annotations.containsKey(counter)){
					bw.newLine();
					bw.append(annotations.get(counter));
				}
			}catch(IOException e){
				throw new RuntimeException(e);
			}
		});
		bw.flush();
		if(closeBW){
			bw.close();
		}
		return bw;
	}
}
