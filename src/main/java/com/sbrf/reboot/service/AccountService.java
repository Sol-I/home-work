package com.sbrf.reboot.service;

import com.sbrf.reboot.dto.Account;
import com.sbrf.reboot.repository.AccountRepository;
import lombok.AllArgsConstructor;

import java.util.Set;

@AllArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    public boolean isAccountExist(long l, Account account) {

        Set<Account> actual_accounts = accountRepository.getAllAccountsByClientId(l);
        return actual_accounts.contains(account);

    }
}
