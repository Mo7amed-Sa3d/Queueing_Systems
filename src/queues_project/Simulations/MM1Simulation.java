package queues_project.Simulations;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.util.*;

import static queues_project.UtilityClasses.Utility.generateExponentialRandomVariable;

public class MM1Simulation {
    public MM1Simulation(double ARRIVAL_RATE, double SERVICE_RATE, int SIMULATION_TIME) {
        this.ARRIVAL_RATE = ARRIVAL_RATE;
        this.SERVICE_RATE = SERVICE_RATE;
        this.numberOfSimulation = SIMULATION_TIME;
        this.QUEUE_CAPACITY = SIMULATION_TIME + 1;
    }
    private  double ARRIVAL_RATE = 0.5;
    private  double SERVICE_RATE = 0.2;
    private  int numberOfSimulation = 1;
    private int QUEUE_CAPACITY = 123456789;

    private  XYSeries series;

    public void  Simulate(){
        series = new XYSeries("Simulation Graph");

        // Run multiple simulations
        runSimulation();

        // Create and display the chart
        JFreeChart chart = ChartFactory.createXYLineChart(
                "M/M/1 Queue Simulation",
                "Time",
                "Number of People in System",
                new XYSeriesCollection(series)
        );

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(560, 370));
        chartPanel.setMouseWheelEnabled(true);

        // Display the chart in a frame (Swing)
        javax.swing.JFrame frame = new javax.swing.JFrame("M/M/1 Queue Simulation");
//        frame.setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
        frame.setContentPane(chartPanel);
        frame.pack();
        frame.setVisible(true);
    }
    
    private  void runSimulation() {
        TreeMap<Double, Integer> numberAtTime = new TreeMap<>(); //maps time to changes to number of customers at that time.
        Queue<Double> waiting  = new LinkedList<>();       // arrival times of customers
        PriorityQueue<Double> servers = new PriorityQueue<>();
        PriorityQueue<Double> deps  = new PriorityQueue<>();   //departure times of served customers.
        //customers by the order in which they arrived each with number of customer and arrival time.

        double time = 0;
        for(int i = 0; i < numberOfSimulation; i++){
            if(numberAtTime.get(time) == null) numberAtTime.put(time, 1);
            else numberAtTime.put(time, numberAtTime.get(time)+1);
            waiting.add(time);
            double interarrival = generateExponentialRandomVariable(ARRIVAL_RATE);
            time += interarrival;
        }

        servers.add(0.0);

        for(int i = 0, served = 0, blocked = 0; i < numberOfSimulation; i++){   //i is the index of the front customer.
            while(!deps.isEmpty() && deps.peek() <= waiting.peek()) {
                deps.poll();
                served++;
            }
            int inSystem = i - blocked - served;
            if(inSystem >= QUEUE_CAPACITY){
                blocked++;
                numberAtTime.put(waiting.peek(), numberAtTime.get(waiting.peek())-1);
            }
            else{
                double wait = Math.max(0, servers.peek() - waiting.peek());
                servers.poll();
                double departure = waiting.peek() + wait + generateExponentialRandomVariable(SERVICE_RATE);
                if(numberAtTime.get(departure) == null) numberAtTime.put(departure, -1);
                else numberAtTime.put(departure, numberAtTime.get(departure)-1);
                servers.add(departure);
                deps.add(departure);
            }
            waiting.poll();
        }

        Double customers = 0.0;
        for(Map.Entry<Double, Integer> entry : numberAtTime.entrySet()){
            if(entry.getKey() > time)
                break;
            series.add(entry.getKey(), customers);
            customers += entry.getValue();
            series.add(entry.getKey(), customers);
        }
    }
}
