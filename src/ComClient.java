import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;


public class ComClient {

	String host;
	int port;
	
	private static Socket sock;
	private static PrintWriter pw;
	private static BufferedReader br;
	
	public static void main(String[] args) throws UnknownHostException, IOException	{
		sock = new Socket("localhost", 6789);
		pw = new PrintWriter(sock.getOutputStream());
		br = new BufferedReader(new InputStreamReader(sock.getInputStream()));
		while(!sock.isClosed())	{
			String incoming = br.readLine();
			System.out.println(incoming);
			pw.write("Jordan Is Connected");
		}
	}
	
	public void writeMessage(String message)	{
		pw.write(message + "\r\n");
	}
	
}
