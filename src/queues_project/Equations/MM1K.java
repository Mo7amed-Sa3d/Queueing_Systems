package queues_project.Equations;
public class MM1K 
{
   double arrivalRate;  
   double serviceRate;
   int C;
   int K;

    public MM1K(double arrivalRate, double serviceRate, int capacity ,  int numberofCustomers) {
         this.arrivalRate = arrivalRate ; 
        this.serviceRate =serviceRate ;  
        this.C = capacity ;
        this.K = numberofCustomers ;
    }

    public double calcRo() {
        return (arrivalRate / serviceRate);
    }

    public double calcPk() {
        double Pk = 0;
        double ro = calcRo();
        if (ro == 1) {
            Pk = 1 / (1 + K);
        } else {
            double f1 = 1 - ro;
            double f2 = 1 - (Math.pow(ro, K + 1));
            Pk = (f1 / f2) * (Math.pow(ro, K));
        }
        return Pk;
    }

    public double lamdaDash() {
        return arrivalRate * (1 - calcPk());
    }

    public double getL() {
        double ro = calcRo();
        double  L = 0 ;  
        if (ro == 1) {
            L= K / 2;
        } else {
            double f1 = (1 - ((K + 1) * (Math.pow(ro, K))) + (K * Math.pow(ro, K + 1)));
            double f2 = ((1 - ro) * (1 - (Math.pow(ro, K + 1))));
            L = (ro * (f1 / f2));
        }
        return L;
    }

    public double getLq() {
        double Lq= getWq() * lamdaDash();
        return Lq;
    }


    public double getW() {
        double W = ((getL()) / lamdaDash());
        return W;
    }


    public double getWq() {
        double Wq = (getW() - (1 / serviceRate));
        return Wq;
    } 
}
