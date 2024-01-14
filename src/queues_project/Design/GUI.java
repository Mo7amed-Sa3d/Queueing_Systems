package queues_project.Design;

import queues_project.Equations.MM1;
import queues_project.Equations.MM1K;
import queues_project.Equations.MMC;
import queues_project.Equations.MMCK;
import queues_project.Simulations.MM1KSimulation;
import queues_project.Simulations.MM1Simulation;
import queues_project.Simulations.MMCKSimulation;
import queues_project.Simulations.MMCSimulation;
import queues_project.UtilityClasses.Utility;

import javax.swing.*;
import java.awt.*;

public class GUI extends javax.swing.JFrame {
    public GUI() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Input = new javax.swing.JPanel();
        lambda = new javax.swing.JLabel();
        TextField_lambda = new javax.swing.JTextField();
        MU = new javax.swing.JLabel();
        TextField_MU = new javax.swing.JTextField();
        C = new javax.swing.JLabel();
        TextField_C = new javax.swing.JTextField();
        K = new javax.swing.JLabel();
        TextField_K = new javax.swing.JTextField();
        Button_Calculate = new javax.swing.JButton();
        Button_Clear = new javax.swing.JButton();
        Simulate = new javax.swing.JButton();
        SumulationTime = new javax.swing.JLabel();
        TextFiled_SumulationTime = new javax.swing.JTextField();
        Output = new javax.swing.JPanel();
        L = new javax.swing.JLabel();
        TextField_L = new javax.swing.JTextField();
        Lq = new javax.swing.JLabel();
        TextField_Lq = new javax.swing.JTextField();
        W = new javax.swing.JLabel();
        TextField_W = new javax.swing.JTextField();
        Wq = new javax.swing.JLabel();
        TextField_Wq = new javax.swing.JTextField();
        Type = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("GUI ");
        setBackground(new java.awt.Color(102, 102, 102));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Input.setBackground(new java.awt.Color(194, 194, 194));
        Input.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lambda.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lambda.setText("arrival rate (λ)");
        Input.add(lambda, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 130, 50));

        TextField_lambda.setForeground(new java.awt.Color(204, 204, 204));
        TextField_lambda.setText("Enter Lambda Value");
        TextField_lambda.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TextField_lambdaFocusGained(evt);
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                TextField_lambdaFocusLost(evt);
            }
        });
        TextField_lambda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextField_lambdaActionPerformed(evt);
            }
        });
        Input.add(TextField_lambda, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, 260, 40));

        MU.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        MU.setText("service rate  (µ)");
        Input.add(MU, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 130, -1));

        TextField_MU.setForeground(new java.awt.Color(204, 204, 204));
        TextField_MU.setText("Enter MU Value");
        TextField_MU.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TextField_MUFocusGained(evt);
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                TextField_MUFocusLost(evt);
            }
        });
        TextField_MU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextField_MUActionPerformed(evt);
            }
        });
        Input.add(TextField_MU, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 80, 260, 40));

        C.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        C.setText("#Servers");
        Input.add(C, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 120, 30));

        TextField_C.setForeground(new java.awt.Color(204, 204, 204));
        TextField_C.setText("Enter  C  Value");
        TextField_C.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TextField_CFocusGained(evt);
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                TextField_CFocusLost(evt);
            }
        });
        TextField_C.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextField_CActionPerformed(evt);
            }
        });
        Input.add(TextField_C, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 140, 260, 40));

        K.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        K.setText("#Customers");
        Input.add(K, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 130, -1));

        TextField_K.setForeground(new java.awt.Color(204, 204, 204));
        TextField_K.setText("Enter K  Value");
        TextField_K.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TextField_KFocusGained(evt);
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                TextField_KFocusLost(evt);
            }
        });
        TextField_K.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextField_KActionPerformed(evt);
            }
        });
        Input.add(TextField_K, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 200, 260, 40));

        Button_Calculate.setBackground(new java.awt.Color(102, 102, 255));
        Button_Calculate.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        Button_Calculate.setForeground(new java.awt.Color(0, 0, 204));
        Button_Calculate.setText("Calculate");
        Button_Calculate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_CalculateActionPerformed(evt);
            }
        });
        Input.add(Button_Calculate, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 350, 100, 30));

        Button_Clear.setBackground(new java.awt.Color(255, 102, 102));
        Button_Clear.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        Button_Clear.setForeground(new java.awt.Color(153, 0, 51));
        Button_Clear.setText("Clear");
        Button_Clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_ClearActionPerformed(evt);
            }
        });
        Input.add(Button_Clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 350, 110, 30));

        Simulate.setBackground(new java.awt.Color(153, 255, 153));
        Simulate.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        Simulate.setForeground(new java.awt.Color(51, 153, 0));
        Simulate.setText("simulate ");
        Simulate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SimulateActionPerformed(evt);
            }
        });
        Input.add(Simulate, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 350, 110, 30));

        SumulationTime.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        SumulationTime.setText("#Simulations");
        Input.add(SumulationTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, 120, 30));

        TextFiled_SumulationTime.setForeground(new java.awt.Color(204, 204, 204));
        TextFiled_SumulationTime.setText("Enter T Value");
        TextFiled_SumulationTime.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TextFiled_SumulationTimeFocusGained(evt);
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                TextFiled_SumulationTimeFocusLost(evt);
            }
        });
        TextFiled_SumulationTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFiled_SumulationTimeActionPerformed(evt);
            }
        });
        Input.add(TextFiled_SumulationTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 260, 260, 40));

        getContentPane().add(Input, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 390));

        Output.setBackground(new java.awt.Color(252, 252, 252));
        Output.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        L.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        L.setText("L");
        Output.add(L, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 50, 30));

        TextField_L.setBackground(new java.awt.Color(204, 204, 204));
        Output.add(TextField_L, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, 260, 40));

        Lq.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        Lq.setText("Lq");
        Output.add(Lq, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 40, 30));

        TextField_Lq.setBackground(new java.awt.Color(204, 204, 204));
        Output.add(TextField_Lq, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, 260, 40));

        W.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        W.setText("W");
        Output.add(W, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 30, 30));

        TextField_W.setBackground(new java.awt.Color(204, 204, 204));
        Output.add(TextField_W, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 130, 260, 40));

        Wq.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        Wq.setText("Wq");
        Output.add(Wq, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, -1, -1));

        TextField_Wq.setBackground(new java.awt.Color(204, 204, 204));
        Output.add(TextField_Wq, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, 260, 40));

        Type.setBackground(new java.awt.Color(204, 204, 204));
        Type.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        Type.setForeground(new java.awt.Color(255, 102, 0));
        Type.setText("System-Type");
        Type.setMargin(new java.awt.Insets(2, 4, 2, 2));
        Output.add(Type, new org.netbeans.lib.awtextra.AbsoluteConstraints(487, 30, 100, 90));

        getContentPane().add(Output, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 390, 610, 220));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TextField_CActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextField_CActionPerformed

    }//GEN-LAST:event_TextField_CActionPerformed

    private void TextField_KActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextField_KActionPerformed

    }//GEN-LAST:event_TextField_KActionPerformed

    private void TextField_lambdaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextField_lambdaActionPerformed
    }//GEN-LAST:event_TextField_lambdaActionPerformed

    private void TextField_MUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextField_MUActionPerformed
    }//GEN-LAST:event_TextField_MUActionPerformed

    private void calculate() {
        double lambda = Utility.convertToNumber(TextField_lambda.getText());
        double mu = Utility.convertToNumber(TextField_MU.getText());
        int C = Integer.valueOf(TextField_C.getText());
        int K = Integer.valueOf(TextField_K.getText());

        int choose = Utility.System_Type(C, K);
        switch (choose) {
            case (1):
                MM1 result1 = new MM1(lambda, mu, C, K);
                TextField_L.setText(String.valueOf(result1.getL()));
                TextField_Lq.setText(String.valueOf(result1.getLq()));
                TextField_W.setText(String.valueOf(result1.getW()));
                TextField_Wq.setText(String.valueOf(result1.getWq()));
                Type.setText("  MM1");
                break;
            case (2):
                MM1K result2 = new MM1K(lambda, mu, C, K);
                TextField_L.setText(String.valueOf(result2.getL()));
                TextField_Lq.setText(String.valueOf(result2.getLq()));
                TextField_W.setText(String.valueOf(result2.getW()));
                TextField_Wq.setText(String.valueOf(result2.getWq()));
                Type.setText("  MM1K");
                break;
            case (3):
                MMC result3 = new MMC(lambda, mu, C, K);
                TextField_L.setText(String.valueOf(result3.getL()));
                TextField_Lq.setText(String.valueOf(result3.getLq()));
                TextField_W.setText(String.valueOf(result3.getW()));
                TextField_Wq.setText(String.valueOf(result3.getWq()));
                Type.setText("  MMC");
                break;
            case (4):
                MMCK result4 = new MMCK(lambda, mu, C, K);
                TextField_L.setText(String.valueOf(result4.getL()));
                TextField_Lq.setText(String.valueOf(result4.getLq()));
                TextField_W.setText(String.valueOf(result4.getW()));
                TextField_Wq.setText(String.valueOf(result4.getWq()));
                Type.setText("  MMCK");
                break;
            case (5):
                TextField_L.setText("Error");
                TextField_Lq.setText("Error");
                TextField_W.setText("Error");
                TextField_Wq.setText("Error");
                Type.setText(" NOT_Found");
        }

    }

    private void Button_CalculateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_CalculateActionPerformed
        boolean isNumbers = Utility.checkNumbersOrNot(TextField_lambda.getText());
        isNumbers &= Utility.checkNumbersOrNot(TextField_MU.getText());
        isNumbers &= Utility.checkNumbersOrNot(TextField_C.getText());
        isNumbers &= Utility.checkNumbersOrNot(TextField_K.getText());
        isNumbers &= Utility.checkNumbersOrNot(TextFiled_SumulationTime.getText());

        if (!isNumbers)
            JOptionPane.showMessageDialog(rootPane, "Invalid Inputs, insert only numbers.");
        else
            calculate();

    }//GEN-LAST:event_Button_CalculateActionPerformed

    private void Button_ClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_ClearActionPerformed
        TextField_lambda.setText("Enter Lambda Value");
        TextField_lambda.setForeground(new Color(153, 153, 153));
        TextField_MU.setText("Enter MU Value");
        TextField_MU.setForeground(new Color(153, 153, 153));
        TextField_C.setText("Enter  C  Value");
        TextField_C.setForeground(new Color(153, 153, 153));
        TextField_K.setText("Enter K  Value");
        TextField_K.setForeground(new Color(153, 153, 153));
        TextFiled_SumulationTime.setText("Enter T Value");
        TextFiled_SumulationTime.setForeground(new Color(153, 153, 153));
    }//GEN-LAST:event_Button_ClearActionPerformed

    private void TextField_lambdaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TextField_lambdaFocusGained
        if (TextField_lambda.getText().equals("Enter Lambda Value")) {
            TextField_lambda.setText("");
            TextField_lambda.setForeground(new Color(0, 0, 0));
        }
    }//GEN-LAST:event_TextField_lambdaFocusGained

    private void TextField_lambdaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TextField_lambdaFocusLost
        if (TextField_lambda.getText().equals("")) {
            TextField_lambda.setText("Enter Lambda Value");
            TextField_lambda.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_TextField_lambdaFocusLost

    private void TextField_MUFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TextField_MUFocusGained
        if (TextField_MU.getText().equals("Enter MU Value")) {
            TextField_MU.setText("");
            TextField_MU.setForeground(new Color(0, 0, 0));
        }
    }//GEN-LAST:event_TextField_MUFocusGained

    private void TextField_MUFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TextField_MUFocusLost
        if (TextField_MU.getText().equals("")) {
            TextField_MU.setText("Enter MU Value");
            TextField_MU.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_TextField_MUFocusLost

    private void TextField_CFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TextField_CFocusGained
        if (TextField_C.getText().equals("Enter  C  Value")) {
            TextField_C.setText("");
            TextField_C.setForeground(new Color(0, 0, 0));
        }
    }//GEN-LAST:event_TextField_CFocusGained

    private void TextField_CFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TextField_CFocusLost
        if (TextField_C.getText().equals("")) {
            TextField_C.setText("Enter  C  Value");
            TextField_C.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_TextField_CFocusLost

    private void TextField_KFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TextField_KFocusGained
        if (TextField_K.getText().equals("Enter K  Value")) {
            TextField_K.setText("");
            TextField_K.setForeground(new Color(0, 0, 0));
        }
    }//GEN-LAST:event_TextField_KFocusGained

    private void TextField_KFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TextField_KFocusLost
        if (TextField_K.getText().equals("")) {
            TextField_K.setText("Enter K  Value");
            TextField_K.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_TextField_KFocusLost

    private void SimulateActionPerformed(java.awt.event.ActionEvent evt) {
//        1 mm1
//        2 mm1k
//        3 mmc
//        4 mmck
        boolean isNumbers = Utility.checkNumbersOrNot(TextField_lambda.getText());
        isNumbers &= Utility.checkNumbersOrNot(TextField_MU.getText());
        isNumbers &= Utility.checkNumbersOrNot(TextField_C.getText());
        isNumbers &= Utility.checkNumbersOrNot(TextField_K.getText());
        isNumbers &= Utility.checkNumbersOrNot(TextFiled_SumulationTime.getText());

        if (!isNumbers)
            JOptionPane.showMessageDialog(rootPane, "Invalid Inputs, insert only numbers.");
        else {
            calculate();

            double lambda = Double.valueOf(TextField_lambda.getText());
            double mu = Double.valueOf(TextField_MU.getText());
            int C = Integer.valueOf(TextField_C.getText());
            int K = Integer.valueOf(TextField_K.getText());
            int typ = Utility.System_Type(C, K);
            int sim_time = Integer.valueOf(TextFiled_SumulationTime.getText());
            if (typ == 1) {
                MM1Simulation sim = new MM1Simulation(lambda, mu, sim_time);
                sim.Simulate();
            } else if (typ == 2) {
                MM1KSimulation sim = new MM1KSimulation(lambda, mu, sim_time, K);
                sim.Simulate();
            } else if (typ == 3) {
                MMCSimulation sim = new MMCSimulation(lambda, mu, C, sim_time);
                sim.Simulate();
            } else if (typ == 4) {
                MMCKSimulation sim = new MMCKSimulation(lambda, mu, C, K, sim_time);
                sim.Simulate();
            } else {
                TextField_L.setText("Error, The System is not defined");
                TextField_Lq.setText("Error, The System is not defined");
                TextField_W.setText("Error, The System is not defined");
                TextField_Wq.setText("Error, The System is not defined");
            }
        }
    }

    private void TextFiled_SumulationTimeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TextFiled_SumulationTimeFocusGained
        if (TextFiled_SumulationTime.getText().equals("Enter T Value")) {
            TextFiled_SumulationTime.setText("");
            TextFiled_SumulationTime.setForeground(new Color(0, 0, 0));
        }
    }//GEN-LAST:event_TextFiled_SumulationTimeFocusGained

    private void TextFiled_SumulationTimeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TextFiled_SumulationTimeFocusLost
        if (TextFiled_SumulationTime.getText().equals("")) {
            TextFiled_SumulationTime.setText("Enter T Value");
            TextFiled_SumulationTime.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_TextFiled_SumulationTimeFocusLost

    private void TextFiled_SumulationTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFiled_SumulationTimeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFiled_SumulationTimeActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_Calculate;
    private javax.swing.JButton Button_Clear;
    private javax.swing.JLabel C;
    private javax.swing.JPanel Input;
    private javax.swing.JLabel K;
    private javax.swing.JLabel L;
    private javax.swing.JLabel Lq;
    private javax.swing.JLabel MU;
    private javax.swing.JPanel Output;
    private javax.swing.JButton Simulate;
    private javax.swing.JLabel SumulationTime;
    private javax.swing.JTextField TextField_C;
    private javax.swing.JTextField TextField_K;
    private javax.swing.JTextField TextField_L;
    private javax.swing.JTextField TextField_Lq;
    private javax.swing.JTextField TextField_MU;
    private javax.swing.JTextField TextField_W;
    private javax.swing.JTextField TextField_Wq;
    private javax.swing.JTextField TextField_lambda;
    private javax.swing.JTextField TextFiled_SumulationTime;
    private javax.swing.JTextField Type;
    private javax.swing.JLabel W;
    private javax.swing.JLabel Wq;
    private javax.swing.JLabel lambda;
    // End of variables declaration//GEN-END:variables
}
