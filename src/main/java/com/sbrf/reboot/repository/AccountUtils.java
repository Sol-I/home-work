package com.sbrf.reboot.repository;

import com.sbrf.reboot.dto.Account;

import java.util.*;

public class AccountUtils {


    public static void sortedById(List<Account> accounts) {
        Collections.sort(accounts);
    }

    public static void sortedByIdDate(List<Account> accounts) {
        Collections.sort(accounts);
    }
}
