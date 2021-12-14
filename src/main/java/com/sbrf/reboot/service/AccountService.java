package com.sbrf.reboot.service;

import com.sbrf.reboot.dto.Account;
import com.sbrf.reboot.repository.AccountRepository;
import lombok.AllArgsConstructor;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@AllArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    public boolean isAccountExist(long l, Account account) throws FileNotFoundException {

        Set<Account> actual_accounts = accountRepository.getAllAccountsByClientId(l);
        return actual_accounts.contains(account);

    }

    public Account getMaxAccountBalance(long l) throws FileNotFoundException {
        if (accountRepository.getAllAccountsByClientId(l).size() == 0)
            throw new RuntimeException("Repository is empty");
        return accountRepository.getAllAccountsByClientId(l).stream()
                .max(Comparator.comparing(Account::getBalance)).get();
    }

    public Set<Account> getAllAccountsByDateMoreThen(long l, LocalDate minusDays) throws FileNotFoundException {
        return accountRepository.getAllAccountsByClientId(l).stream()
                .filter(x -> x.getCreateDate().isAfter(minusDays.minusDays(1)))
                .collect(Collectors.toSet());
    }

    public Set<Long> getClientIdWithMaxContributions() throws FileNotFoundException {

        Map<Long, BigDecimal> groupClientByContribution =
                accountRepository.getAllAccounts().stream().
                        collect(Collectors.groupingBy(
                                Account::getClientId,
                                Collectors.reducing(
                                        BigDecimal.ZERO,
                                        Account::getBalance,
                                        BigDecimal::add)));

        if (groupClientByContribution.size() == 0) return new HashSet<>();

        BigDecimal maxContribution = groupClientByContribution.entrySet().stream().
                max(Map.Entry.comparingByValue()).get().getValue();

        return groupClientByContribution.entrySet().stream().
                filter(e -> e.getValue().equals(maxContribution)).
                map(Map.Entry::getKey).
                collect(Collectors.toSet());
    }
}
