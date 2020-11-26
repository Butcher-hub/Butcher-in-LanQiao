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
class MainCanvas extends Canvas{

	//Image leftImg,rightImg,upImg,downImg;
	//Image leftImg1,leftImg2,leftImg3;

/*
	Image [] leftImg = new Image[3];
	Image [] rightImg = new Image[3];
	Image [] upImg = new Image[3];
	Image [] downImg = new Image[3];
*/
	Image [][] heroImage = new Image[4][3];
	Image currentImg;
	int x,y;
	boolean flag;
	public MainCanvas(){
		try{
			//leftImg = Image.createImage("/sayo12.png");
		/*
			leftImg1 = Image.createImage("/sayo02.png");
			leftImg2 = Image.createImage("/sayo12.png");
			leftImg3 = Image.createImage("/sayo22.png");

			rightImg = Image.createImage("/sayo16.png");
			upImg = Image.createImage("/sayo14.png");
			downImg = Image.createImage("/sayo10.png");
		*/		

		/*	
		for(int i = 0 ; i<3 ; i++){
			rightImg[i] = Image.createImage("/sayo"+i+"6.png");
			leftImg[i] = Image.createImage("/sayo"+i+"2.png");
			upImg[i] = Image.createImage("/sayo"+i+"4.png");
			downImg[i] = Image.createImage("/sayo"+i+"0.png");
		}
		*/
		for(int i = 0 ; i<heroImage.length; i++){
			for(int j = 0 ; j<heroImage[i].length ; j++){
				heroImage[i][j] = Image.createImage("/sayo"+j+i*2+".png");
				System.out.println("每次赋值路径如下"+"/sayo"+j+i*2+".png"+"对应-->heroImage["+i+"]["+j+"]");
			}
			System.out.println();
		}
			currentImg = heroImage[0][1] ;
			x = 120;
			y = 100;
			flag =true;
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	public void paint(Graphics g){
		g.setColor(250,200,180);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,x,y,0);
	}
	public void keyPressed(int keyCode){
		int action=getGameAction(keyCode);
		if(action==LEFT){
			DoubleLegChange(1);
			x-=5;
			repaint();
		}

		if(action==RIGHT){
			DoubleLegChange(3);
			x+=5;
			repaint();
		}

		if(action==UP){
			DoubleLegChange(2);
			y-=5;
			repaint();
		}

		if(action==DOWN){
			DoubleLegChange(0);
			y+=5;
			repaint();
		}
	}

	public void DoubleLegChange(int direction){
		if(flag){
			currentImg = heroImage[direction][0] ;
			flag = false;
		}else{
			currentImg = heroImage[direction][2] ;
			flag =true;
		}
	}
}