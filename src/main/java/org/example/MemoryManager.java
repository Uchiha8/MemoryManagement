package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MemoryManager {
    private static final int totalMemorySize = 100;
    private static List<MemoryBlock> freeBlocks;
    private static List<MemoryBlock> allocatedBlocks;
    private static int address = 0;

    public MemoryManager() {
        freeBlocks = initializer(List.of(15, 30, 10, 45));
        allocatedBlocks = new ArrayList<>();
    }

    public List<MemoryBlock> initializer(List<Integer> sizeBlocks) {
        if (totalMemorySize == sizeBlocks.stream().mapToInt(Integer::intValue).sum()) {
            List<MemoryBlock> memoryBlocks = new ArrayList<>();
            for (Integer size : sizeBlocks) {
                memoryBlocks.add(new MemoryBlock(0, size, '\0'));
            }
            return memoryBlocks;
        }
        return null;
    }

    public void firstFit(char processId, int size) {
        for (MemoryBlock block : freeBlocks) {
            if (block.size >= size) {
                MemoryBlock allocatedBlock = new MemoryBlock(address, size, processId);
                address += size;
                freeBlocks.remove(block);
                allocatedBlocks.add(allocatedBlock);
                return;
            }
        }
        System.out.println("Unable to allocate memory for Process " + processId + " using First Fit");
    }

    public void bestFit(char processId, int size) {
        freeBlocks.sort(Comparator.comparingInt(b -> b.size));
        for (MemoryBlock block : freeBlocks) {
            if (block.size >= size) {
                MemoryBlock allocatedBlock = new MemoryBlock(address, size, processId);
                address += size;
                freeBlocks.remove(block);
                allocatedBlocks.add(allocatedBlock);
                return;
            }
        }

        System.out.println("Unable to allocate memory for Process " + processId + " using Best Fit");
    }

    public void worstFit(char processId, int size) {
        freeBlocks.sort(Comparator.comparingInt((MemoryBlock b) -> b.size).reversed());
        for (MemoryBlock block : freeBlocks) {
            if (block.size >= size) {
                MemoryBlock allocatedBlock = new MemoryBlock(address, size, processId);
                address += size;
                freeBlocks.remove(block);
                allocatedBlocks.add(allocatedBlock);
                return;
            }
        }

        System.out.println("Unable to allocate memory for Process " + processId + " using Worst Fit");
    }

    public void displayAllocatedBlocks() {
        System.out.println("Allocated Memory Blocks:");
        for (MemoryBlock block : allocatedBlocks) {
            System.out.println("Process ID: " + block.processId + ", Start Address: " + block.startAddress + ", Size: " + block.size);
        }
    }
}
