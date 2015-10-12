package problems.data_structures;

import java.util.ArrayList;

public class GraphNode {

	private int value = 0;
	private static int id = 0;
	private static int idCounter = 0;
	protected ArrayList<GraphNode> neighborNodes = new ArrayList<GraphNode>();
	
	public GraphNode(){
		id = idCounter;
		idCounter++;
	}

	public GraphNode(int value){
		setValue(value);
		
		id = idCounter;
		idCounter++;
	}
	
	public void setValue(int value){
		this.value = value;
	}
	
	public int getValue(){
		return value;
	}
	
	public int getID(){
		return id;
	}
	
	public void addNeighbor(GraphNode node){
		neighborNodes.add(node);
		node.getNeighbors().add(this);
	}
	
	public ArrayList<GraphNode> getNeighbors(){
		return neighborNodes;
	}
	
	public boolean hasNeighbor(GraphNode node){
		for(int i = 0; i < neighborNodes.size(); i++){
			if(node.equals(neighborNodes.get(i)))
				return true;
		}
		
		return false;
	}
	
	public boolean equals(GraphNode node){
		if(this.getValue() == node.getValue() &&
		   this.getID() == node.getID()){
			return true;
		}
		
		return false;
	}
}
