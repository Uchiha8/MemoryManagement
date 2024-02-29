# Memory Management Demo

## How to run 
  * Configure IntelliJ IDEA with JDK 17.

## Architecture
### MemoryBlock
This class serves as a blueprint for memory blocks, comprising the following attributes:
  * `startAddress`: Indicates the starting address of the block in the stack from the total size.
  * `size`: Represents the size of the block itself.
  * `processId`: Stores the name of the associated process.

### MemoryManager
The `MemoryManager` class includes functions such as `firstFit`, `bestFit`, and `worstFit` for memory allocation. It also has an initializer to set up the initial state of memory blocks.
  * `totalMemorySize`: A constant representing the total size of memory.
  * `freeBlocks`: A list of free memory blocks.
  * `allocatedBlocks`: A list of memory blocks that have been allocated.
  * `address`: A static variable tracking the current address during memory allocation.

#### Functions
  * `MemoryManager()`: Constructor method initializing `freeBlocks` and `allocatedBlocks`.
  * `initializer(List<Integer> sizeBlocks)`: Initializes memory blocks based on a list of sizes.
  * `firstFit(char processId, int size)`: Allocates memory using the First Fit algorithm.
  * `bestFit(char processId, int size)`: Allocates memory using the Best Fit algorithm.
  * `worstFit(char processId, int size)`: Allocates memory using the Worst Fit algorithm.
  * `displayAllocatedBlocks()`: Displays the allocated memory blocks along with their details.

### Main
The `Main` class contains the `main` method to demonstrate the memory management functionalities.

## Output
### Sample Example and Output
```plaintex
Input: totalSize=100, List.of(15, 30, 10, 45)
Allocated Memory Blocks:
Process ID: A, Start Address: 0, Size: 20
Process ID: B, Start Address: 20, Size: 15
Process ID: C, Start Address: 35, Size: 25
