import javax.naming.OperationNotSupportedException;

public class SinglyLinkedList {
    class Node {
        private int data;
        private Node next;

        public Node(int data){
            this.data = data;
        }

        @Override
        public String toString() {
            return "["+data+"]";
        }
    }
    private Node head;

    /**
     * Add a new node containing data
     * at the head of the list
     * Takes O(1) time
     */
    public void addFirst(int data){
        Node newNode = new Node(data);
        newNode.next = head;
        this.head = newNode;
    }

    /**
     * Add a new node containing data
     * at the end of the list
     * Takes O(1) time
     * but finding the last node takes O(n) time
     * Takes overall O(n) time
     */
    public void addLast(int data){
        Node newNode = new Node(data);
        if(!isEmpty()){
            Node current = this.head;
            while (current.next != null){
                current = current.next;
            }
            current.next = newNode;
        } else {
            head = newNode;
        }
    }

    /**
     * Inserts a new node containing data at index position.
     * Insertion takes O(1) time but
     * finding the node at the insertion point takes O(n) time
     * Takes overall O(n) time
     */
    public void insert(int data, int index) throws OperationNotSupportedException {
        if(isEmpty()){
            throw new OperationNotSupportedException();
        } else{
            if (index >= size()){
                throw new IllegalArgumentException("index is to high");
            }
            if(index == 0){
                addFirst(data);
                return;
            }
            Node newNode = new Node(data);
            Node current = head;
            int position = 0;
            while (position < index -1) {
                current = current.next;
                position++;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    /**
     * Remove the first node from the list
     * @return deleted node
     * Takes O(1) time
     */
    public Node removeFirst(){
        if(!isEmpty()){
            Node current = head;
            if(head.next != null){
                head = head.next;
            } else {
                head = null;
            }
            return current;
        }
        return null;
    }

    /**
     * Remove the last node from the list
     * @return deleted node
     * Deletion takes O(1) time but finding the last node takes O(n) time
     * Takes overall O(n) time
     */
    public Node removeLast(){
        if(!isEmpty()){
            Node current = head;
            if(size() == 1){
                head = null;
                // if size is tracked field
                // size = 0
            } else {
                Node prev = null;
                while (current.next != null){
                    prev = current;
                    current = current.next;
                }
                prev.next = null;
            }
            return current;
        }
        return null;
    }
    public Node removeByKey(int key){
        if(!isEmpty()){
            Node current = head;
            if(current.data == key){
                if(size()==1){
                    head = null;
                } else {
                    head = current.next;
                }
                return current;
            } else {
                Node prev = null;
                while ((current.next != null)){
                    prev = current;
                    current = current.next;
                    if(current.data == key){
                        prev.next = current.next;
                        return current;
                    }
                }
            }
        }
        return null;
    }

    /**
     *  @return the number of nodes in the list.
     *  Takes O(n) time, for scanning the list of size n
     */
    public int size(){
        Node current = this.head;
        int count = 0;
        while (current != null){
            count++;
            current = current.next;
        }
        return count;
    }
    public boolean isEmpty(){
        return head == null;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node current = this.head;
        while (current != null){
            if(current == this.head){
                sb.append("Head:").append(current).append(" -> ");
            } else if(current.next == null){
                sb.append("Tail:").append(current);
            } else {
                sb.append(current).append(" -> ");
            }
            current = current.next;
        }
        return sb.toString();
    }
}
