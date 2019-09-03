package com.fine.compliertheory.demo1;

import com.fine.compliertheory.demo1.enums.TokenType;

/**
 * @author finefine at: 2019/9/3 11:23 下午
 */
public class SimpleToken implements Token {
    private TokenType type;
    private String text;

    public TokenType getType() {
        return type;
    }

    public String getText() {
        return text;
    }

    public void setType(TokenType type) {
        this.type = type;
    }

    public void setText(String text) {
        this.text = text;
    }
}
