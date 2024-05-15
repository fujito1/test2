    package de.porsche;

    import java.io.IOException;

    public class Main_ {

        public static void main(String[] args) {
            for(int i=0;i< 3; i++){

                int finalI = i;
                Thread serverThread=new Thread(() ->{ //parameter of lambda expression is (), -> this operator separate the parameter from the body, {} the body
                                                      //lambda expresion define behavior of each thread
                    EchoServer server=new EchoServer();
                    try {
                        server.start(7788 + finalI);
                        //server.stop();
                    } catch (IOException e) {
                        //System.err.println(e.getMessage());
                        System.err.println("Error starting server on port" + (7788 + finalI) + ": " + e.getMessage());
                    }
                });
                serverThread.start();

                //why finalI, capturing the current value ensures that the lambda expression uses the specific
                // value that was captured when it was created, even if the value of the original variable changes later on.

            }


        }
    }
