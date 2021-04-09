package Manager;

import java.io.IOException;
import java.net.Socket;

public class Food {
	Socket socket=null;
	FoodExam gui;
	//Modal gui;

	public final void setGui(FoodExam gui) {
		this.gui = gui;
	}
	public void connect() {
		try {
			socket=new Socket("127.0.0.1", 7776);
			System.out.println("¼º°ø");
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
