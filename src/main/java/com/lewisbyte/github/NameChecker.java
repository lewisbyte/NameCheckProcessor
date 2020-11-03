package com.lewisbyte.github;

import javax.annotation.processing.Messager;
import javax.lang.model.element.Element;


/**
 * @author lewis
 */
public class NameChecker {


    private Messager messager;

    private NameCheckerScanner nameCheckerScanner;


    /**
     * 构造函数：
     * the messager used to report errors, warnings, and other
     * notices.
     */
    public NameChecker(Messager messager) {
        this.messager = messager;
        nameCheckerScanner = new NameCheckerScanner(messager);
    }


    /**
     * 按照 JSR 规范对每个语法树的节点元素做命名校验
     *
     * @param element
     */
    public void checkName(Element element) {
        nameCheckerScanner.scan(element);
    }

}
