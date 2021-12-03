package com.sbrf.reboot.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;


@AllArgsConstructor
@Getter
@Setter
@Builder
public class Account implements Comparable<Account> {
    private String number;
    private Long id;
    private Long clientId;
    private LocalDate createDate;
    private BigDecimal balance;

    public Account(String number) {
        this(number, 0L, 0L, LocalDate.now(), BigDecimal.ZERO);
    }

    @Override
    public int compareTo(Account o) {
        int i = this.id.compareTo(o.getId());
        if (i != 0) return i;

        i = this.createDate.compareTo(o.getCreateDate());
        if (i != 0) return i;

        return this.balance.compareTo(o.getBalance());
    }
}
