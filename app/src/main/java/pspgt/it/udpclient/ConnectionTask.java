package pspgt.it.udpclient;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * Created by gabry on 22/04/15.
 */
public class ConnectionTask extends AsyncTask<String,Integer,String> {

    private Context context;

    public ConnectionTask(Context context){
        this.context=context;
    }

    @Override
    protected String doInBackground(String... params) {
        String result="Errore nella comunicazione";
        try{
            byte[] data=params[0].getBytes();
            InetSocketAddress server=new InetSocketAddress("10.0.0.0",12345);
            DatagramSocket sock= new DatagramSocket();
            DatagramPacket packet=new DatagramPacket(data,data.length,server);
        }catch(IOException e){
            e.printStackTrace();
        }
        return result;
    }

    protected void onPostExecute(String result){
        Toast.makeText(context, result, Toast.LENGTH_LONG).show();
    }
}
