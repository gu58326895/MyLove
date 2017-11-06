package com.darcytech.model;

/**
 * Created by guxiaoli on 19/05/2017.
 */
public class Trade {


    private Long tid;

    private Long userId;

    private String sellerNick;

    public Long getTid() {
        return tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getSellerNick() {
        return sellerNick;
    }

    public void setSellerNick(String sellerNick) {
        this.sellerNick = sellerNick;
    }
}
