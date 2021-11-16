package com.sbrf.reboot.repository;

import com.sbrf.reboot.dto.Account;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Loader {

    public static Map<Long, Set<Account>> loadRepositoryFromFile(String fileSRC) throws FileNotFoundException {

        Map<Long, Set<Account>> repository = new HashMap<>();

        InputStream in = new FileInputStream(fileSRC);
        BufferedReader reader = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));

        //reading file
        String str;
        StringBuilder txtFile = new StringBuilder();
        try {
            while ((str = reader.readLine()) != null) txtFile.append(str);
            reader.close();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //parsing file
        Pattern pattern = Pattern.compile("\"clientId\": (.*?),(.*?)\"number\": \"(.*?)\"");
        Matcher matcher = pattern.matcher(txtFile.toString());
        Long clientId;
        String number;
        while (matcher.find()) {
            clientId = Long.valueOf(matcher.group(1));
            number = matcher.group(3);
            if (!repository.containsKey(clientId)) repository.put(clientId, new HashSet<>());
            repository.get(clientId).add(new Account(number));
        }

        return repository;
    }

    public static void saveRepositoryToFile(Map<Long, Set<Account>> repository, String fileSRC) {

        if (repository.size() > 0) {
            StringBuilder txtFile = new StringBuilder("[\n");
            for (Map.Entry<Long, Set<Account>> clientId : repository.entrySet()) {
                for (Account account : clientId.getValue()) {
                    txtFile.append("  {\n    \"clientId\": ").append(clientId.getKey()).append(",\n");
                    txtFile.append("    \"number\": \"").append(account.getNumber()).append("\"\n  },\n");
                }
            }
            if (txtFile.length() > 0) {
                txtFile.deleteCharAt(txtFile.length() - 2);
                txtFile.append("]");
            }

            BufferedWriter writer;
            try {
                writer = new BufferedWriter(new FileWriter(fileSRC));
                writer.write(txtFile.toString());
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
