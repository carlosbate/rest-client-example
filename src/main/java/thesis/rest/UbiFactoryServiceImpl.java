package thesis.rest;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;
import org.json.JSONObject;

public class UbiFactoryServiceImpl implements UbiFactoryService{

    private String host;
    private String port;

    public UbiFactoryServiceImpl(String host, String port) {
        this.host = host;
        this.port = port;
        //Unirest.setTimeouts(10000, 10000);
    }

    public JSONArray getAll() {
        try {
            HttpResponse<JsonNode> jsonResponse = Unirest
                    .get("http://" + host + ":" + port +"/ubis")
                    .header("accept", "application/json")
                    .asJson();
            return jsonResponse.getBody().getArray();
        } catch (UnirestException e) {
            e.printStackTrace();
            return null;
        }
    }

    public JSONObject addUbiSOM(UbiSOM ubisom){
        try {
            HttpResponse<JsonNode> jsonResponse = Unirest
                    .post("http://" + host + ":" + port +"/ubis")
                    .header("accept", "application/json")
                    .body(ubisom.toJson())
                    .asJson();
            return jsonResponse.getBody().getObject();
        } catch (UnirestException e) {
            e.printStackTrace();
            return null;
        }
    }

    public JSONObject getUbiSOM(String id) {
        try {
            HttpResponse<JsonNode> jsonResponse = Unirest
                    .get("http://" + host + ":" + port +"/ubis/{id}")
                    .routeParam("id",id)
                    .header("accept", "application/json")
                    .asJson();
            return jsonResponse.getBody().getObject();
        } catch (UnirestException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean deleteUbiSOM(String id) {
        try {
            HttpResponse<JsonNode> jsonResponse = Unirest
                    .delete("http://" + host + ":" + port +"/ubis/{id}")
                    .routeParam("id",id)
                    .header("accept", "application/json")
                    .asJson();
            return jsonResponse.getStatus() == 204;
        } catch (UnirestException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean feedUbiSOM(String id, JSONObject o) {
        try {
            HttpResponse<String> res = Unirest
                    .patch("http://" + host + ":" + port +"/ubis/{id}")
                    .routeParam("id",id)
                    .header("accept", "application/json")
                    .body(o)
                    .asString();
            return res.getStatus() == 202;
        } catch (UnirestException e) {
            e.printStackTrace();
            return false;
        }
    }

    public JSONObject getUbiSOMData(String id) {
        try {
            HttpResponse<JsonNode> jsonResponse = Unirest
                    .get("http://" + host + ":" + port +"/ubis/{id}/data")
                    .routeParam("id",id)
                    .header("accept", "application/json")
                    .asJson();
            return jsonResponse.getBody().getObject();
        } catch (UnirestException e) {
            e.printStackTrace();
            return null;
        }
    }

    public JSONArray getHitCount(String id) {
        try {
            HttpResponse<JsonNode> jsonResponse = Unirest
                    .get("http://" + host + ":" + port +"/ubis/{id}/data/hitcounts")
                    .routeParam("id",id)
                    .header("accept", "application/json")
                    .asJson();
            return jsonResponse.getBody().getArray();
        } catch (UnirestException e) {
            e.printStackTrace();
            return null;
        }
    }

    public JSONArray getUMat(String id) {
        try {
            HttpResponse<JsonNode> jsonResponse = Unirest
                    .get("http://" + host + ":" + port +"/ubis/{id}/data/umat")
                    .routeParam("id",id)
                    .header("accept", "application/json")
                    .asJson();
            return jsonResponse.getBody().getArray();
        } catch (UnirestException e) {
            e.printStackTrace();
            return null;
        }
    }

    public JSONArray getWeights(String id) {
        try {
            HttpResponse<JsonNode> jsonResponse = Unirest
                    .get("http://" + host + ":" + port +"/ubis/{id}/data/weights")
                    .routeParam("id",id)
                    .header("accept", "application/json")
                    .asJson();
            return jsonResponse.getBody().getArray();
        } catch (UnirestException e) {
            e.printStackTrace();
            return null;
        }
    }
}
