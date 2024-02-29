package org.example;

public class Main {
    public static void main(String[] args) {
        MemoryManager memoryManager = new MemoryManager();
        // Allocate memory using First Fit
        memoryManager.firstFit('A', 20);

        // Allocate memory using Best Fit
        memoryManager.bestFit('B', 15);

        // Allocate memory using Worst Fit
        memoryManager.worstFit('C', 25);

        // Display allocated memory blocks
        memoryManager.displayAllocatedBlocks();
    }
}