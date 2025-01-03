public class Mathpow {
    public static double mathPow(double x, int n) {
        double nn = n;double ans = 1.0;
        if(nn<0) nn = -1 * nn;
        while(nn>0){
            if(nn%2==1){
                ans = ans * x;
                nn = nn - 1;
            }
            else{
                x = x * x;
                nn = nn / 2;
            }
        }
        if(n<0) ans = 1 / ans;
        return ans;
    }
    public static void main(String []args){
        double result = mathPow(2.00000,-2147483648);
        System.out.println(result);
    }
}
