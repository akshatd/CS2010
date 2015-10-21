
// Copy paste this Java Template and save it as "Labor.java"
import java.util.*;
import java.io.*;

// write your matric number here: A0103516U
// write your name here: Akshat Dubey
// write list of collaborators here: Suranjana Sengupta
// year 2015 hash code: JESg5svjYpIsmHmIjabX (do NOT delete this line)

class Labor {
	private int V; // number of vertices in the graph (number of junctions in
					// Singapore map)
	private int Q; // number of queries
	private Vector<Vector<IntegerPair>> AdjList; // the weighted graph (the
													// Singapore map), the
													// length of each edge
													// (road) is stored here
													// too, as the weight of
													// edge

	// if needed, declare a private data structure here that
	// is accessible to all methods in this class
	// --------------------------------------------

	private boolean[] visited;
	private int distance;

	// --------------------------------------------

	public Labor() {
		// Write necessary code during construction
		//
		// write your answer here

	}

	void PreProcess() {
		// Write necessary code to preprocess the graph, if needed
		//
		// write your answer here
		// -------------------------------------------------------------------------
		
		
		
		// -------------------------------------------------------------------------
	}

	int Query(int s, int t, int k) {
		int ans = 0;

		// You have to report the shortest path from Steven and Grace's current
		// position s
		// to reach their chosen hospital t, output -1 if t is not reachable
		// from s
		// with one catch: this path cannot use more than k vertices
		//
		// PS: this query means different thing for the Subtask D (R-option)
		//
		// write your answer here
		visited = new boolean[V];
		distance = 0;
		if (DFS(s, t)) {
			ans = distance;
		}

		// -------------------------------------------------------------------------

		return ans;
	}

	// You can add extra function if needed
	// --------------------------------------------

	private boolean DFS(int source, int dest) {
		visited[source] = true;
		boolean foundHere = false;
		Vector<IntegerPair> nbrs = AdjList.get(source);
		for (int i = 0; i < nbrs.size(); i++) {
			int to = nbrs.get(i).first();
			int weight = nbrs.get(i).second();
			if (!visited[to]) {
				if (to == dest) {
					foundHere = true;
					distance += weight;
					break;
				} else {
					foundHere = DFS(to, dest);
					if (foundHere) {
						distance += weight;
						break;
					}
				}
			}
		}
		return foundHere;
	}

	// --------------------------------------------

	void run() throws Exception {
		// you can alter this method if you need to do so
		IntegerScanner sc = new IntegerScanner(System.in);
		PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

		int TC = sc.nextInt(); // there will be several test cases
		while (TC-- > 0) {
			V = sc.nextInt();

			// clear the graph and read in a new graph as Adjacency List
			AdjList = new Vector<Vector<IntegerPair>>();
			for (int i = 0; i < V; i++) {
				AdjList.add(new Vector<IntegerPair>());

				int k = sc.nextInt();
				while (k-- > 0) {
					int j = sc.nextInt(), w = sc.nextInt();
					AdjList.get(i).add(new IntegerPair(j, w)); // edge (road)
																// weight (in
																// minutes) is
																// stored here
				}
			}

			PreProcess(); // optional

			Q = sc.nextInt();
			while (Q-- > 0)
				pr.println(Query(sc.nextInt(), sc.nextInt(), sc.nextInt()));

			if (TC > 0)
				pr.println();
		}

		pr.close();
	}

	public static void main(String[] args) throws Exception {
		// do not alter this method
		Labor ps5 = new Labor();
		ps5.run();
	}
}

class IntegerScanner { // coded by Ian Leow, using any other I/O method is not
						// recommended
	BufferedInputStream bis;

	IntegerScanner(InputStream is) {
		bis = new BufferedInputStream(is, 1000000);
	}

	public int nextInt() {
		int result = 0;
		try {
			int cur = bis.read();
			if (cur == -1)
				return -1;

			while ((cur < 48 || cur > 57) && cur != 45) {
				cur = bis.read();
			}

			boolean negate = false;
			if (cur == 45) {
				negate = true;
				cur = bis.read();
			}

			while (cur >= 48 && cur <= 57) {
				result = result * 10 + (cur - 48);
				cur = bis.read();
			}

			if (negate) {
				return -result;
			}
			return result;
		} catch (IOException ioe) {
			return -1;
		}
	}
}

class IntegerPair implements Comparable<IntegerPair> {
	Integer _first, _second;

	public IntegerPair(Integer f, Integer s) {
		_first = f;
		_second = s;
	}

	public int compareTo(IntegerPair o) {
		if (!this.first().equals(o.first()))
			return this.first() - o.first();
		else
			return this.second() - o.second();
	}

	Integer first() {
		return _first;
	}

	Integer second() {
		return _second;
	}
}