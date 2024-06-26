/*
 * Copyright Elasticsearch B.V. and/or licensed to Elasticsearch B.V. under one
 * or more contributor license agreements. Licensed under the Elastic License
 * 2.0; you may not use this file except in compliance with the Elastic License
 * 2.0.
 */
package org.elasticsearch.xpack.esql.core.expression.function.grouping;

import org.elasticsearch.xpack.esql.core.expression.Expression;
import org.elasticsearch.xpack.esql.core.expression.function.Function;
import org.elasticsearch.xpack.esql.core.expression.gen.pipeline.AggNameInput;
import org.elasticsearch.xpack.esql.core.expression.gen.pipeline.Pipe;
import org.elasticsearch.xpack.esql.core.tree.Source;
import org.elasticsearch.xpack.esql.core.util.CollectionUtils;

import java.util.List;
import java.util.Objects;

import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;

/**
 * A type of {@code Function} that creates groups or buckets.
 */
public abstract class GroupingFunction extends Function {

    private final Expression field;
    private final List<Expression> parameters;

    protected GroupingFunction(Source source, Expression field) {
        this(source, field, emptyList());
    }

    protected GroupingFunction(Source source, Expression field, List<Expression> parameters) {
        super(source, CollectionUtils.combine(singletonList(field), parameters));
        this.field = field;
        this.parameters = parameters;
    }

    public Expression field() {
        return field;
    }

    public List<Expression> parameters() {
        return parameters;
    }

    @Override
    protected Pipe makePipe() {
        // unresolved AggNameInput (should always get replaced by the folder)
        return new AggNameInput(source(), this, sourceText());
    }

    @Override
    public boolean equals(Object obj) {
        if (false == super.equals(obj)) {
            return false;
        }
        GroupingFunction other = (GroupingFunction) obj;
        return Objects.equals(other.field(), field()) && Objects.equals(other.parameters(), parameters());
    }

    @Override
    public int hashCode() {
        return Objects.hash(field(), parameters());
    }
}
