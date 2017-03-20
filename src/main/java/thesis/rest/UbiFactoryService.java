package thesis.rest;

import org.json.JSONArray;
import org.json.JSONObject;

public interface UbiFactoryService {

    static UbiFactoryService create(String host, String port){
        return new UbiFactoryServiceImpl(host, port);
    }

    JSONArray getAll();

    JSONObject addUbiSOM(UbiSOM ubisom);

    JSONObject getUbiSOM(String id);

    boolean deleteUbiSOM(String id);

    boolean feedUbiSOM(String id, JSONObject o);

    JSONObject getUbiSOMData(String id);

    JSONArray getHitCount(String id);

    JSONArray getUMat(String id);

    JSONArray getWeights(String id);

}
