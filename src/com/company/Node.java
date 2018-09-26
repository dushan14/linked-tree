package com.company;

import java.util.ArrayList;

public class Node {

    private Node parent;
    private int depth;
    private ArrayList<Node> children;

    private String roadSegment;

    private float budgetRemain;
    private float totalStatusToPoint;

    private String optionApplied;
    private float stateForSegment;
    private float costForSegment;

    private boolean didNothing;
    private boolean firstParent;


    private Node(){

    }

    public Node(Node parent,SegmentOption so) {
        this.parent = parent;

        this.roadSegment=so.getSegmentName();

        this.budgetRemain=this.parent.budgetRemain-this.costForSegment;

        if (budgetRemain<0){
            this.didNothing=true;
            this.budgetRemain=this.parent.budgetRemain;
            this.optionApplied="";
            this.costForSegment=0;
            this.totalStatusToPoint = this.parent.totalStatusToPoint;

        }else {

            this.optionApplied = so.getOption();
            this.costForSegment = so.getCostForOption();
            this.stateForSegment = so.getStateAfterApplyingOption();

            this.totalStatusToPoint = this.parent.totalStatusToPoint + this.stateForSegment;
        }

        this.depth=parent.depth+1;
        this.parent.children.add(this);

    }


    public static Node getFirstParent(float fullBudget){
        Node node=new Node();
        node.firstParent=true;
        node.depth=0;
        node.budgetRemain=fullBudget;
        node.totalStatusToPoint=0;

        return node;

    }

    public Node getParent() {
        return parent;
    }

    public int getDepth(){
        return depth;
    }

    public ArrayList<Node> getChildren() {
        return children;
    }

    public String getRoadSegment() {
        return roadSegment;
    }

    public float getBudgetRemain() {
        return budgetRemain;
    }

    public float getTotalStatusToPoint() {
        return totalStatusToPoint;
    }

    public String getOptionApplied() {
        return optionApplied;
    }

    public float getStateForSegment() {
        return stateForSegment;
    }

    public float getCostForSegment() {
        return costForSegment;
    }

    public boolean isDidNothing() {
        return didNothing;
    }

    public boolean isFirstParent() {
        return firstParent;
    }

    public void setFirstParent(boolean firstParent) {
        this.firstParent = firstParent;
    }
}
