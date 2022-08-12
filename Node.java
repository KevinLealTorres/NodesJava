import static java.lang.System.exit;

public class Node<T> {
    public T data = null;
    public Node<T> next = null;

    /**
     * enter point with T data as param
     * @param data
     */
    Node(T data){
        this.data = data;
    }

    /**
     * Enter point without params
     */
    Node(){}

    /**
     * This function runs across node until finds a null
     * @return i
     */
    int maxNumberCalculator() {
        Node<T> target = this;
        int i = 0;
        for(; target.next != null; i++) {
            target = target.next;
        }
        return i;
    }

    /**
     * This function goes to the last node and create a next node
     * with a node
     * @param next
     */
    void add(Node<T> next) {
        this.get(maxNumberCalculator()).next = next;
    }

    /**
     * This function goes to the last node and create a next node
     * with T content
     *
     * @param next
     */
    void add(T next) {
        this.get(maxNumberCalculator()).next = new Node<>(next) ;
    }

    /**
     * This function looking for target position and overwrite it
     * with the new data
     *
     * @param data
     * @param position
     */
    void insert(int position, T data) {
        this.get(position).data = data;
    }

    /**
     * This function looking for a target position and return it for anything
     * @return target
     * @param position
     */
    Node<T> get(int position) {
        Node<T> target = this;

        for(int i = position; i > 0; i--) {
            if(target.next == null) { indexOutFromArrayException(); }
            target = target.next;
        }
        return target;
    }

    /**
     * This function disconnect the node index and connect the "left" node
     * with the "right" node
     * @param nodeToDelete
     */
    void safeDelete(int nodeToDelete) {
        if(nodeToDelete == maxNumberCalculator()) {
            this.get(maxNumberCalculator() - 1).next = null;
        } else if(nodeToDelete == 0) {
            for(int i = 0; i < maxNumberCalculator(); i++) {
                this.get(i).data = this.get(i+1).data;
                this.get(i).next = this.get(i+1).next;
            }
        } else { this.get(nodeToDelete - 1).next = this.get(nodeToDelete + 1); }
    }

    /**
     * This exception is for index out from Node
     */
    private void indexOutFromArrayException() {
        System.out.println("The position given is out from Node");
        exit(1);
    }
}
