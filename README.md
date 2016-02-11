# ProducerConsumerProjectFinal

# SERVER
The requirements for the server are the following:
1. The server must allow multiple clients to play simultaneously, but each client is playing their own game
2. The server must shuffle a deck of 52 standard playing cards
3. When requested by the client, the server will deal the client and itself separate 5 card hands from the same deck it shuffled
4. If the client bets, then the server will compare its hand to the client’s hand and inform the client whether or not client the won.
5. If the client folds, then the round ends
6. At the end of each round, both hands are returned to the deck and the deck is shuffled
7. The client may continue to play until they leave the table.
# CLIENT
The requirements for the client are the following:
1. The client sits down at the table by connecting to the server
2. The client must indicate when they want to be dealt a hand
3. The client must indicate when they fold
4. The client must indicate when they are betting and how much
5. The client leaves the table by disconnecting the connection to the server
