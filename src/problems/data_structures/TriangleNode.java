package problems.data_structures;

public class TriangleNode extends GraphNode {

	private int largestSum = 0;
	private TriangleNode largestSumParent = null; 
	private int level = 0;
	
	public TriangleNode(int value){
		super(value);
		this.setSum(value);
	}
	
	public TriangleNode(int value, int level){
		super(value);
		this.level = level;
		this.setSum(value);
	}
	
	public void addNeighbor(TriangleNode node){
		if(node.getParent() == null){
			node.setParent(this);
			node.setSum(node.getValue() + this.getSum());
		}
		else if(node.getParent().getSum() < this.getSum()){
			node.setParent(this);
			node.setSum(node.getValue() + this.getSum());
		}
		neighborNodes.add(node);
	}
	
	public void setSum(int sum){
		this.largestSum = sum;
	}
	
	public int getSum(){
		return largestSum;
	}
	
	public void setParent(TriangleNode parent){
		this.largestSumParent = parent;
	}
	
	public TriangleNode getParent(){
		return largestSumParent;
	}
}
