package csc223.kb;

class TreeQueue {
    private TreeNode[] queue;
    private int front;
    private int rear;
    private int count;

    public TreeQueue() {
        queue = new TreeNode[100]; 
        front = 0;
        rear = -1;
        count = 0;
    }

    public void enqueue(TreeNode node) {
        if (count == queue.length) {
            System.out.println("Queue is full");
            return;
        }
        rear = (rear + 1) % queue.length;
        queue[rear] = node;
        count++;
    }

    public TreeNode dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }
        TreeNode node = queue[front];
        front = (front + 1) % queue.length;
        count--;
        return node;
    }

    public boolean isEmpty() {
        return count == 0;
    }
}
