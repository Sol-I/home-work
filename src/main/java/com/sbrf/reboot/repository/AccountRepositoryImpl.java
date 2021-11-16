package com.sbrf.reboot.repository;

import com.sbrf.reboot.dto.Account;
import lombok.AllArgsConstructor;

import java.io.*;
import java.util.*;

@AllArgsConstructor
public class AccountRepositoryImpl implements AccountRepository {

    private final String fileSRC;

    public static void main(String[] args) throws FileNotFoundException {

    }

    @Override
    public Set<Account> getAllAccountsByClientId(long l) throws FileNotFoundException {
        Map<Long, Set<Account>> repository = Loader.loadRepositoryFromFile(fileSRC);
        if (repository.containsKey(l)) return repository.get(l);
        return new HashSet<>();
    }

    @Override
    public void updateAccounts(long l, String oldNum, String newNum)
            throws FileNotFoundException {
        Map<Long, Set<Account>> repository = Loader.loadRepositoryFromFile(fileSRC);
        if (repository.containsKey(l)) {
            Set<Account> accounts = repository.get(l);
            for (Account account: accounts) {
                if (account.getNumber().equals(oldNum)) account.setNumber(newNum);
            }
        }
        Loader.saveRepositoryToFile(repository, fileSRC);
    }
}
