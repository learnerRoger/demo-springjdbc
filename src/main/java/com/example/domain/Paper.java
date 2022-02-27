package com.example.domain;

public class Paper {
    String pno;
    String pna;

    public String getPno() {
        return pno;
    }

    public void setPno(String pno) {
        this.pno = pno;
    }

    public String getPna() {
        return pna;
    }

    public void setPna(String pna) {
        this.pna = pna;
    }

    @Override
    public String toString() {
        return "Paper{" +
                "pno='" + pno + '\'' +
                ", pna='" + pna + '\'' +
                '}';
    }
}
