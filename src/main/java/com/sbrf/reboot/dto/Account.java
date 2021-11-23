package com.sbrf.reboot.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Comparator;

import static java.time.LocalDate.now;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class Account implements Comparable<Account> {
    private Long id;
    private LocalDate createDate;
    private BigDecimal balance;
    private String number;

    public Account(String number) {
        this.number = number;
        this.id = 0L;
        this.createDate = now();
        this.balance = new BigDecimal(0);
    }

    @Override
    public int compareTo(Account o) {
        if (o == null) throw new NullPointerException();

        int i = this.id.compareTo(o.getId());
        if (i != 0) return i;

        i = this.createDate.compareTo(o.getCreateDate());
        if (i != 0) return i;

        return this.balance.compareTo(o.getBalance());
    }
}
