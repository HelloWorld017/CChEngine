package org.He.W.CChEngine;

import java.time.LocalDate;
import java.util.ArrayList;

import org.He.W.CChEngine.Event.CheckHelper;

import javafx.application.Application;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;

public class MainActivity extends Application {

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		DatePicker checkPicker = new DatePicker(LocalDate.now());
		ArrayList<String> events = new ArrayList<String>();
		CheckHelper checkHelper = new CheckHelper();
		checkPicker.setOnAction(event ->{
			checkHelper.getSelectedDate(checkPicker.getValue());
		});
		
	}
	/*TODO add listview
	 *     add custom enum event
	 *     add custom field
	 *     add user
	 *	   check CCSGenerator
	 *     CheckHelper function add   
	 *     save as..
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
	 *
	 * : Enum.ccs
	 *CChEngine CCS File v3
	 *
	 *[User]
	 *He.W=passHash
	 *onebone=passHash
	 *
	 *[Event]
	 *0=code
	 *1=play
	 */

}
