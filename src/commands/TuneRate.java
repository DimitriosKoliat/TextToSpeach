package commands;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import text2speechapis.TextToSpeechAPI;

public class TuneRate implements ChangeListener{
	
	private manager manage;

	public TuneRate(manager man) {
		this.manage = man;
	}
	
	public void stateChanged(ChangeEvent event) {
		
        int value = manage.manageRateSlider();
        TextToSpeechAPI audioManager = manage.manageTextToSpeechAPI();
        System.out.println((float)value);
        audioManager.setRate((float)value);
        
   }

}
