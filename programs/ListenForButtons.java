import lejos.nxt.Button;
import lejos.nxt.ButtonListener;
import lejos.nxt.LCD;

public class ListenForButtons {
  public static void main(String[] args) throws Exception {
    Button.ENTER.addButtonListener(new ButtonListener() {
      public void buttonPressed(Button b) {
        LCD.drawString("ENTER pressed", 0, 0);
      }

      public void buttonReleased(Button b) {
        LCD.clear();
      }
    });

    Button.ESCAPE.waitForPressAndRelease();
  }
}