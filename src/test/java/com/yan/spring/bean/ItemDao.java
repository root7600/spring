package com.yan.spring.bean;

import com.yan.spring.context.annotation.Component;

@Component
public interface ItemDao {

    String queryItemName(String itemId);

}
