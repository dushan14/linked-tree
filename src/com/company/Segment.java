package com.company;

import java.util.ArrayList;

/***
 * a class to keep possible options list for a road segment
 */
public class Segment {

    private String name;
    private int priority;
    private ArrayList<SegmentOption> possibleOptions;

    public Segment(String name, int priority, ArrayList<SegmentOption> possibleOptions) {
        this.name = name;
        this.priority = priority;
        this.possibleOptions = possibleOptions;
    }

    public String getName() {
        return name;
    }

    public int getPriority() {
        return priority;
    }

    public ArrayList<SegmentOption> getPossibleOptions() {
        return possibleOptions;
    }
}
