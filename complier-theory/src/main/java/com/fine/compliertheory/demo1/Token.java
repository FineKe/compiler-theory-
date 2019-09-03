package com.fine.compliertheory.demo1;

import com.fine.compliertheory.demo1.enums.TokenType;

/**
 * @author finefine at: 2019/9/2 10:44 下午
 */
public interface Token {

    TokenType getType();

    String getText();
}
