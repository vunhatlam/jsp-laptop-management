/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
/**
 *
 * @author kami
 */
public class Producer implements Serializable{
    private int idProducer;
    private String name;
    private float rate;

    public Producer() {
    }

    public Producer(int idProducer, String name, float rate) {
        this.idProducer = idProducer;
        this.name = name;
        this.rate = rate;
    }

    public Producer(String name, float rate) {
        this.name = name;
        this.rate = rate;
    }

    public int getIdProducer() {
        return idProducer;
    }

    public void setIdProducer(int idProducer) {
        this.idProducer = idProducer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "Producer{" + "idProducer=" + idProducer + ", name=" + name + ", rate=" + rate + '}';
    }
    
}
