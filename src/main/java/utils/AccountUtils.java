package utils;

import com.sbrf.reboot.dto.Account;

import java.util.*;

public class AccountUtils {


    public static void sortedById(List<Account> accounts) {
        accounts.sort(Comparator.comparing(Account::getId));
    }

    public static void sortedByIdDate(List<Account> accounts) {
        accounts.sort(Comparator.comparing(Account::getId).thenComparing(Account::getCreateDate));
    }


    public static void sortedByIdDateBalance(List<Account> accounts) {
        accounts.sort(Comparator.comparing(Account::getId).thenComparing(Account::getCreateDate)
                .thenComparing(Account::getBalance));
    }
}
