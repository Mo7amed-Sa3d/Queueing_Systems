package queues_project.Simulations;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.util.*;

public class MM1KSimulation {


    public MM1KSimulation(double ARRIVAL_RATE, double SERVICE_RATE, double SIMULATION_TIME, int QUEUE_CAPACITY) {
        this.ARRIVAL_RATE = ARRIVAL_RATE;
        this.SERVICE_RATE = SERVICE_RATE;
        this.numberOfSimulation = SIMULATION_TIME;
        this.QUEUE_CAPACITY = QUEUE_CAPACITY;
    }
    public MM1KSimulation(){}

        private   double ARRIVAL_RATE = 0.5;
        private   double SERVICE_RATE = 0.7;
        private   double numberOfSimulation = 10;
        private   int QUEUE_CAPACITY = 5; // Set your desired queue size limit

        private  XYSeries series;

        public  void Simulate() {
            series = new XYSeries("Simulation Graph");

            runSimulation();

            SwingUtilities.invokeLater(() -> {
                createAndShowGUI();
            });
        }

    private  void runSimulation() {
        TreeMap<Double, Integer> numberAtTime = new TreeMap<>(); //maps time to changes to number of customers at that time.
        Queue<Double> arrivals  = new LinkedList<>();       // arrivals times of customers
        PriorityQueue<Double> servers = new PriorityQueue<>();  //departure times at each server.
        PriorityQueue<Double> deps  = new PriorityQueue<>();   //departure times of served customers.
        //customers by the order in which they arrived each with number of customer and arrivals time.

        double time = 0;
        for(int i = 0; i < numberOfSimulation; i++){
            if(numberAtTime.get(time) == null) numberAtTime.put(time, 1);
            else numberAtTime.put(time, numberAtTime.get(time)+1);
            arrivals.add(time);
            double interarrival = generateExponentialRandomVariable(ARRIVAL_RATE);
            time += interarrival;
        }

        for(int i = 0; i < 1; i++) servers.add(0.0);

        for(int i = 0, served = 0, blocked = 0; i < numberOfSimulation; i++){   //i is the index of the front customer.
            while(!deps.isEmpty() && deps.peek() <= arrivals.peek()) {
                deps.poll();
                served++;
            }
            int inSystem = i - blocked - served;
            if(inSystem >= QUEUE_CAPACITY){
                blocked++;
                numberAtTime.put(arrivals.peek(), numberAtTime.get(arrivals.peek())-1);
            }
            else{
                double wait = Math.max(0, servers.peek() - arrivals.peek());
                servers.poll();
                double departure = arrivals.peek() + wait + generateExponentialRandomVariable(SERVICE_RATE);
                if(numberAtTime.get(departure) == null) numberAtTime.put(departure, -1);
                else numberAtTime.put(departure, numberAtTime.get(departure)-1);
                servers.add(departure);
                deps.add(departure);
            }
            arrivals.poll();
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


    private  double generateExponentialRandomVariable(double rate) {
            return -Math.log(Math.random()) / rate;
        }

        private  void createAndShowGUI() {
                series = new XYSeries("Simulation Graph");

                // Run multiple simulations
                runSimulation();

                // Create and display the chart
                JFreeChart chart = ChartFactory.createXYLineChart(
                        "M/M/1/K Queue Simulation",
                        "Time",
                        "Number of People in System",
                        new XYSeriesCollection(series)
                );

                ChartPanel chartPanel = new ChartPanel(chart);
                chartPanel.setPreferredSize(new java.awt.Dimension(560, 370));
                chartPanel.setMouseWheelEnabled(true);

                // Display the chart in a frame (Swing)
                javax.swing.JFrame frame = new javax.swing.JFrame("M/M/1/K Queue Simulation");
//        frame.setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
                frame.setContentPane(chartPanel);
                frame.pack();
                frame.setVisible(true);
        }
}
