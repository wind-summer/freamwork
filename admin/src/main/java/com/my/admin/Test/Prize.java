package com.my.admin.Test;

/**
 * @author wenlf
 * @since 2018/5/5
 * 奖品实体类
 */
public class Prize {

    private String name;
    private Double odds;

    public Prize(String name, Double odds) {
        this.name = name;
        this.odds = odds;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getOdds() {
        return odds;
    }

    public void setOdds(Double odds) {
        this.odds = odds;
    }
}
