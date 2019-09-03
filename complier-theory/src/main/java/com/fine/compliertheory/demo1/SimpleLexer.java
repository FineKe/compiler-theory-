package com.fine.compliertheory.demo1;

import com.fine.compliertheory.demo1.enums.TokenType;

import java.util.ArrayList;
import java.util.List;

/**
 * @author finefine at: 2019/9/3 11:22 下午
 */
public class SimpleLexer {


    StringBuffer tokenText = new StringBuffer();
    List<Token> tokens = new ArrayList<Token>();
    SimpleToken simpleToken = null;

    public static void main(String[] args) {

        String script = "age >= 45";




    }

    private void parseToken(char[] chars) {

        TokenType initalState = initInital(chars[0]);

        for (int i = 1; i < chars.length; i++) {
            switch (initalState) {
                case Inital:
                    initalState = initInital(chars[i]);
                    break;
                case Id:
                    if (isAlpha(chars[i]) || isDigit(chars[i])) {
                        tokenText.append(chars[i]);
                    } else {
                        initalState = TokenType.Inital;
                    }
                    break;
                case IntLiteral:
                    if (isDigit(chars[i])) {
                        tokenText.append(chars[i]);
                    } else {
                        initalState = TokenType.Inital;
                    }
                    break;
                case GT:
                    if ('=' == chars[i]) {
                        initalState = TokenType.GE;
                    } else {
                        initalState = TokenType.Inital;
                    }
                case GE:
                    initalState = initInital(chars[i]);
                    break;
            }
        }
    }

    private TokenType initInital(char c) {
        if (tokenText.length()>0) {
            simpleToken.setText(tokenText.toString());
            tokens.add(simpleToken);
            tokenText.setLength(0);
            simpleToken = new SimpleToken();
        }

        if (isAlpha(c)) {
            simpleToken.setType(TokenType.Id);
            tokenText.append(c);
        } else if (isDigit(c)) {
            simpleToken.setType(TokenType.IntLiteral);
            tokenText.append(c);
        } else {
            simpleToken.setType(TokenType.GE);
            tokenText.append(c);
        }
        return simpleToken.getType();
    }

    /**
     * 是否是字母
     * @param c
     * @return
     */
    private boolean isAlpha(char c) {
        if ('a' <= c && c <= 'z' || 'A' <= c && c <= 'Z') {
            return true;
        }
        return false;
    }

    /**
     * 判断是否是数字
     * @param c
     * @return
     */
    private boolean isDigit(char c) {
        if ('0' <= c && c <= '9') {
            return true;
        }
        return false;
    }

    /**
     * 判断是否是空白
     * @param c
     * @return
     */
    private boolean isBlank(char c) {
        if (' ' == c || '\t' == c || '\n' == c) {
            return true;
        }
        return false;
    }

}
