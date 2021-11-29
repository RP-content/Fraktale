public class Calculator extends Thread{
    private double X,Y;
    private int iterations,px,py;
    private Main m;
    Calculator(double X,double Y,int px,int py,int iterations,Main m){
        this.iterations=iterations;
        this.X=X;
        this.Y=Y;
        this.m=m;
        this.px=px;
        this.py=py;
    }

    @Override
    public void run() {
        double d =mandelbrot(new Complex(X,Y));
        m.cache[px][py]=d;

    }

    public double mandelbrot(Complex c){
        Complex z =new Complex(0,0);
        for (int i=0;i<iterations;i++){
            z=z.add(z.multiply(z,z),c);
            if(4<z.getLength(z)){
                return i;
            }
        }
        return -1;
    }

}
