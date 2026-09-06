class MyStack {
    private Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        queue.offer(x);
        for (int i = 0; i < queue.size() - 1; i++) {
            queue.offer(queue.peek());
            queue.poll();
        }

    }

    public int pop() {
        if (!empty()) {
            return queue.poll();
        }
        return -1;
    }

    public int top() {
        if (!empty()) {
            return queue.peek();
        }
        return -1;
    }

    public boolean empty() {
        if (queue.size() == 0) {
            return true;
        }
        return false;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */