package Testing;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.junit.Test;

import model.Line;
import view.Text2SpeechEditorView;

public class OpenDocumentTest {

	@Test
	public void test() {
		Constructor<Text2SpeechEditorView> constructor = null;
		try {
			constructor = Text2SpeechEditorView.class.getDeclaredConstructor();
		} catch (NoSuchMethodException | SecurityException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        constructor.setAccessible(true);
        Text2SpeechEditorView test = null;
		try {
			test = constructor.newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Text2SpeechEditorView.SetText2SpeechEditorView(test);
		test.getTextWords().setText("dokimh");
		test.getButton("open").doClick();
		Line[] contents = test.getCurrentManager().getDocument().getLines();
		String TextFromDisk = "";
		for(int i = 0;i<contents.length;i++) {
			TextFromDisk += String.join(" ",contents[i].getWords()) + "\n";
		}
		assertEquals(true,TextFromDisk.equals(test.getTextWords().getText()));
		
	}
}
