public class SinFunc {

    private double produceElement(double n,int count){
        double res = 1;
        for(int i=1;i<=count;i++){
            res *= (n / (double)i);

        }
        return res;
    }
    public double sin(double x, int limit){
        double res = 0f;
        int sign = 1;
        for(int i=1; i<=limit;i+=2){
            res += sign*produceElement(x,i);
            sign *= -1;
        }
        return res;
    }

}
