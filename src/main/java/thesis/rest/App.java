package thesis.rest;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static final String HOST = "somws.tk";
    public static final String PORT = "8989";
    public static UbiFactoryService ubis;

    public static void main( String[] args )
    {
        ubis = UbiFactoryService.create(HOST, PORT);

        System.out.println("GET ALL");
        System.out.println(ubis.getAll());

        System.out.println("CREATE ONE");
        List<String> weightLabels = new ArrayList<String>(2);
        weightLabels.add("One");
        weightLabels.add("Two");
        UbiSOM mock = new UbiSOM("test",weightLabels,2);
        System.out.println("MOCK");
        System.out.println(mock.toJson());
        UbiSOM ubi = new UbiSOM(ubis.addUbiSOM(mock));
        System.out.println(ubi.getId());

        System.out.println("GET ALL");
        System.out.println(ubis.getAll());
        System.out.println("\n\nGET ONE");
        System.out.println(ubis.getUbiSOM(ubi.getId()));
        System.out.println("\n\nGET DATA");
        System.out.println(ubis.getUbiSOMData(ubi.getId()));
        System.out.println("\n\nGET HITCOUNTS");
        System.out.println(ubis.getHitCount(ubi.getId()));
        System.out.println("\n\nGET UMAT");
        System.out.println(ubis.getUMat(ubi.getId()));
        System.out.println("\n\nGET WEIGHTS");
        System.out.println(ubis.getWeights(ubi.getId()));

        JSONObject data = new JSONObject("{\"data\":[[0,0],[0,1],[1,1],[1,0],[0.1,0.1],[0,1],[1,1],[1,0],[0,0],[0.1,1],[1,0.9],[1,0],[0,0],[0,1],[1,1],[0.9,0.1],[0,0]]}");

        System.out.println("\n\nFEED");
        System.out.println(ubis.feedUbiSOM(ubi.getId(), data));
        /*
        System.out.println("\n\nDELETE");
        System.out.println(ubis.deleteUbiSOM(ubi.getId()));
        */
    }
}
