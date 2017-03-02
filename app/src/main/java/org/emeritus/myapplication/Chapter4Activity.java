package org.emeritus.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import org.emeritus.myapplication.graphs.Graph;
import org.emeritus.myapplication.graphs.Node;
import org.emeritus.myapplication.graphs.SimpleNode;

import java.util.LinkedList;


/**
 * Created by darrankelinske on 1/22/17.
 */

public class Chapter4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Graph graph = createNewGraph();
        Node[] nodes = graph.getNodes();
        Node start = nodes[3];
        Node end = nodes[2];
        Log.d("darran", "A route exists: " + doesRouteExistTakeTwo(graph, start, end));
        Toast.makeText(this, "A route exists: " + doesRouteExistTakeTwo(graph, start, end), Toast.LENGTH_SHORT).show();

        int[] increasingArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};


        SimpleNode minimalBST = createMinimalBST(increasingArray);

        Log.d("darran", "Create minimal BST: " + minimalBST);

    }

    public static boolean doesRouteExistTakeTwo(Graph graph, Node start, Node end) {
        LinkedList<Node> queue = new LinkedList<>();
        for(Node node :graph.getNodes()) {
            node.state = Node.State.Unvisited;
        }

        start.state = Node.State.Visiting;
        queue.add(start);
        while (!queue.isEmpty()) {
            Node currentNode = queue.removeFirst();
            currentNode.state = Node.State.Visiting;
            for (Node node : currentNode.getAdjacent()) {
                if (node.state == Node.State.Unvisited) {
                    if (node == end) {
                        return true;
                    } else {
                        node.state = Node.State.Visiting;
                        queue.add(node);
                    }
                }
            }
            currentNode.state = Node.State.Visited;
        }

        return false;
    }


    private static SimpleNode createMinimalBST(int[] incomingArray, int start, int end) {
        if (end < start) {
            return null;
        }

        int mid = ((end + start) / 2);

        SimpleNode currentNode = new SimpleNode(incomingArray[mid]);
        currentNode.left = createMinimalBST(incomingArray, start, mid - 1);
        currentNode.right = createMinimalBST(incomingArray, mid + 1, end);
        return currentNode;
    }


    public static SimpleNode createMinimalBST(int[] incomingArray) {
        if (incomingArray == null) {
            return null;
        }
        return createMinimalBST(incomingArray, 0, incomingArray.length -1);

    }


    public static Graph createNewGraph()
    {
        Graph g = new Graph();
        Node[] temp = new Node[6];

        temp[0] = new Node("a", 3);
        temp[1] = new Node("b", 0);
        temp[2] = new Node("c", 0);
        temp[3] = new Node("d", 1);
        temp[4] = new Node("e", 1);
        temp[5] = new Node("f", 0);

        temp[0].addAdjacent(temp[1]);
        temp[0].addAdjacent(temp[2]);
        temp[0].addAdjacent(temp[3]);
        temp[3].addAdjacent(temp[4]);
        temp[4].addAdjacent(temp[5]);
        for (int i = 0; i < 6; i++) {
            g.addNode(temp[i]);
        }
        return g;
    }


    public static boolean doesRouteExist(Graph graph, Node start, Node end) {
        LinkedList<Node> queue = new LinkedList<>();
        for (Node node : graph.getNodes()) {
            node.state = Node.State.Unvisited;
        }
        start.state = Node.State.Visiting;
        queue.add(start);
        Node currentNode;
        while(!queue.isEmpty()) {
            currentNode = queue.removeFirst();
            if (currentNode != null) {
                for (Node adjacentNode : currentNode.getAdjacent()) {
                    if (adjacentNode.state == Node.State.Unvisited) {
                        if (adjacentNode == end) {
                            return true;
                        } else {
                            adjacentNode.state = Node.State.Visiting;
                            queue.add(adjacentNode);
                        }
                    }
                }
                currentNode.state = Node.State.Visited;
            }
        }
        return false;
    }
}
