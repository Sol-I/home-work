package com.sbrf.reboot.atm.cassette;

import com.sbrf.reboot.atm.banknote.Banknote;

import java.util.ArrayList;

public class Cassette<T extends Banknote> {

    ArrayList<T> listBanknotes = new ArrayList<T>();

    public Cassette(ArrayList<T> listBanknotes) {
        this.listBanknotes = listBanknotes;
    }

    public int getCountBanknotes() {
        return listBanknotes.size();
    }
}
