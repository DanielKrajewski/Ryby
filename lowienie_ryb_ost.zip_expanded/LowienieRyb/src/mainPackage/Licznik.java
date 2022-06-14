package mainPackage;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Licznik extends JLabel{
    Timer timer;
    JLabel zegarek;
    int i;
    ImagePanel panel;
    

    public int second(int j) {
        timer.schedule(new Zegarek(), 1000);
        return j-1;
    }
    public Licznik(ImagePanel panel) {
        zegarek=new JLabel();
        timer = new Timer();
        timer.schedule(new Zegarek(), 1);
        this.panel = panel;

    }
    
 
    public int getI() {
        return i;
    }
    public void setI(int i) {
        this.i = i;
    }
    
   
    class Zegarek extends TimerTask {
        public void run() {
            if (i>0) {
            i=second(i);
            zegarek.setText("pozosta³e sekundy:"+i+ "     ");
            }
            else
            {
            	
                gameover();
            } 
        }

        public void gameover() {
        	panel.run = false;
        	panel.removeRyby();
        	panel.repaint();
        	panel.level = 1;
        	JOptionPane.showMessageDialog(null,"Przegrales", "",JOptionPane.INFORMATION_MESSAGE);
        	//System.exit(0);
        }
    }
    
}
