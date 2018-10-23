/**
 * *
 *  * assign1.java – Assignment1
 *   * @author: Jeremiah Smith, Juyong Kim
 *    * @student Number: c3238179 c3244203
 *     * @version: 016/10/2018
 *      * Description: node used in the minHeap
 *       */
public class HeapNode
{
	private boolean visited;
	private String path;

	private Station vertex;
	private int time = Integer.MAX_VALUE;		// very unstable, needs to be properly set with a constructor in the MinHeap class
	//constructor
	public HeapNode()
	{
		this.vertex = new Station();
		this.time = Integer.MAX_VALUE;
	}
	public HeapNode(Station vertex, int time)
	{
		this.vertex = vertex;
		this.time = Integer.MAX_VALUE;
		path = "";
		visited = false;
	}

	//setters
	public void setVertex(Station vertex)
	{
		this.vertex = vertex;
	}
	public void setWeight(int time)
	{
		this.time = time;
	}
	//getters
	public Station getVertex()
	{
		return vertex;
	}
	public int getComparator()
	{
		return time;
	}

	public String getPath()
	{
		return path;
	}

	public void updatePath(String prePath, StationEdge edge, HeapNode node)
	{

		if (visited == true)
			path = "";		// path reset for update when old path has become redundant due to a newer and quicker route
		if (prePath.equals(""))		// first line
			path += ", take line " + edge.getLine() + " to station " + edge.getDestination().getName() + ";\n";
		else if (edge.getSource().getName().equals(edge.getDestination().getName()))// changing lines
			path += prePath + " then change to line " + edge.getDestination().getLine() + ", and continue to " + edge.getDestination().getName() + ";\n";
		else
			path += prePath + "stay on line " + edge.getSource().getLine() + ", and continue to " + edge.getDestination().getName() + ";\n";
		visited = true;
	}
}
