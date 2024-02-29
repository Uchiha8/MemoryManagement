package org.example;

public class MemoryBlock {
    int startAddress;
    int size;
    char processId;

    MemoryBlock(int startAddress, int size, char processId) {
        this.startAddress = startAddress;
        this.size = size;
        this.processId = processId;
    }
}
