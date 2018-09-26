package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Segment> segmentsWithPossibleOptions = new ArrayList<>();
        // fill this list with required data


        float fullBudget = 1000;
        // add required budget here

        TreeGenerator treeGenerator = new TreeGenerator();


        ArrayList<Node> bottomLayerNodes = treeGenerator.generateTree(segmentsWithPossibleOptions, fullBudget);


        ArrayList<Node> bestValuedStateNodes = treeGenerator.getBestValuedStateNodes(bottomLayerNodes);

        // use "treeGenerator.getDidNothingNodes()" to get did nothing nodes in a selected node

    }
}
