# Producer-Consumer Problem Solver

This repository contains a Java program that implements a solution to the classic Producer-Consumer problem using multi-threading and synchronization.

## Overview

The Producer-Consumer problem represents a synchronization problem between two threads, where one (the producer) produces data or resources and puts it into a shared buffer, and the other (the consumer) takes data or resources out of the buffer.

## Program Structure

- **`Producer.java`**: Defines the Producer class that implements the Runnable interface to simulate a producer placing items into the buffer.
- **`Consumer.java`**: Defines the Consumer class that implements the Runnable interface to simulate a consumer removing items from the buffer.
- **`Buffer.java`**: Defines the Buffer class with a static boolean array to represent the buffer and a shared index for tracking the buffer position.
- **`ProducerConsumer.java`**: Main class that initializes and starts the producer and consumer threads, handling their synchronization and execution.

## How to Use

1. **Clone the Repository**: Clone this repository to your local machine using the following command:
    ```bash
    git clone https://github.com/your-username/producer-consumer.git
    ```

2. **Compile and Run**: Use any Java IDE or compile the Java files using the command line. Execute the `ProducerConsumer.java` file to run the program.

3. **Observing Output**: The program will simulate the producer placing items into the buffer and the consumer removing items from the buffer. It will display the index where items are placed or consumed and the status of the buffer after each action.

4. **Terminating the Program**: The program runs indefinitely until manually terminated. To stop the program, use the appropriate stop/terminate command for your IDE or terminate the process in the command line.

5. **Contributions**: Contributions and improvements to the code are welcome! Fork this repository, make changes, and create a pull request.

## Note

- This implementation uses synchronized blocks and wait/notify mechanisms for thread synchronization. Understanding multi-threading concepts is crucial for modifying or extending this code for specific use cases.
