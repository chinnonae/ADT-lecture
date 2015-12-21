import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.Locale;
import java.util.Scanner;

public class Graph {
	private final int V;
	private int E;
	private SList<Integer>[] adj;

	/**
	 * Initializes an empty graph with V vertices and 0 edges.
	 * param V the number of vertices
	 */
	public Graph(int V) {
		this.V = V;
		this.E = 0;
		adj = (SList<Integer>[])Array.newInstance(SList.class, V);

	}

	/**  
	 * Initializes a graph by reading data from a file
	 * The file format is the number of vertices V,
	 * followed by the number of edges E,
	 * followed by E pairs of vertices, with each entry separated by whitespace.
	 */
	public Graph(Scanner in) {
		this.V = in.nextInt();
		int a = in.nextInt();
		adj = (SList<Integer>[]) Array.newInstance(SList.class, this.V);
		while(in.hasNextInt()){
			int v = in.nextInt();
			int w = in.nextInt();
			try{
				validateVertex(v);
				validateVertex(w);
			}catch(Exception E){

			}
			if(adj[v]==null) adj[v] = new SList<Integer>();
			if(adj[w]==null) adj[w] = new SList<Integer>();
			addEdge(v,w);
		}
		this.E = a;
	}

	/**
	 * Initializes a new graph that is a deep copy of G.
	 */
	public Graph(Graph G) {
		this.V = G.V();
		this.E = G.E();
		this.adj = (SList<Integer>[]) Array.newInstance(SList.class, this.V);
		for(int i = 0; i < V; i++){
			Iterator temp = G.adj(i).iterator();
			adj[i] = new SList<Integer>();
			while(temp.hasNext()){
				adj[i].add((Integer) temp.next());
			}
		}
	}

	/**
	 * Returns the number of vertices in the graph.
	 */
	public int V() {
		return this.V;
	}

	/**
	 * Returns the number of edges in the graph.
	 */
	public int E() {
		return this.E;
	}

	// throw an IndexOutOfBoundsException unless 0 <= v < V
	private void validateVertex(int v) {
		if(v >= V || v < 0) throw new IndexOutOfBoundsException();
	}

	/**
	 * Adds the undirected edge v-w to the graph.
	 */
	public void addEdge(int v, int w) {
		validateVertex(v);
		validateVertex(w);
		adj[v].add(w);
		adj[w].add(v);
		this.E += 1;
	}


	/**
	 * Returns the vertices adjacent to vertex v.
	 */
	public Iterable<Integer> adj(int v) {
		return adj[v];
	}

	/**
	 * Returns the degree of vertex v.
	 */
	public int degree(int v) {
		return adj[v].size();
	}

	/**
	 * Returns a string representation of the graph.
	 */
	public String toString() {
		StringBuilder s = new StringBuilder();
		String NEWLINE = System.getProperty("line.separator");
		s.append(V + " vertices, " + E + " edges " + NEWLINE);
		for (int v = 0; v < V; v++) {
			s.append(v + ": ");
			for (int w : adj[v]) {
				s.append(w + " ");
			}
			s.append(NEWLINE);
		}
		return s.toString();
	}

	public static void main(String[] args) {
		Scanner scanner;
		String CHARSET_NAME = "UTF-8";
		Locale LOCALE = Locale.US;
		File file = new File(args[0]);
		Graph G = null;
		try {
			scanner = new Scanner(file, CHARSET_NAME);
			scanner.useLocale(LOCALE);
			G = new Graph(scanner);
		}
		catch (IOException ioe) {
			System.err.println("Could not open " + file);
		}
		System.out.println(G);
		System.out.println("Make a deep copy and show:");
		System.out.println();
		Graph G1 = new Graph(G);
		System.out.println(G1);
	}

}
