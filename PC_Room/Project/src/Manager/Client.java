package Manager;

import java.io.IOException;
import java.net.Socket;

public class Client {
	Socket socket=null;
	Buy_Time gui;
	//Modal gui;

	public final void setGui(Buy_Time gui) {
		this.gui = gui;
	}
	


	public void connect() {
		try {
			socket=new Socket("127.0.0.1", 7772);
			System.out.println("¼º°ø");
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
