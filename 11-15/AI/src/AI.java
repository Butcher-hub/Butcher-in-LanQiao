import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import java.io.*;
public class AI extends MIDlet
{
	Display display;
	MainCanvas mc;
	public AI(){
		display=Display.getDisplay(this);
		mc=new MainCanvas();
		display.setCurrent(mc);
	}
	public void startApp(){
	}
	public void destroyApp(boolean unc){
	}
	public void pauseApp(){
	}
}
class MainCanvas extends Canvas
{
	Image imgFront,imgLeft,imgRight,imgBehind,currentImg;
	public MainCanvas(){
		try{
			imgFront = Image.createImage("/sayo10.png");
			imgLeft= Image.createImage("/sayo12.png");
			imgRight= Image.createImage("/sayo16.png");
			imgBehind= Image.createImage("/sayo14.png");

			currentImg = imgFront;
		}
		catch(IOException e){
			e.printStackTrace();
		}
		
	}
	
	public void paint(Graphics g){
		
		g.setColor(255,0,0);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,120,120,0);
	}

	public void keyPressed(int keyCode){
		int action = getGameAction(keyCode);

		if(action==LEFT){
			currentImg = imgLeft;
			repaint();
		}else if(action==RIGHT){
			currentImg = imgRight;
			repaint();
		}else if(action==UP){
			currentImg = imgFront;
			repaint();
		}else if(action==DOWN){
			currentImg = imgBehind;
			repaint();
		}
	}
}