/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loan_and_refund;

import javax.swing.JOptionPane;

/**
 *
 * @author MJ
 */
public class PaymentTesting {
    public static void main (String agrs []) {
            double payamt = 83800.99, paybal = 84000, payloan = 500000;
            double expectedBal = 0, recommendPayment = 0, minPayment = 0;
            expectedBal = paybal - payamt; // expBal is lessthan MinimumPayment
            
            int duration = 2;
            if (duration == 1 ) { // week == 1
                minPayment = payloan / 26; //26weeks
                recommendPayment = paybal - minPayment - 1; //suggestPayment
            } else if (duration == 2 ) { // monthly == 2
                minPayment = payloan / 6; //6months  String minPay = String.format("%.2f", minpay);
                recommendPayment = paybal - minPayment - 1; //suggestPayment
            }
            System.out.println("amountPaying N"+payamt+" --- minPay = N"+minPayment+" --- pendingBal = N"
                    +paybal+" --- expBal = N"+expectedBal);
            //amountPaying is lessthan minPayment
            if (payamt < minPayment) {
                System.out.println("Your minimum payment allowed is: N"+(String.format("%.2f",minPayment)));
            }
            //amountPaying is greaterthan outstandingBal
            else if (payamt > paybal) {
                System.out.println("Your maximum payment allowed is: N"+(String.format("%.2f",paybal)));
            }
            // expectedBal is lessthan minPayment => recommend
            else if (expectedBal > 0) { //TODO: check this as issue can rise when min == max
                System.out.println("You can ONLY pay N"+(String.format("%.2f",paybal))+" at the moment.");
                System.out.println(expectedBal +" --- "+ 0);
            }
            else {
                System.out.println("Enable PaymentGateWay => Amount is: N"+payamt);
            }
    }
    
    public double cal(double loan, double amount, double balance) {
        double payNow = 0;
        return payNow;
    }
}
