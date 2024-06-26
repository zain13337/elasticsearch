/*
 * Copyright Elasticsearch B.V. and/or licensed to Elasticsearch B.V. under one
 * or more contributor license agreements. Licensed under the Elastic License
 * 2.0; you may not use this file except in compliance with the Elastic License
 * 2.0.
 */

package org.elasticsearch.xpack.esql.core.expression.gen.pipeline;

import org.elasticsearch.xpack.esql.core.expression.Expression;
import org.elasticsearch.xpack.esql.core.expression.gen.processor.Processor;
import org.elasticsearch.xpack.esql.core.tree.Source;

import java.util.ArrayList;
import java.util.List;

public abstract class MultiPipe extends Pipe {

    protected MultiPipe(Source source, Expression expression, List<Pipe> children) {
        super(source, expression, children);
    }

    @Override
    public Processor asProcessor() {
        List<Processor> procs = new ArrayList<>();
        for (Pipe pipe : children()) {
            procs.add(pipe.asProcessor());
        }

        return asProcessor(procs);
    }

    public abstract Processor asProcessor(List<Processor> procs);
}
