package ms.messageapp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

import ms.messageapp.R;
import ms.messageapp.Server;
import ms.messageapp.VolleyRequests;

public class server extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_server);
        new VolleyRequests().setiReceiveData(new VolleyRequests.IReceiveData() {
            @Override
            public void onDataReceived(Object posts) {
                Toast.makeText(server.this, ""+((List<Server>)posts).get(0).getLocation(), Toast.LENGTH_SHORT).show();
               // tvJSON.setText(((List<Post>)posts).get(0).getBody());

            }


        }).getPosts();
    }
}
