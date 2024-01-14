package queues_project.Equations;
public class MM1 
{
    double arrivalRate;  
    double serviceRate;
    int C;
    int K;
    public MM1(double arrivalRate, double serviceRate, int capacity, int numberOfCustomers)
    {
        this.arrivalRate = arrivalRate ; 
        this.serviceRate =serviceRate ;  
        this.C = capacity ;
        this.K = numberOfCustomers ;
    }

    public double getL() 
    {
        return (arrivalRate / (serviceRate - arrivalRate));
    }

    public double getLq() 
    {
       return ((arrivalRate*arrivalRate) / (serviceRate*(serviceRate - arrivalRate)));
    }
  
    public double getW() 
    {
        return (1/(serviceRate - arrivalRate));
    }
  
    public double getWq() 
    {
        return ((arrivalRate) / (serviceRate*(serviceRate - arrivalRate)));
    }

}