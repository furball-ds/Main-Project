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
public class Neuron {
     int neurons;
        LinkedList<graph.Synapse> [] adjancylist;

        public Neuron(int neurons) {
            this.neurons = neurons;
            adjancylist = new LinkedList[neurons];
            for(int i = 0; i< neurons; i++){
                adjancylist[i] = new LinkedList<>();
            }
        }
        
        public void addSynapse(int a, int b, int distance, int time){
            graph.Synapse synapse = new graph.Synapse(a,b,distance,time);
            adjancylist[a].addFirst(synapse);
            
            synapse = new graph.Synapse(b, a, distance, time);
             adjancylist[b].addFirst(synapse);
        }

    @Override
    public String toString() {
        
        return "Neuron{" + "neurons=" + neurons + ", adjancylist=" + adjancylist + '}';
        
    }
}
