/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.tester;

import java.util.LinkedList;

/**
 *
 * @author CFONe
 */
public class graph<E> {
    static class Synapse{
        int source, destination, distance, time;

        public Synapse(int source, int destination, int distance, int time) {
            this.source = source;
            this.destination = destination;
            this.distance = distance;
            this.time = time;
        }
        
        
    }
    
    static class Neuron{
        int neurons;
        LinkedList<Synapse> [] adjancylist;

        public Neuron(int neurons) {
            this.neurons = neurons;
            adjancylist = new LinkedList[neurons];
            for(int i = 0; i< neurons; i++){
                adjancylist[i] = new LinkedList<>();
            }
        }
        
        public void addSynapse(int a, int b, int distance, int time){
            Synapse synapse = new Synapse(a,b,distance,time);
            adjancylist[a].addFirst(synapse);
            
            synapse = new Synapse(b, a, distance, time);
             adjancylist[b].addFirst(synapse);
        }
        
       public void mindistance(int sourceNeuron){
           boolean [] path = new boolean[neurons];
           int [] distance = new int [neurons];
           int [] time = new int [neurons];
           
           for (int i = 0; i <neurons ; i++) {
                distance[i] = Integer.MAX_VALUE;
                time[i] = Integer.MAX_VALUE;
}
           
         
       } 
    }
    
}
