package utils;

import org.json.JSONObject;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class DataLoader {
    private static JSONObject testData;

    static {
        try {
            InputStream inputStream = DataLoader.class.getClassLoader().getResourceAsStream("testData.json");
            if (inputStream == null) {
                throw new RuntimeException("❌ Plik testData.json nie został znaleziony!");
            }
            Scanner scanner = new Scanner(inputStream, StandardCharsets.UTF_8).useDelimiter("\\A");
            String jsonText = scanner.hasNext() ? scanner.next() : "{}";
            testData = new JSONObject(jsonText);
        } catch (Exception e) {
            throw new RuntimeException("❌ Nie można załadować pliku testData.json", e);
        }
    }

    public static UserData loadUserData(String userType) {
        if (!testData.has(userType)) {
            throw new RuntimeException("❌ Użytkownik '" + userType + "' nie istnieje w testData.json!");
        }
        JSONObject userNode = testData.getJSONObject(userType);
        return new UserData(userNode.getString("firstName"), userNode.getString("lastName"), userNode.getString("username"), userNode.getString("password"), userNode.getString("email"));
    }

    public static String get(String userType, String field) {
        if (!testData.has(userType) || !testData.getJSONObject(userType).has(field)) {
            throw new RuntimeException("❌ Pole '" + field + "' nie istnieje dla użytkownika '" + userType + "'");
        }
        return testData.getJSONObject(userType).getString(field);
    }

    public static class UserData {
        public final String firstName;
        public final String lastName;
        public final String username;
        public final String password;
        public final String email;

        public UserData(String firstName, String lastName, String username, String password, String email) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.username = username;
            this.password = password;
            this.email = email;
        }
    }
}
