package org.example;

public class Notebook {
    private int diagonal;
    private String cpu;
    private String videoСard;
    private String ram;
    private String hdd;
    private String operatingSystem;
    private double prise;
    private char condition;


    public Notebook(int diagonal, String cpu, String videoСard, String ram, String hdd, String operatingSystem, double prise, char condition) {
        this.diagonal = diagonal;
        this.cpu = cpu;
        this.videoСard = videoСard;
        this.ram = ram;
        this.hdd = hdd;
        this.operatingSystem = operatingSystem;
        this.prise = prise;
        this.condition = condition;
    }
    public int getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(int diagonal) {
        this.diagonal = diagonal;
    }

    public String getCpu() {
        return cpu;
    }
    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getVideoСard() {
        return videoСard;
    }
    public void setVideoСard(String videoСard) {
        this.videoСard = videoСard;
    }

    public String getRam() {
        return ram;
    }
    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getHdd() {
        return hdd;
    }
    public void setHdd(String hdd) {
        this.hdd = hdd;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }
    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public double getPrise() {
        return prise;
    }
    public void setPrise(double prise) {
        this.prise = prise;
    }
    public char getCondition() {
        return condition;
    }
    public void setCondition(char condition) {
        this.condition = condition;
    }

    @Override
    public String toString() {

        return String.format(
                "%d %s %s %s %s %s %f %c",
                diagonal, cpu, videoСard, ram, hdd, operatingSystem, prise, condition);
    }

    public char changeCondition (char condition){
        if(condition == 'g'){
            condition = 'b';
            prise = prise - prise * 0.1;
        }else {
            condition = 'g';
            prise = prise + prise * 0.1;
        }
        return condition;
    }

    public double getDiscount (int discount){
        return prise - prise*(discount/100);
    }

    public double пуеPriceIncrease (int increase){
        return prise + prise*(increase/100);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Notebook that = (Notebook) o;

        if ( diagonal != that.diagonal) return false;
        if ( operatingSystem != that.operatingSystem) return false;
        if ( condition != that.condition) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = ram == null ? 0 : ram.hashCode();
        result = 31 * result + diagonal;

        return result;
    }

    public <T> Comparable getPrice() {
        return getPrice();
    }
}