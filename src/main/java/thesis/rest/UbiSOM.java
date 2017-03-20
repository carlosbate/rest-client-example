package thesis.rest;


import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class UbiSOM {

    private String id;
    private String name;
    private List<String> weightLabels;
    private int width;
    private int height;
    private int dim;
    private double alphaI;
    private double alphaF;
    private double sigmaI;
    private double sigmaF;
    private double betaValue;
    private JSONObject normalization;
    private String in;
    private String out;

    public UbiSOM(String name, List<String> weightLabels, int dim) {
        this.id = null;
        this.name = name;
        this.weightLabels = weightLabels;
        this.dim = dim;

        this.width = 40;
        this.height = 20;
        this.alphaI = 0.1;
        this.alphaF = 0.08;
        this.sigmaI = 0.6;
        this.sigmaF = 0.2;
        this.betaValue = 0.7;
        this.normalization = new JSONObject().put("type", "NONE");
    }

    public UbiSOM(String name, List<String> weightLabels, int width, int height, int dim, double alphaI, double alphaF, double sigmaI, double sigmaF, double betaValue, JSONObject normalization) {
        this.id = null;
        this.name = name;
        this.weightLabels = weightLabels;
        this.width = width;
        this.height = height;
        this.dim = dim;
        this.alphaI = alphaI;
        this.alphaF = alphaF;
        this.sigmaI = sigmaI;
        this.sigmaF = sigmaF;
        this.betaValue = betaValue;
        this.normalization = normalization;
        this.in = null;
        this.out = null;
    }

    public UbiSOM(JSONObject ubisom){
        this.id = ubisom.getString("id");
        this.name = ubisom.getString("name");
        this.width = ubisom.getInt("width");
        this.height = ubisom.getInt("height");
        this.dim = ubisom.getInt("dim");
        this.alphaI = ubisom.getDouble("alpha_i");
        this.alphaF = ubisom.getDouble("alpha_f");
        this.sigmaI = ubisom.getDouble("sigma_i");
        this.sigmaF = ubisom.getDouble("sigma_f");
        this.betaValue = ubisom.getDouble("beta_value");
        this.normalization = ubisom.getJSONObject("normalization");
        JSONArray wLabels = ubisom.getJSONArray("weight-labels");
        weightLabels = new ArrayList<>(wLabels.length());
        for(int i = 0; i < wLabels.length(); i++)
            weightLabels.add((String)wLabels.get(i));
        this.in = ubisom.getString("in");
        this.out = ubisom.getString("out");
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<String> getWeightLabels() {
        return weightLabels;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getDim() {
        return dim;
    }

    public double getAlphaI() {
        return alphaI;
    }

    public double getAlphaF() {
        return alphaF;
    }

    public double getSigmaI() {
        return sigmaI;
    }

    public double getSigmaF() {
        return sigmaF;
    }

    public double getBetaValue() {
        return betaValue;
    }

    public JSONObject getNormalization() {
        return normalization;
    }

    public String getIn() {
        return in;
    }

    public String getOut() {
        return out;
    }

    private JSONArray convertLabels(){
        JSONArray res = new JSONArray();
        weightLabels.stream().forEach(res::put);
        return res;
    }

    public JSONObject toJson(){
        JSONObject res = new JSONObject()
                .put("name",this.name)
                .put("weight-labels", convertLabels())
                .put("width", this.width)
                .put("height",this.height)
                .put("dim", this.dim)
                .put("alpha_i", this.alphaI)
                .put("alpha_f", this.alphaF)
                .put("sigma_i", this.sigmaI)
                .put("sigma_f", this.sigmaF)
                .put("beta_value", this.betaValue)
                .put("normalization", this.normalization);

        if(id != null && in != null && out != null)
            res.put("id",this.id).put("in", this.in).put("out", this.out);
        return res;
    }

}
