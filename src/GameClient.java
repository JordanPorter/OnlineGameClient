//import java.io.*;
//import java.net.*;
//import java.util.Scanner;
//
//class GameClient {
//    static String name = "";
//    String host = "localhost";
//    int port = 6789;
//    Socket socket = null;
//    static GameClient client;
//    
//    public static void main(String args[]) throws Exception{
//        client = new GameClient();
//        Scanner sc = new Scanner(System.in);
//        String text = "";
//        boolean closed = false;
//        System.out.print("What is your name:" );
//        name = sc.nextLine();
//        recieveThread.start();
//        client.SendToServer(name + " Connected\n");
//        while(closed == false)	{
//        	System.out.print("Your Message: ");
//        	text = sc.nextLine();
//        	client.SendToServer(name + ": " + text + "\n") ;
//        }
//        client.close();
//    }
//
//    static Thread recieveThread = new Thread()	{
//    	public void run()	{
//    		try {
//    			if(client.RecieveFromServer().equalsIgnoreCase("null"))	{
//    				/**DO NOTHING**/
//    			}
//    			else	{
//    				System.out.println(client.RecieveFromServer());
//    			}
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//    	}
//    };
//    
//    GameClient(String _host, int _port) throws Exception{
//        host = _host;
//        port = _port;
//        socket = new Socket(host, port);
//    }
//    
//    GameClient() throws Exception{
//        socket = new Socket(host, port);
//    }
//    
//    void SendToServer(String msg) throws Exception{
//        //create output stream attached to socket
//        PrintWriter outToServer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
//        //send msg to server
//        outToServer.print(msg + '\n');
//        outToServer.flush();
//    }
//    
//    String RecieveFromServer() throws Exception{
//        //create input stream attached to socket
//        BufferedReader inFromServer = new BufferedReader(new InputStreamReader (socket.getInputStream()));
//        //read line from server
//        String res = inFromServer.readLine(); // if connection closes on server end, this throws java.net.SocketException 
//        return res;
//    }
//    
//    void close() throws IOException{
//        socket.close();
//    }
//}