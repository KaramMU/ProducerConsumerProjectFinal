# ProducerConsumerProjectFinal

In this project I explored mutual exclusion via a bounded buffer problem. 
implemented an IntegerProducer and IntegerConsumer. Each of these will run as a Thread, and there is an interface
provided for each of these concepts. In addition, implemented the BufferInterface as a CircularBuffer. This
buffer will act as shared memory for the producer and consumer threads.
The IntegerProducer will produce integers from 0 to N, where N is determined by how long the threads run.
The IntegerConsumer will get each produced integer in order, but will basically only check that it received all of the
produced Integers.

