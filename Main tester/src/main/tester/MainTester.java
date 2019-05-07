/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.tester;
import java.util.Scanner;

public class MainTester {

    public static void main(String[] args) {
        Scanner UserInput = new Scanner(System.in);
        System.out.println("Welcome to Sheldon's Amazing Human Brain Visualizer!");
        System.out.print("How many neurons are in the network? : ");
        int NumOfNeurons = UserInput.nextInt();
        Neuron a = new Neuron(NumOfNeurons); //creates a LinkedList to store all the neurons

        //loop for each neuron, to collect its ID & num of edges
        //possible to eliminate inserting for the last neuron? since the details for the last neuron is not required
        for (int count1 = 0; count1 < NumOfNeurons; count1++) {
            System.out.print("Please insert the neuron ID, and its number of edges : ");
            int neuronID = UserInput.nextInt();
            int NumOfEdge = UserInput.nextInt();

            //loop for each edge of the neuron, to collect the destination, distance and time
            //but this still loops for repeated neurons (i.e. you input for neuron 0 to 1 and 1 to 0)
            //try to eliminate repetition?
            for (int count2 = 0; count2 < NumOfEdge; count2++) {
                System.out.print("Please insert the ID of connected neuron, distance of edge & time to pass through : ");
                int connectedID = UserInput.nextInt();
                int edgeDist = UserInput.nextInt();
                int time = UserInput.nextInt();
                a.addSynapse(neuronID, connectedID, edgeDist, time);
            }
        }

        System.out.print("How many messages are you transmitting? : ");
        int NumOfMessages = UserInput.nextInt();

        for (int count3 = 0; count3 < NumOfMessages; count3++) {
            System.out.print("Please insert the ID of the Source neuron and Destination neuron : ");
            //to be changed : 
            int sourceID = UserInput.nextInt();
            int destinationID = UserInput.nextInt();
        }
    }

}
