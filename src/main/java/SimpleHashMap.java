import java.util.Arrays;

public class SimpleHashMap {
    /**
     * Init index, Simple Hash Map capacity, and update capacity
     **/
    private int lastPosition = 0;
    private int INITIAL_CAPACITY = 1;
    /**
     * get resized length by multiplying and sum INITIAL_CAPACITY
     */
    private int RESIZE_HASH_MAP = INITIAL_CAPACITY * 2;

    /**
     * Init node and array of nodes
     **/
    private Node[] nodes = new SimpleHashMap.Node[INITIAL_CAPACITY];
    private Node node;

    /**
     *
     * @param K The Key of simple hash map
     * @param V Value what is related to the Key
     */
    /**
     * Put node with KEY and VALUE into the nodes array
     * Use Method UpdateNodeArrayMaxCapacity
     * Init new node instance
     * Check if node Key is unique
     * Put in arrays nodes on index of last position
     * Update index in array
     */
    public void put(int K, long V) {
        UpdateNodeArrayMaxCapacity();
        node = new Node(K, V);
        node.key = checkAndMoveKey(K);
        nodes[lastPosition] = node;
        lastPosition++;

    }

    /**
     * @param K find the value by KEY
     * @return the Value related to the KEY
     * Call method fndExistValue to find an index of nodes which is related by the Key
     */
    public long get(int K) {
        return nodes[findExistKey(K)].value;
    }

    /**
     * @return lastPosition is a value summed from all added Keys from node
     */
    public int size() {
        int count = 0;
        boolean isNotNull = true;
        while (isNotNull && count < nodes.length) {
            if (nodes[count] != null) {
                count++;

            } else isNotNull = false;
        }
        return count;
    }

    /**
     * Create nested Class Node to collect data and store information with Key and related with key value
     */
    private class Node {

        private int key;
        private long value;

        public Node(int key, long value) {
            this.key = key;
            this.value = value;
        }


    }

    /**
     * @param k the key for search
     * @return if found return false else return true
     * find a duplicate of keys the array of nodes
     */
    private boolean isNotUnique(int k) {
        int count = 0;
        while (nodes[count] != null) {
            if (nodes[count].key == k) {

                return true;
            }
            count++;
        }
        return false;
    }

    /**
     * check is nodes array can get the node or need resize it
     */

    private void UpdateNodeArrayMaxCapacity() {
        if (INITIAL_CAPACITY <= lastPosition) {
            INITIAL_CAPACITY += RESIZE_HASH_MAP;
            nodes = Arrays.copyOf(nodes, INITIAL_CAPACITY);
        }
    }

    /**
     * //     * @param K getting the KEY from argument to find an empty K index in nodes array
     * //     * @return found unique empty index in K nodes
     * //
     */
    private int checkAndMoveKey(int K) {
        while (isNotUnique(K)) {
            K++;
            checkAndMoveKey(K);
        }
        return K;
    }

    /**
     * @param K Key
     * @return Index of array nodes
     * Find an exist value with related Key if not exist throws NullPointerException
     */
    private int findExistKey(int K) {
        int index = 0;
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i]!= null) {
                if (nodes[i].key == K) {
                    return i;
                }
            }
        }
        throw new NullPointerException();
    }
}
