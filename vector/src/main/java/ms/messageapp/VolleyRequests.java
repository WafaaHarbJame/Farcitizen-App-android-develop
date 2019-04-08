package ms.messageapp;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;

/**
 * Created by hp on 12/09/2017.
 */

public class VolleyRequests<T> extends Observable {
    public interface IReceiveData<T> {
        void onDataReceived(T posts);
    }

    IReceiveData iReceiveData;


    public void getCatogory(final String student_db_id){
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,
                "http://api.farcitizen.com/sites", null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                GsonBuilder gsonBuilder = new GsonBuilder();
                Gson gson = gsonBuilder.create();
                Server catogoryResponse = gson.fromJson(response.toString(),Server.class);

                setChanged();
                notifyObservers(catogoryResponse);

                if(iReceiveData !=null){
                    iReceiveData.onDataReceived(catogoryResponse);
                }


               /* try {
                    JSONArray array = response.getJSONArray(AppConstants.CATOGORY_KEY);
                    for(int i=0;i<array.length();i++){

                      //JSONObject jsonObject =   array.getJSONObject(i);
                      //jsonObject.get

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }*/

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {

                return super.getHeaders();
            }

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> map = new HashMap();
                map.put("student_db_id",student_db_id);

                return map;
            }
        };

        VectorApp.MyApplication.getInstance().addToRequestQueue(jsonObjectRequest);
    }
    public void getProduct(){
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,
                "http://api.farcitizen.com/sites", null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                GsonBuilder gsonBuilder = new GsonBuilder();
                Gson gson = gsonBuilder.create();
                Server productResponse = gson.fromJson(response.toString(),Server.class);

                setChanged();
                notifyObservers(productResponse);

                if(iReceiveData !=null){
                    iReceiveData.onDataReceived(productResponse);
                }


               /* try {
                    JSONArray array = response.getJSONArray(AppConstants.CATOGORY_KEY);
                    for(int i=0;i<array.length();i++){

                      //JSONObject jsonObject =   array.getJSONObject(i);
                      //jsonObject.get

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }*/

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {

                return super.getHeaders();
            }

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> map = new HashMap();
                //map.put("student_db_id",student_db_id);

                return map;
            }
        };

        VectorApp.MyApplication.getInstance().addToRequestQueue(jsonObjectRequest);
    }

    public VolleyRequests setIReceiveData(IReceiveData iReceiveData) {
        this.iReceiveData = iReceiveData;
        return this;
    }



    public VolleyRequests setiReceiveData(IReceiveData iReceiveData) {
        this.iReceiveData = iReceiveData;
        return this;
    }

    public void getPosts(){
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest("http://api.farcitizen.com/sites", new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                /*
                for(int i=0;i<response.length();i++){
                    try {
                        JSONObject jsonObject =  response.getJSONObject(i);
                        int userId = jsonObject.getInt(AppConstants.USER_ID);
                        int id = jsonObject.getInt(AppConstants.ID);
                        String title = jsonObject.getString(AppConstants.TITLE);
                        String body = jsonObject.getString(AppConstants.BODY);
                        Post post = new Post(body,title,userId,id);

                        tvJSON.append(post.getUserId()+"");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                */
                GsonBuilder builder = new GsonBuilder();
                Gson gson = builder.create();
                Type type = new TypeToken<List<Server>>(){}.getType();
                List<Server> posts = gson.fromJson(response.toString(),type);

                setChanged();
                notifyObservers(posts);

                if(iReceiveData !=null){
                    iReceiveData.onDataReceived(posts);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        VectorApp.MyApplication.getInstance().addToRequestQueue(jsonArrayRequest);
    }





}