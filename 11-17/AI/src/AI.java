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
	Image left1,left2; //���ҽţ�����
	int x=220;
	int y=260;
	boolean flag=true;//��־�������ж����ҽţ�Ĭ��true���
	public MainCanvas(){
		try{
			imgFront = Image.createImage("/sayo14.png");
			imgLeft= Image.createImage("/sayo12.png");
			imgRight= Image.createImage("/sayo16.png");
			imgBehind= Image.createImage("/sayo10.png");
			left1=Image.createImage("/sayo02.png");//���
			left2=Image.createImage("/sayo22.png");//�ҽ�
			
			currentImg = imgFront;
		}
		catch(IOException e){
			e.printStackTrace();
		}
		
	}
	
	public void paint(Graphics g){
		
		g.setColor(0,0,0);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,x,y,0);
	}

	public void keyPressed(int keyCode){
		int action = getGameAction(keyCode);
		
		if(action==LEFT){
			//currentImg = imgLeft;
			
			if(x>0 && x<225){
				if(flag){ //���flag==true,��ʾӦ��̧���
					currentImg = left1;
					flag=false;//��һ����Ӧ�����ҽţ����԰�flag��Ϊfalse
				}else{
					currentImg = left2;
					flag=true;
				}
				x -= 5;
				System.out.println("��ǰhero����λ�ã�"+x+","+y+")");
			}else{
				System.out.println("HERO�Ѿ����߽總����������");
				x=x+5;
			}
			repaint();
		}else if(action==RIGHT){
			currentImg = imgRight;
			if(x>0 && x<225){
				x += 5;
				System.out.println("��ǰhero����λ�ã�"+x+","+y+")");
			}else{
				System.out.println("HERO�Ѿ����߽總����������");
				x=x-5;
			}
		
			repaint();
		}else if(action==UP){
			currentImg = imgFront;
			if(y>0 && y<265){
				y -= 5;
				System.out.println("��ǰhero����λ�ã�"+x+","+y+")");
			}else{
				System.out.println("HERO�Ѿ����߽總����������");
				y=y+5;
			}
			repaint();
		}else if(action==DOWN){
			currentImg = imgBehind;
			if(y>0 && y<225){
				y += 5;
				System.out.println("��ǰhero����λ�ã�"+x+","+y+")");
			}else{
				System.out.println("HERO�Ѿ����߽總����������");
				y=y-5;
			}
			repaint();
		}
	}
}