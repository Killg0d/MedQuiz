/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.questionaire;

/**
 *
 * @author Tarun
 */
public class Question {

    private String question;
    private String opa;
    private String opb;
    private String opc;
    private int cop;

    // Constructors
    public Question() {
    }

    public Question(String question, String opa, String opb, String opc, int cop) {
        this.question = question;
        this.opa = opa;
        this.opb = opb;
        this.opc = opc;
        this.cop = cop;
    }

    // Getters and setters
    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOpa() {
        return opa;
    }

    public void setOpa(String opa) {
        this.opa = opa;
    }

    public String getOpb() {
        return opb;
    }

    public void setOpb(String opb) {
        this.opb = opb;
    }

    public String getOpc() {
        return opc;
    }

    public void setOpc(String opc) {
        this.opc = opc;
    }

    public int getCop() {
        return cop;
    }

    public void setCop(int cop) {
        this.cop = cop;
    }

    @Override
    public String toString() {
        return "Question: " + question + ", Option A: " + opa + ", Option B: " + opb + ", Option C: " + opc + ", Correct Option: " + cop+"\n";
    }

}
