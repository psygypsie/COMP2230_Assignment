/**
 * *
 *  * assign1.java – Assignment1
 *   * @author: Jeremiah Smith, Juyong Kim
 *    * @student Number: c3238179 c3244203
 *     * @version: 016/10/2018
 *      * Description: Parses XML file and saves data as Station objects and associated StationEdge objects
 *       */
import java.io.File;
import java.util.*;

import java.util.List;
import java.util.ArrayList;

import org.w3c.dom.Node;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder; 
import javax.xml.parsers.DocumentBuilderFactory;

// TODO THE RAIL NETWORK SHOULD BE PASSED TO YOUR PROGRAM AS AN INPUT
// BUGS: using testNetwork, output is currently incorrect when going from Station "Five" to Station "One"
// Q1
// Q2 (extra)

// EXAMPLE USE OF PROGRAM:
// java assign1 RailNetwork.XML X Y optimisationCriteria
// where X and Y are the names of two stations and optimisationCriteria is the additional criteria that the algorithm must be optomised for

// main class
public class assign1
{
	private int one;
	public static void main(String args[]) throws Exception
	{
		// String RailNetwork = args[0];	// the XML file will be given as a command line argument and savede to this variable
		// String stationOne args[1];		// commented out for now while we do manual testing
		// String stationTwo args[2];
		// String optimisationCriteria args[3];
		//
		// XML FILE PARSING BEGIN
		String RailNetwork = "TestNetwork.xml";	// "RailNetwork.xml"
		File file = new File(RailNetwork);	// this will be changed so that the rail network is passed to program as an input
		// File file = new File(RailNetwork);		// done as above, commented out for easier testing
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory         // instantiates an instance of this library for parsing
			.newInstance();
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
		Document document = documentBuilder.parse(file);                               // this is the important part, 'document' is our XML file

		NodeList stationList = document.getElementsByTagName("Station");               // splits document into nodes by Station tag

		NodeList stationNodes = document.getElementsByTagName("Station");              // splits stations into nodes for each tag
		List<Station> stations = new ArrayList<Station>();                                 // this will hold all of our Station objects
		for (int i = 0; i < stationNodes.getLength(); i++)                             // we parse the file and create Station objects within this loop
		{
			NodeList stationAttributes = stationNodes.item(i).getChildNodes();     // splits this stationNode into its child elements
			String Name = stationAttributes.item(1).getTextContent();              // station Name recorded
			String Line = stationAttributes.item(3).getTextContent();              // station Line recorded
			NodeList stationEdges = stationAttributes.item(5).getChildNodes();     // edges element split into child nodes for each edge

			stations.add(new Station(Name, Line, stationEdges, i));                       // recorded data is sent to the Station constructor
		}

		for (int i = 0; i < stationNodes.getLength(); i++)                             // we parse the file and create Station objects within this loop
		{
			stations.get(i).initializeEdges(stations);
		}

		// printData(stations);

		Graph graph = new Graph(stations);

		DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(graph);

		String result = dijkstra.getMinPath("Zero", "Five", "changes");

//NEW CHANGE HERE
//		//using for testing purposes
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("Please enter the criteria: ");
//		String crit = scanner.nextLine();
//		System.out.println("Please enter the first station: ");
//		String stat1 = scanner.nextLine();
//		System.out.println("Please enter the second station: ");
//		String stat2 = scanner.nextLine();
//		String result = dijkstra.getMinPath(stat1, stat2, crit);

<<<<<<< HEAD
=======
		String result = dijkstra.getMinPath("Bondi Junction", "Clyde", "time");
>>>>>>> bcfd4f831f4d5140466c3e3f7c8ab91c9e8d6249
		if (result != "")
			System.out.println(result);
		else
			System.out.println("There is no path");

		    // graph.dijkstra_GetMinDistances(sourceVertex);

		// TODO - calculate best route using graph and bestRoute()
		// program calculates and returns information about the bestRoute(stationOne, stationTwo, optimisationCriteria)
		// using the two stations provided as command line arguments

//		DijkstraAlgorithm dij = new DijkstraAlgorithm(graph, station1, station2);
	}
	// RULES
	// algorithm uses average time for travelling between adjacent stations (duration)
	// and a flat time of 15 minutes to change from one line to another


//	public static void printData(List<Station> stations)
//	{
//		for (int i = 0; i < stations.size(); i++)
//		{
//			System.out.println("Station Name: " +stations.get(i).getName());
//			System.out.println("Line: "+stations.get(i).getLine());
//			for (int a = 0; a < stations.get(i).getEdges().size(); a++)
//			{
//				System.out.println("	Edge:");
//				System.out.println("		Name: "+stations.get(i).getEdges().get(a).getName());
//				System.out.println("		Line: "+stations.get(i).getEdges().get(a).getLine());
//				System.out.println("		Duration: "+stations.get(i).getEdges().get(a).getDuration());
//				System.out.println("		Source: "+stations.get(i).getEdges().get(a).getSource().getName());
//				System.out.println("		Destination: "+stations.get(i).getEdges().get(a).getDestination().getName());
//			}
//		}
//	}
}
