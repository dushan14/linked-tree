package com.company;

/***
 * a class to keep details of an option to a segment
 */
public class SegmentOption {

    private String segmentName;
    private String option;
    private float costForOption;
    private float stateAfterApplyingOption;

    public SegmentOption(String segmenetName, String option, float costForOption, float stateAfterApplyingOption) {
        this.segmentName = segmenetName;
        this.option = option;
        this.costForOption = costForOption;
        this.stateAfterApplyingOption = stateAfterApplyingOption;
    }

    public String getSegmentName() {
        return segmentName;
    }

    public String getOption() {
        return option;
    }

    public float getCostForOption() {
        return costForOption;
    }

    public float getStateAfterApplyingOption() {
        return stateAfterApplyingOption;
    }
}
