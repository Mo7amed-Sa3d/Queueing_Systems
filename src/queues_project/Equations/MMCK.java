package queues_project.Equations;
public class MMCK 
{
   double r , ro; 
   double arrivalRate;  
   double serviceRate;
   int C;
   int K;
 
    public MMCK(double arrivalRate, double serviceRate, int capacity, int numberOfCusotmers)
    {
        this.arrivalRate = arrivalRate ; 
        this.serviceRate =serviceRate ;  
        this.C = capacity ;
        this.K = numberOfCusotmers ;
        this.r = arrivalRate / serviceRate ;
        this.ro = this.r / this.C;
    } 
    public double calculatePn(double r, int n, int c) {
        if (n >= 0 && n < c) {
            double f1 = Math.pow(r, n) * calculateP0(r, c);
            double f2 = f1 / calculateFactorial(n);
            return f2;
        } else if (n >= c && n <= K) {
            double f1 = Math.pow(r, n) * calculateP0(r, c);
            double f2 = calculateFactorial(c) * (Math.pow(C, n - c));
            double f3 = f1 / f2;
            return f3;
        } else {
            System.out.println("error");
            return 0;
        }
    }

    public double calculateP0(double r, int c) {
        double res = 0;
        if (this.ro != 1) {
            res += calculateSummetion(0, C - 1);
            double f1 = Math.pow(this.r, C);
            double f2 = f1 / (calculateFactorial(C));
            double f3 = 1 - (Math.pow(this.ro, K - C + 1));
            double f4 = 1 - this.ro;
            double f5 = f2 * (f3 / f4);
            res += f5;
            res = 1 / res;
        } else {
            res += calculateSummetion(0, C - 1);
            double f1 = Math.pow(this.r, C);
            double f2 = f1 / (calculateFactorial(C));
            double f3 = K - C + 1;
            double f4 = f3 * f2;
            res += f4;
            res = 1 / res;
        }

        return res;
    }

    public double calcSumForL(double first, double end) {
        double res = 0;
        for (; first <= end; first++) {
            res += ((Math.pow(this.r, first)) / (calculateFactorial(first)))
                    * (C - first);
        }
        return res;
    }

    public double calculateSummetion(double first, double end) {
        double res = 0;
        for (; first <= end; first++) {
            res += (Math.pow(this.r, first)) / (calculateFactorial(first));
        }
        return res;
    }

    public double lamdaDash() {
        return this.arrivalRate * (1 - calculatePn(this.r, K, C));
    }

    public double getL() {
        double f1 = getLq() + C;
        double f2 = 0;
        double res = calculateP0(this.r, C) * calcSumForL(0, C - 1);
        f2 = res;
        double f3 = f1 - f2;
        return f3;
    }

    public double getLq() {
        double f0 = this.ro * (Math.pow(this.r, C));
        double f1 = calculateP0(this.r, C) * (f0);

        double f2 = calculateFactorial(C) * (Math.pow(1 - this.ro, 2));

        double f3 = f1 / f2;
        double f4 = 1 - (Math.pow(this.ro, K - C + 1)) - ((1 - this.ro) * (K - C + 1) * (Math.pow(this.ro, K - C)));


        double f5 = f4 * f3;
        return f5;
    }

    public double getW() {
        return (getL() / lamdaDash());
    }

    public double getWq() {
        return (getLq() / lamdaDash());
    }

    public double calculateFactorial(double n) {
        double result = 1;
        for (double i = n; i > 0; i--) {
            result = result * (i);
        }
        return result;
    }
}
