package com.sbrf.reboot.service;

import java.util.HashSet;
import java.util.Set;

public interface AccountRepository {
    Set<Account> getAllAccountsByClientId(long l);
}
