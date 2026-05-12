Capstone Project – Phase 1 Design Document
Smart Scheduler Using a Heap-Based Priority Queue
1. Problem Statement: 
This project addresses the need for efficient task scheduling in systems where certain tasks have higher priority than others. In real-world scenarios such as hospital emergency rooms or operating systems, tasks cannot simply be processed in the order they arrive. Instead, more urgent tasks must be handled first to maximize efficiency and minimize risk.
2. Chosen Data Structure:
I selected a Min-Heap (Priority Queue) to manage task scheduling. A heap is ideal for this problem because it allows efficient insertion of new tasks and fast retrieval of the highest-priority task.
Unlike arrays or linked lists, which require O(n) time to find the most urgent task, a heap maintains a partially ordered structure that guarantees O(log n) insertion and deletion operations.
3. Alternative Approaches:
An array or linked list could also be used to store tasks; however, both require linear time O(n) to locate the highest priority task. This makes them inefficient for real-time systems with frequent updates.
A sorted array improves retrieval time but makes insertion expensive (O(n)). Therefore, a heap provides the best balance between insertion and deletion efficiency.
4. Core Operations:
- insertTask(Task): Adds a new task into the heap (O(log n))
- getNextTask(): Removes and returns the highest priority task (O(log n))
- peek(): Returns the highest priority task without removing it (O(1))
5. Big-O Analysis:
Insertion of a task requires O(log n) time due to heap rebalancing. Removal of the highest priority task also requires O(log n). Accessing the top element is O(1). Overall, the heap ensures efficient performance for dynamic scheduling systems.
