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
public class Laptop implements Serializable{
    private int idLaptop;
    private int idProducer;
    private String producer;
    private String name;
    private String type;
    private int price;
    private float size;
    private String cpu;
    private int ram;

    public Laptop() {
    }

    public Laptop(int idLaptop, int idProducer, String producer, String name, String type, int price, float size, String cpu, int ram) {
        this.idLaptop = idLaptop;
        this.idProducer = idProducer;
        this.producer = producer;
        this.name = name;
        this.type = type;
        this.price = price;
        this.size = size;
        this.cpu = cpu;
        this.ram = ram;
    }

    public Laptop(int idProducer, String name, String type, int price, float size, String cpu, int ram) {
        this.idProducer = idProducer;
        this.name = name;
        this.type = type;
        this.price = price;
        this.size = size;
        this.cpu = cpu;
        this.ram = ram;
    }

    public Laptop(int idLaptop, String producer, String name, String type, int price, float size, String cpu, int ram) {
        this.idLaptop = idLaptop;
        this.producer = producer;
        this.name = name;
        this.type = type;
        this.price = price;
        this.size = size;
        this.cpu = cpu;
        this.ram = ram;
    }

    public Laptop(int idLaptop) {
        this.idLaptop = idLaptop;
    }

    public int getIdLaptop() {
        return idLaptop;
    }

    public void setIdLaptop(int idLaptop) {
        this.idLaptop = idLaptop;
    }

    public int getIdProducer() {
        return idProducer;
    }

    public void setIdProducer(int idProducer) {
        this.idProducer = idProducer;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    @Override
    public String toString() {
        return idLaptop + "\t" + idProducer + "\t" + name + "\t" + type + "\t" + price + "\t" + size +"\t" + cpu + "\t" + ram +"\n";
    }
    
}
