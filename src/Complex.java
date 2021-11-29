public class Complex {
    double absolut,imaginary;

    Complex(double absolut,double imaginary){
        this.absolut=absolut;
        this.imaginary=imaginary;
    }

    public Complex multiply(Complex c1,Complex c2){
        return new Complex(c1.getAbsolut()*c2.getAbsolut()-c2.getImaginary()*c1.getImaginary(),c1.getAbsolut()*c2.getImaginary()+c2.getAbsolut()*c1.getImaginary());
    }

    public Complex add(Complex c1, Complex c2){
        return new Complex(c1.getAbsolut()+c2.getAbsolut(),c1.getImaginary()+c2.getImaginary());
    }
    public double getLength(Complex c1){
        return Math.sqrt(c1.getAbsolut()*c1.getAbsolut()+c1.getImaginary()*c1.getImaginary());

    }

    public double getAbsolut() {
        return absolut;
    }

    public double getImaginary() {
        return imaginary;
    }
}
