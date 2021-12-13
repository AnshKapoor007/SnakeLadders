/*Problem in dice*/
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import java.util.Random;
import java.io.*;
/*
<applet code='SnakeLadders' width=720 height=600>
</applet>
*/
public class SnakeLadders extends Applet implements MouseListener
{
    int x,y,w,h,k,p,k0,p0,block,r_no,sna,lad,player1,player2;
    Font F1=new Font("TimesRoman",Font.BOLD,10);
    Font F2=new Font("TimesRoman",Font.BOLD,30);
    Font F3=new Font("TimesRoman",Font.BOLD,20);
    Color c[]={Color.blue,Color.yellow};
    Random rand=new Random();
    TextField tf0=new TextField("Player 1");
    TextField tf1=new TextField("Player 2");
    void sleep()
    {
        try{
            Thread.sleep(5000);
        }catch(Exception e){
            System.out.println("HI");
        }
    }
    public void init()
    {
        y=0;
        x=0;
        k=0;
        p=0;
        k0=0;
        p0=0;
        sna=-1;
        lad=-1;
        player1=1;
        player2=0;
        tf0.setBounds(610,20,100,25);
        tf1.setBounds(610,55,100,25);
        this.addMouseListener(this);
        this.add(tf0);
        this.add(tf1);
        h=getHeight();
        w=getWidth()-(2*getWidth()/12);
        block=100;
        this.setLayout(null);
    }
    public void mouseClicked(MouseEvent e)
    {
        repaint();
    }
    public void mousePressed(MouseEvent e)
    {}
    public void mouseReleased(MouseEvent e)
    {}
    public void mouseEntered(MouseEvent e)
    {}
    public void mouseExited(MouseEvent e)
    {}
    public static int snake(int a)
    {
        switch(a)
        {
            case 98:
                return 7;
            case 93:
                return 56;
            case 95:
                return 70;
            case 87:
                return 44;
            case 64:
                return 22;
            case 46:
                return 23;
            case 59:
                return 10;
            case 17:
                return 5;
            default:
                return -1;
        }
    }
    public static int ladder(int a)
    {
        switch(a)
        {
            case 4:
                return 34;
            case 11:
                return 32;
            case 36:
                return 55;
            case 57:
                return 85;
            case 50:
                return 99;
            case 19:
                return 48;
            default:
                return -1;
        }
    }
    public void update(Graphics g)
    {
        r_no=rand.nextInt(6)+1;
        g.setColor(Color.black);
        g.setFont(F3);
        g.drawString("*Ladders",610,160);
        g.setColor(Color.red);
        g.setFont(F3);
        g.drawString("*Snakes",610,185);
    
        if(p>=540 && k+360>=540)
        {
            if(r_no*60>=k-540)
            {
                p=540;
                k=540;
                g.setColor(Color.red);
                g.fillOval(555-k,545-p,25,25);
                g.setFont(F2);
                g.setColor(Color.white);
                String winner=tf0.getText().toString();
                g.drawString(winner+" Win",200,300);
                try{
                    FileWriter fstream=new FileWriter(System.currentTimeMillis()+"out.txt");
                    BufferedWriter out=new BufferedWriter(fstream);
                    out.write(winner);
                    out.close();
                }catch(Exception e){System.out.println(e);}
            }
            sleep();    
        }
        else if(p0>=540 && k0+360>=540)
        {
            if(r_no*60>=k0-540)
            {
                p0=540;
                k0=540;
                g.setColor(Color.green);
                g.fillOval(555-k0,575-p0,25,25);
                g.setColor(Color.white);
                g.setFont(F2);
                String winner=tf1.getText().toString();
                g.drawString(winner+" Win",200,300);
                try{
                    FileWriter fstream=new FileWriter(System.currentTimeMillis()+"out.txt");
                    BufferedWriter out=new BufferedWriter(fstream);
                    out.write(winner);
                    out.close();
                }catch(Exception e){System.out.println(e);}
            }
            sleep();    
        }
        for(int i=0;i<10;i++)
        {
            for(int j=0;j<10;j++)
            {
                g.setColor(c[(i+j)%2]);
                g.fillRect(x,y,60,60);
                g.setColor(Color.black);
                g.setFont(F1);
                g.drawString(""+block,x+5,y+12);
                x+=(w/10);
                block-=1;
            }
            y+=(h/10);
            x=0;
        }
        g.setColor(Color.black);

        g.drawLine(390,570,390,390);
        g.drawLine(388,570,388,390);
        g.drawLine(392,570,392,390);

        g.drawLine(570,510,510,390);
        g.drawLine(568,510,508,390);
        g.drawLine(572,510,512,390);

        g.drawLine(270,390,330,270);
        g.drawLine(268,390,328,270);
        g.drawLine(272,390,332,270);

        g.drawLine(210,270,330,90);
        g.drawLine(208,270,328,90);
        g.drawLine(212,270,332,90);

        g.drawLine(30,330,90,30);
        g.drawLine(28,330,88,30);
        g.drawLine(32,330,92,30);

        g.drawLine(90,510,150,330);
        g.drawLine(88,510,148,330);
        g.drawLine(92,510,152,330);

        g.setColor(Color.red);

        g.drawLine(150,30,210,570);
        g.drawLine(148,30,208,570);
        g.drawLine(152,30,212,570);

        g.drawLine(450,30,270,270);
        g.drawLine(448,30,268,270);
        g.drawLine(452,30,272,270);

        g.drawLine(330,30,30,210);
        g.drawLine(328,30,28,210);
        g.drawLine(332,30,32,210);

        g.drawLine(210,90,390,330);
        g.drawLine(208,90,388,330);
        g.drawLine(212,90,392,330);

        g.drawLine(390,210,510,450);
        g.drawLine(388,210,508,450);
        g.drawLine(392,210,512,450);

        g.drawLine(270,330,450,450);
        g.drawLine(268,330,448,450);
        g.drawLine(272,330,452,450);

        g.drawLine(90,270,30,570);
        g.drawLine(88,270,28,570);
        g.drawLine(92,270,32,570);

        g.drawLine(210,510,330,570);
        g.drawLine(208,510,328,570);
        g.drawLine(212,510,332,570);

        g.setColor(Color.black);
        g.setFont(F2);
        g.drawRoundRect(610,498,100,100,10,10);
        g.drawString(""+r_no,652,558);

        if(player1==1)
        {
            g.setColor(Color.red);
            g.fillOval(555-k,545-p,25,25);
            player1=0;
            player2=1;
            k=k+r_no*60;
            if(k>540)
            {
                k=(k%540)-60;
                p=p+60;
            }
            sna=SnakeLadders.snake((p/60)*10+k/60+1);
            lad=SnakeLadders.ladder((p/60)*10+k/60+1);
            if(sna!=-1)
            {
                if(sna%10==0)
                {
                    p=((sna/10)*60)-60;
                    k=540;
                }
                else
                {
                    p=(sna/10)*60;
                    k=((sna%10)-1)*60;
                }
            }
            if(lad!=-1)
            {
                if(lad%10==0)
                {
                    p=((lad/10)*60)-1;
                    k=0;
                }
                else
                {
                    p=(lad/10)*60;
                    k=((lad%10)-1)*60;
                }
            }
            g.setColor(Color.green);
            g.fillOval(555-k0,575-p0,25,25);
        }
        else
        {
            g.setColor(Color.green);
            g.fillOval(555-k0,575-p0,25,25);
            player1=1;
            player2=0;
            k0=k0+r_no*60;
            if(k0>540)
            {
                k0=(k0%540)-60;
                p0=p0+60;
            }
            sna=SnakeLadders.snake((p0/60)*10+k0/60+1);
            lad=SnakeLadders.ladder((p0/60)*10+k0/60+1);
            if(sna!=-1)
            {
                if(sna%10==0)
                {
                    p0=((sna/10)*60)-60;
                    k0=540;
                }
                else
                {
                    p0=(sna/10)*60;
                    k0=((sna%10)-1)*60;
                }
            }
            if(lad!=-1)
            {
                if(lad%10==0)
                {
                    p0=((lad/10)*60)-1;
                    k0=0;
                }
                else
                {
                    p0=(lad/10)*60;
                    k0=((lad%10)-1)*60;
                }
            }
            g.setColor(Color.red);
            g.fillOval(555-k,545-p,25,25);
        }
        x=0;
        y=0;
        block=100;
        System.out.println(r_no);
    }
    public void paint(Graphics g)
    {
        update(g);
    }
}