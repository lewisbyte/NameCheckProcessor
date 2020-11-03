package com.lewisbyte.github;

import javax.annotation.processing.Messager;
import javax.lang.model.element.*;
import javax.lang.model.util.ElementScanner8;
import javax.tools.Diagnostic;


/**
 * @author lewis
 */
public class NameCheckerScanner extends ElementScanner8<Void, Void> {


    Messager messager;

    public NameCheckerScanner(Messager messager) {
        this.messager = messager;
    }

    /**
     * {@inheritDoc} This implementation scans the enclosed elements.
     *
     * @param e     {@inheritDoc}
     * @param aVoid {@inheritDoc}
     * @return the result of scanning
     */
    @Override
    public Void visitType(TypeElement e, Void aVoid) {
        scan(e.getTypeParameters(), aVoid);
        checkCamelCase(e, true);
        return super.visitType(e, aVoid);
    }

    private void checkCamelCase(Element e, boolean b) {

    }

    /**
     * {@inheritDoc} This implementation scans the parameters.
     *
     * @param e     {@inheritDoc}
     * @param aVoid {@inheritDoc}
     * @return the result of scanning
     */
    @Override
    public Void visitExecutable(ExecutableElement e, Void aVoid) {

        if (e.getKind() == ElementKind.METHOD) {
            Name name = e.getSimpleName();
            if (name.contentEquals(e.getEnclosingElement().getSimpleName())) {
                messager.printMessage(Diagnostic.Kind.WARNING, "方法与类名重复" + name);
                checkCamelCase(e, false);
            }
        }
        return super.visitExecutable(e, aVoid);
    }


    /**
     * This implementation scans the enclosed elements.
     *
     * @param e     {@inheritDoc}
     * @param aVoid {@inheritDoc}
     * @return the result of scanning
     */
    @Override
    public Void visitVariable(VariableElement e, Void aVoid) {
        return super.visitVariable(e, aVoid);
    }
}
