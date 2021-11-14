package com.sbrf.reboot.repository;

import com.sbrf.reboot.dto.Account;
import org.json.JSONArray;
import org.json.JSONObject;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class AccountRepositoryImpl implements AccountRepository {

    private final String fileSRC;
    private Map<Long, HashSet<Account>> repository;

    public AccountRepositoryImpl(String fileSRC) throws FileNotFoundException{
        this.fileSRC = fileSRC;
        this.repository = loadRepositoryFromFile();
    }

    public static void main(String[] args) throws FileNotFoundException{
        String tmpSRC = "src/main/resources/Accounts.txt";
        Set<Account> accounts = new AccountRepositoryImpl(tmpSRC).getAllAccountsByClientId(1L);
        for (Account acc: accounts) {
            System.out.println(acc.getNumber());
        }
    }

    @Override
    public Set<Account> getAllAccountsByClientId(long l) {
        return repository.size() == 0 ? new HashSet<>() : repository.get(l);
    }

    private Map<Long, HashSet<Account>> loadRepositoryFromFile() throws FileNotFoundException {

        Map<Long, HashSet<Account>> rep = new HashMap<>();

        // read file and create json-file
        InputStream in = new FileInputStream(fileSRC);
        BufferedReader reader = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));

        String json;
        // read file and create json-file
        try {
            json = IOUtils.toString(reader);
            reader.close();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
            return rep;
        }

        //parsing json
        JSONArray arr = new JSONArray(json);
        for (int i = 0; i < arr.length(); ++i) {
            JSONObject account = arr.getJSONObject(i);
            long clientId = account.getInt("clientId");
            String number = account.getString("number");
            if (rep.containsKey(clientId)) {
                rep.get(clientId).add(new Account(number));
            } else {
                HashSet<Account> newSet = new HashSet<>();
                newSet.add(new Account(number));
                rep.put(clientId, newSet);
            }
        }
        return rep;
    }

//    private Map<Long, HashSet<Account>> saveRepositoryToFile() {
//
//        JSONObject json = new JSONObject();
//        JSONObject item = new JSONObject();
//        JSONArray array = new JSONArray();
//
//
//        StringBuilder builder = new StringBuilder();
//        for (long i = 0; i < repository.size(); i++){
//            for (Account acc: repository.get(i)){
//
//            }
//        }
//
//
//        item.put("information", "test");
//        item.put("id", 3);
//        item.put("name", "course1");
//        array.put(item);
//
//        json.put("accounts", array);
//
//        message = json.toString();
//
//        //create json
//        JSONArray arr = new JSONObject(builder.toString()).getJSONArray("accounts");
//        for (int i = 0; i < arr.length(); ++i) {
//            JSONObject account = arr.getJSONObject(i);
//            long clientId = account.getInt("clientId");
//            String number = account.getString("number");
//            if (rep.containsKey(clientId)) {
//                rep.get(clientId).add(new Account(number));
//            } else {
//                HashSet<Account> newSet = new HashSet<>();
//                newSet.add(new Account(number));
//                rep.put(clientId, newSet);
//            }
//        }
//        retur
//
//        Map<Long, HashSet<Account>> rep = new HashMap<>();
//        // read file and create json-file
//        StringBuilder builder = new StringBuilder("{\"accounts\":");
//        try (InputStream in = new FileInputStream(fileSRC)) {
//            builder.append(IOUtils.toString(in, StandardCharsets.UTF_8)).append("}");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//n rep;
//    }
}
