import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import netscape.javascript.JSObject;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class JsonToList {
    public static List<Employee> jsonToList(String json) {
        List<Employee> listEmployee = new ArrayList<>();
        JsonParser parser = new JsonParser();
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        JsonArray jsonArray = (JsonArray) parser.parse(json);

        for (int i = 0; i < jsonArray.size(); i++) {
            Employee employee = gson.fromJson(jsonArray.get(i), Employee.class);
            listEmployee.add(employee);
        }
        return listEmployee;
    }

}
