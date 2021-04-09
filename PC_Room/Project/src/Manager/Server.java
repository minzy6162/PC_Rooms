package Manager;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable{
	ServerSocket serversocket=null;
	Socket socket=null;
	ShowSeat gui;
	
	
	public final void setGui(ShowSeat gui) {
		this.gui = gui;
	}


	public void setting() {
		try {
			serversocket=new  ServerSocket(7772);
			System.out.println("¥Î±‚¡ﬂ...");
			socket=serversocket.accept();
			
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		gui.dbConnect();
		//gui.showTable;
	}
}
