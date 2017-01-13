package org.emeritus.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.Arrays;


public class Chapter2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        int[][] testMatrix = new int[7][7];
        Log.d("darran", "matrix is" + Arrays.deepToString(testMatrix));

        int[][] matrix = randomMatrix(3, 3, 0, 9);

        Log.d("darran", "matrix is" + Arrays.deepToString(matrix));

//        LinkedListNode first = new LinkedListNode(0, null, null); //AssortedMethods.randomLinkedList(1000, 0, 2);
//        LinkedListNode head = first;
//        LinkedListNode second = first;
//        for (int i = 1; i < 8; i++) {
//            second = new LinkedListNode(i % 2, null, null);
//            first.setNext(second);
//            second.setPrevious(first);
//            first = second;
//        }
//        System.out.println(head.printForward());
//
//        LinkedListNode cloneA = head.clone();
//        removeDuplicates(cloneA);


//        System.out.println(cloneA.printForward());

        int[] array = {0, 1, 2};
        LinkedListNode head = createLinkedListFromArray(array);
        Log.d("darran", "kthToLast is: " + kthToLastVersion2(head, 3).data);

    }

//    public LinkedListNode partitionLinkedList(LinkedListNode incomingLinkedList, int partitionValue) {
//        LinkedListNode rightPartition = new LinkedListNode();
//        LinkedListNode currentNode = incomingLinkedList;
//        while (currentNode.next != null) {
//            if(currentNode.next.data >= partitionValue) {
//                rightPartition.next = currentNode.next;
//                currentNode.next
//            }
//            currentNode = currentNode.next;
//        }
//        currentNode.setNext(rightPartition);
//        return incomingLinkedList;
//    }

//
//    public void removeDuplicates(LinkedListNode n) {
//        HashMap<String, Boolean> duplicateMap = new HashMap<>();
//
//        Iterator<String> it = stringLinkedList.iterator();
//        while(it.hasNext()) {
//            if (duplicateMap.get(it.next()) != null) {
//                stringLinkedList.remove();
//            }
//            duplicateMap.put(it.next(), true);
//        }
//
//    }

    public LinkedListNode getKthToLast(LinkedListNode n, int kthToLast) {
        LinkedListNode kthToLastNode = n;
        while(n.next != null) {
            kthToLast--;
            if (kthToLast <= 0) {
                kthToLastNode = kthToLastNode.next;
            }
            n=n.next;

        }

        return kthToLastNode;
    }

    public LinkedListNode kthToLastVersion2(LinkedListNode n, int kthToLast) {
        LinkedListNode kth = n;
        LinkedListNode runner = n;
        for (int i = 0; i < kthToLast; i++) {
            if (runner == null) return null;
                runner = runner.next;

        }

        while (runner != null) {
            runner =runner.next;
            kth = kth.next;
        }

        return kth;
    }

    public static LinkedListNode nthToLast(LinkedListNode head, int k) {
        LinkedListNode p1 = head;
        LinkedListNode p2 = head;

		/* Move p1 k nodes into the list.*/
        for (int i = 0; i < k; i++) {
            if (p1 == null) return null; // Out of bounds
            p1 = p1.next;
        }

		/* Move them at the same pace. When p1 hits the end,
		 * p2 will be at the right element. */
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }

    public static int[][] randomMatrix(int M, int N, int min, int max) {
        int[][] matrix = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = randomIntInRange(min, max);
            }
        }
        return matrix;
    }

    public static int randomInt(int n) {
        return (int) (Math.random() * n);
    }

    public static int randomIntInRange(int min, int max) {
        return randomInt(max + 1 - min) + min;
    }

    public static LinkedListNode createLinkedListFromArray(int[] vals) {
        LinkedListNode head = new LinkedListNode(vals[0], null, null);
        LinkedListNode current = head;
        for (int i = 1; i < vals.length; i++) {
            current = new LinkedListNode(vals[i], null, current);
        }
        return head;
    }
}
