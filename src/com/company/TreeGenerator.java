package com.company;

import java.util.ArrayList;
import java.util.HashMap;

public class TreeGenerator {

    private Node firstParent;

    public Node getFirstParent(){
        return firstParent;
    }


    /**
     * run this to generate node tree and to get bottom level nodes
     *
     * @param segmentsWithPossibleOptions should be sorted according to segment priority
     * @param fullBudget budget allocated
     * @return bottom level nodes
     */
    public ArrayList<Node> generateTree(ArrayList<Segment> segmentsWithPossibleOptions,float fullBudget){

        firstParent=Node.getFirstParent(fullBudget);

        ArrayList<Node> tempAboveLayerNodes=new ArrayList<>();
        tempAboveLayerNodes.add(firstParent);

        //loop for road segments
        for (Segment segment:segmentsWithPossibleOptions){

            ArrayList<Node> nextLevelAboveLayerNodes=new ArrayList<>();

            // loop for each parent in decision tree's previous above layer
            for (Node parent:tempAboveLayerNodes){

                // loop for available options for that segment
                for (SegmentOption optionForSegment:segment.getPossibleOptions()){

                    Node childNode = new Node(parent, optionForSegment);
                    nextLevelAboveLayerNodes.add(childNode);

                }

            }

            tempAboveLayerNodes=nextLevelAboveLayerNodes;

        }

        return tempAboveLayerNodes;

    }


    /**
     *
     * @param node bottom level node which needs to find ancestors
     * @param nodeFlow start with an empty array
     * @return bottom to top nodes till first parent
     */
    public ArrayList<Node> getNodeFlowAsArray(Node node,ArrayList<Node> nodeFlow){

        if (node.isFirstParent()){
            return nodeFlow;
        }
        nodeFlow.add(node);

        return getNodeFlowAsArray(node.getParent(),nodeFlow);

    }

    /**
     *
     * @param bottomNode node which needs to find didNothing ancestors
     * @return segments with node which did nothing
     */
    public HashMap<String,Node> getDidNothingNodes(Node bottomNode){

        HashMap<String,Node> didNothingNodes=new HashMap<>();
        ArrayList<Node> nodeFlowAsArray = getNodeFlowAsArray(bottomNode, new ArrayList<>());
        for (Node node:nodeFlowAsArray){
            if (node.isDidNothing()){
                didNothingNodes.put(node.getRoadSegment(),node);
            }
        }

        return didNothingNodes;

    }


    /**
     *
     * @param bottomLayerNodes nodes returned from generateTree
     * @return array of best valued nodes(multiple if there are several nodes has the same best value)
     */
    public ArrayList<Node> getBestValuedStateNodes(ArrayList<Node> bottomLayerNodes){
        if (bottomLayerNodes.size()>0) {

            ArrayList<Node> bestBottomNodes = new ArrayList<>();
            bestBottomNodes.add(bottomLayerNodes.get(0));

            for (Node node: bottomLayerNodes){
                if (node.getTotalStatusToPoint()==bestBottomNodes.get(0).getTotalStatusToPoint()){
                    bestBottomNodes.add(node);
                }
                else if (node.getTotalStatusToPoint()<bestBottomNodes.get(0).getTotalStatusToPoint()){
                    bestBottomNodes.clear();
                    bestBottomNodes.add(node);
                }
            }
            return bestBottomNodes;

        }
        return null;
    }
}
