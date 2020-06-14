package com.ahanmalli;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        JFrame frame = new JFrame("COVID-19 Data");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000,1000);

        boolean trigger = true;

        while (trigger == true) {
            JLabel textLabel = new JLabel("Please mention whether you would like a specific data point (PRESS 1) or the entire dataset (PRESS 2).");
            int input = sc.nextInt();


            if (input == 1) {
                specificData();
                System.out.println("If you would like to see another data point, press 1.  If you would like to quit, press 2.");
                int num = sc.nextInt();
                if (num == 1) {
                    trigger = true;
                } else if (num == 2) {
                    trigger = false;
                }

            } else if (input == 2) {
                pureData();
                System.out.println("If you would like to see another data point, press 1.  If you would like to quit, press 2.");
                int num = sc.nextInt();
                if (num == 1) {
                    trigger = true;
                } else if (num == 2) {
                    trigger = false;
                }
            } else {
            }
        }
    }

    public static void specificData() {
        Scanner sc = new Scanner(System.in);
        int sample = 1000;
        System.out.println("Sample Size = 1000 people");
        System.out.println("Please type in the error rate which you would like the data for.  Type the value in decimal form.");
        double chanceOfFailure = sc.nextDouble();
        System.out.println("Please type in the prevelance rate which you would like data for.  Type the value in decimal form.");
        double prevelance = sc.nextDouble() * 100;

        double ratio = ((((prevelance / 100d) * sample) * (1d - chanceOfFailure)) / ((((1d - (prevelance / 100d)) * sample) * (chanceOfFailure)) + (((prevelance / 100d) * sample) * (1d - chanceOfFailure)))) * 100;
        System.out.println(/*prevelance + "     " +*/ ratio);
    }

    public static void pureData() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input the error rate which you would like to inspect.");
        int sample = 1000;
        double chanceOfFailure = sc.nextDouble();

        for (int prevelance = 1; prevelance <= 99; prevelance++) {
            double ratio = ((((prevelance / 100d) * sample) * (1d - chanceOfFailure)) / ((((1d - (prevelance / 100d)) * sample) * (chanceOfFailure)) + (((prevelance / 100d) * sample) * (1d - chanceOfFailure)))) * 100;
            System.out.println(prevelance + "     " + ratio);
        }
    }
}