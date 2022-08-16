import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientFormController {

    //public TextField txtClientMessage;
    public TextField txtClientSendMessage;
    public TextArea txtClientMessage;

    Socket socket = null;
    public void initialize() throws IOException {
        new Thread(()->{
            try {
                socket = new Socket("localhost",5000);



            while (true){
                InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String record = bufferedReader.readLine();
                System.out.println(record);
                txtClientMessage.appendText("\nServer:" +record.trim() + "\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        }).start();



    }

    public void sendOnAction(ActionEvent actionEvent) throws IOException {
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
        printWriter.println(txtClientSendMessage.getText());
        txtClientSendMessage.setText(" ");
        printWriter.flush();

    }
}
