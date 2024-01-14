package queues_project.Equations;

public class MMC {
    double r;
    double arrivalRate;
    double serviceRate;
    int C;
    int K;

    public MMC(double arrivalRate, double serviceRate, int capacity, int numberofCustomers) {
        this.arrivalRate = arrivalRate;
        this.serviceRate = serviceRate;
        this.C = capacity;
        this.K = numberofCustomers;
        this.r = arrivalRate / serviceRate;

    }

    public double getL() {
        double L = getLq() + r;
        return L;
    }


    public double getLq() {
        double f1 = ((Math.pow(r, C)) * (arrivalRate * serviceRate));     //البسط

        double f2 = (calculateFactorial(C - 1));

        double f3 = (Math.pow((C * serviceRate) - arrivalRate, 2));

        double f4 = f2 * f3; //المقام

        double f5 = (f1 / f4);
//        double Lq = Math.floor((calculatep0() * f5) * 1000.0) / 1000.0;
        double Lq = (calculatep0() * f5);
        return Lq;
    }

    public double getW() {
        double W = getWq() + (1 / serviceRate);
        return W;
    }

    public double getWq() {
        double Wq = (getLq()) / (arrivalRate);

        return Wq;
    }

    public double calculatep0() {
        double p0 = 0;
        if ((r / C) < 1) {
            double f1 = calculateSummetion(C - 1);

            double f2 = (((C) * (Math.pow(r, C))) / ((calculateFactorial(C)) * (C - r)));
            double f3 = f1 + f2;
            p0 = 1 / f3;
        } else {
            double f1 = calculateSummetion(C - 1);
            double f2 = (Math.pow(r, C));
            double f3 = (1) / (calculateFactorial(C));
            double f4 = (C * serviceRate) / ((C * serviceRate) - arrivalRate);
            double f5 = f2 * f3 * f4;
            double f6 = f5 + f1;
            p0 = 1 / f6;
        }

        return p0;
    }

    public double calculateFactorial(double n) {
        double result = 1;
        for (double i = n; i > 0; i--) {
            result *= i;
        }
        return result;
    }

    public double calculateSummetion(int end) {
        double res = 0;
        for (int first = 0; first <= end; first++) {
            res += (Math.pow(r, first)) / (calculateFactorial(first));

        }
        return res;
    }
}
       
