package com.lewisbyte.github;

import javax.annotation.processing.Messager;
import javax.lang.model.element.Element;

public class NameChecker {


    private Messager messager;

    public NameChecker(Messager messager) {
        this.messager = messager;
    }

    public void checkName(Element element) {


    }

}
