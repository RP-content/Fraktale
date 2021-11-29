import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame {
    public double scaleX= 0.005;
    public double scaleY= 0.005;
    public double shiftX=0;
    public double shiftY=0;
    public double shiftXpoint=0;
    public double shiftYpoint=0;
    public double mouseX=0;
    public double mouseY=0;
    public double mouseXpoint=0;
    public double mouseYpoint=0;
    public boolean b=false;
    public int iterations =200;
    public volatile double[][] cache=new double[1400][1000];
    Main(){
        Container cp=this.getContentPane();
        Design.applyDesign(cp,this);
        cp.setSize(1500,1000);
        cp.setBounds(0,0,1500,1000);
        draw();
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_A){
                    b=true;
                    shiftXpoint=shiftX;
                    shiftYpoint=shiftY;
                    iterations=20;
                    mouseXpoint=mouseX;
                    mouseYpoint=mouseY;
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_A){
                    b=false;
                    iterations=150;
                    draw();

                }

            }
        });
        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                super.mouseMoved(e);
                mouseX=e.getX();
                mouseY=e.getY();
                if (b){
                    shiftX=shiftXpoint+mouseX-mouseXpoint;
                    shiftY=shiftYpoint+mouseY-mouseYpoint;
                    draw();
                }

            }
        });
        this.addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                double d=e.getPreciseWheelRotation();
                System.out.println(d);
                if (d<0){
                    scaleX=0.9*scaleX;
                    scaleY=0.9*scaleY;
                    shiftX=1.1*shiftX;
                    shiftY=1.1*shiftY;
                }else {
                    scaleX=1.1*scaleX;
                    scaleY=1.1*scaleY;
                    shiftX=0.9*shiftX;
                    shiftY=0.9*shiftY;
                }

                draw();
            }
        });
    }
    public static void main(String[] args) {
        new Main();
    }

    public int a =1000;
    public void draw(){


        for (int x=0;x<a*1.4;x++){
            double xx= ((x-a/2+shiftX)*scaleX);
            Calculator c=new Calculator(xx,x,iterations,this);
            c.run();

            /*
            for (int y=0;y<a;y++){
                double xx= ((x-a/2+shiftX)*scaleX);
                double yy= ((y-a/2+shiftY)*scaleY);
                Calculator c=new Calculator(xx,yy,x,y,iterations,this);
                c.run();


                //System.out.println("X: "+xx+" Y: "+yy+" d: "+d);

            }*/
        }
        repaint();
    }

    public double mandelbrot(Complex c){
        Complex z =new Complex(0,0);
        for (int i=0;i<iterations;i++){
            z=z.add(z.multiply(z,z),c);
            if(4<z.getLength(z)){
                return 5;
            }
        }

    return z.getLength(z);
    }
/*
    public void test()  {

        Calculator c = new Calculator(1.1,1.1,100);
        Thread thread =new Thread(c);
        thread.run();
        try {
            thread.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }*/

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for(int x=0;x<1400;x++){
            for(int y=0;y<1000;y++){
                double d=cache[x][y];
                if (d>0){
                    g.setColor(Color.black);

                }else {
                    g.setColor(Color.white);
                }
                g.drawRect(x+10,y+10,1,1);

            }
        }

    }
}
