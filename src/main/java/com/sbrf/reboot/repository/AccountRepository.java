package com.sbrf.reboot.repository;

import com.sbrf.reboot.dto.Account;

import java.io.FileNotFoundException;
import java.util.Set;

public interface AccountRepository {
    Set<Account> getAllAccounts() throws FileNotFoundException;
    Set<Account> getAllAccountsByClientId(long l) throws FileNotFoundException;
    void updateAccounts(long clientId, String oldNum, String newNum) throws FileNotFoundException;
}
