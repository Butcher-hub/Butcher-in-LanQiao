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
class MainCanvas extends Canvas implements Runnable
{
	Image imgFront,imgLeft,imgRight,imgBehind,currentImg;
	Image left1,left2; //���ҽţ�����

//ʹ�ö�ά����Ľ�
//�б�ʾ�ĸ������б�ʾ�ĸ����������ͼƬ
	Image [][] heroMove = new Image[4][3];
	
	Image bossImg ;

	

	int x=120;
	int y=120;

	int bossX = 0;
	int bossY = 0;


	boolean flag=true;//��־�������ж����ҽţ�Ĭ��true���

	
	
	public void run(){
		
		while(true){
			try{
				Thread.sleep(200);
			}catch(Exception e){
				e.printStackTrace();
			}
			if(bossX<x && bossX<225){
				bossX++;
			}else if(bossX>x && bossX>0){
				bossX--;
			}
			if(bossY<y && bossY<265){
				bossY++;
			}else if(bossY>y && bossY>0){
				bossY--;
			}
			repaint();
			System.out.println("����ִ����");
		}
	}

	
	
	public MainCanvas(){
		try{
			
			/*
			imgFront = Image.createImage("/sayo14.png");
			imgLeft= Image.createImage("/sayo12.png");
			imgRight= Image.createImage("/sayo16.png");
			imgBehind= Image.createImage("/sayo10.png");
			left1=Image.createImage("/sayo02.png");//���
			left2=Image.createImage("/sayo22.png");//�ҽ�
			*/
		Thread bossTh = new Thread(this);
		bossTh.start();
	
			
			bossImg = Image.createImage("/benzaiten.png");
			for(int i = 0 ; i<4 ; i++){
			//��һ��forΪ�ĸ�����
				for(int j = 0 ; j<3 ; j++){
				heroMove [i][j] = Image.createImage("/sayo"+j+""+i*2+".png");
				}
			}
			
			//currentImg = imgFront;
			currentImg = heroMove[0][1];
		}
		catch(IOException e){
			e.printStackTrace();
		}	
	}
	
	public void paint(Graphics g){
		g.setColor(0,0,0);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,x,y,0);
		g.drawImage(bossImg,bossX,bossY,0);
	}

	public void keyPressed(int keyCode){
		int action = getGameAction(keyCode);
		
		if(action==LEFT){
			doubleLegMove(1);
			x -= 5;
			System.out.println("��ǰhero����λ�ã�"+x+","+y+")");
			repaint();
		}else if(action==RIGHT){
			doubleLegMove(3);
			x += 5;
			System.out.println("��ǰhero����λ�ã�"+x+","+y+")");
			repaint();
		}else if(action==UP){
			doubleLegMove(2);
			y -= 5;
			System.out.println("��ǰhero����λ�ã�"+x+","+y+")");
			repaint();
		}else if(action==DOWN){
			doubleLegMove(0);
			y += 5;
			System.out.println("��ǰhero����λ�ã�"+x+","+y+")");
			repaint();
		}
	}


	public void doubleLegMove(int num){
		currentImg = heroMove[num][1];
		if(flag){ //���flag==true,��ʾӦ��̧���
			currentImg = heroMove[num][0];
			flag=false;//��һ����Ӧ�����ҽţ����԰�flag��Ϊfalse
		}else{
			currentImg = heroMove[num][2];
			flag=true;
		}
	}

}